import * as myCart from '../data/cart.js';
import * as myProducts from '../data/products.js';
import { formatMoney } from './utils/money.js';
import deliveryOptions from '../data/deliveryOptions.js';
import * as date from './utils/date.js'


console.log(myCart.cart);

// Function to render order summary container
function renderOrderSummary(product, quantity, deliveryOption) {

  return `
    <div class="cart-item-container cart-item-container-${product.id}">
      <div class="delivery-date">
        Delivery date: ${date.dateFormatter(deliveryOption.shippingDays)}
      </div>

      <div class="cart-item-details-grid">
        <img class="product-image" src="${product.image}">

        <div class="cart-item-details">
          <div class="product-name">
            ${product.name}
          </div>
          <div class="product-price">
            ₹${formatMoney(product.pricePiase)}
          </div>
          <div class="product-quantity">
            <span>
              Quantity: <span class="quantity-label">
                <span class="quantity-label-number" data-product-id="${product.id}">${quantity}</span>
                <input type="number" class="new-quantity-input hide-class" value="${quantity}" data-product-id="${product.id}">
              </span>
            </span>
            <span class="update-quantity-link link-primary" data-product-id="${product.id}">
              Update
            </span>
            <span class="save-quantity-link hide-class link-primary" data-product-id="${product.id}">
              Save
            </span>
            <span class="delete-quantity-link link-primary" data-product-id="${product.id}">
              Delete
            </span>
          </div>
        </div>

        <div class="delivery-options">
          <div class="delivery-options-title">
            Choose a delivery option:
          </div>
          ${renderDeliverOptions(product, deliveryOption.id)}
        </div>
      </div>
    </div>
  `;
}

//  function to render delivery options
function renderDeliverOptions(product, deliveryOptionId){
  let deliveryHtml = ``;

  const toChecked = (id) => id === deliveryOptionId ? `checked` : ``;

  const shippingCostString = (deliveryOption) => deliveryOption.shippingCostPiase === 0 ? `FREE` : `₹${formatMoney(deliveryOption.shippingCostPiase)}`; 

  deliveryOptions.forEach(deliveryOption => {
    deliveryHtml += `
    <div class="delivery-option">
      <input type="radio" ${toChecked(deliveryOption.id)} class="delivery-option-input" value="${deliveryOption.id}" name="${product.id}">
      <div>
        <div class="delivery-option-date">
          ${date.dateFormatter(deliveryOption.shippingDays)}
        </div>
        <div class="delivery-option-price">
          ${shippingCostString(deliveryOption)} Shipping
        </div>
      </div>
    </div>
    `
  });
  return deliveryHtml;
}

// Function to render payment summary
function renderPaymentSummary(totalCheckoutCost, totalShippingCost, totalQuantity) {
  const paymentSummaryHtml = `
    <div class="payment-summary">
      <div class="payment-summary-title">
        Order Summary
      </div>

      <div class="payment-summary-row">
        <div>Items (${totalQuantity}):</div>
        <div class="payment-summary-money">₹${formatMoney(totalCheckoutCost)}</div>
      </div>

      <div class="payment-summary-row">
        <div>Shipping &amp; handling:</div>
        <div class="payment-summary-money">₹${formatMoney(totalShippingCost)}</div>
      </div>

      <div class="payment-summary-row subtotal-row">
        <div>Total before tax:</div>
        <div class="payment-summary-money">₹${formatMoney(totalCheckoutCost + totalShippingCost)}</div>
      </div>

      <div class="payment-summary-row">
        <div>Estimated tax (10%):</div>
        <div class="payment-summary-money">₹${formatMoney((totalCheckoutCost + totalShippingCost) / 10)}</div>
      </div>

      <div class="payment-summary-row total-row">
        <div>Order total:</div>
        <div class="payment-summary-money">₹${formatMoney(totalCheckoutCost + totalShippingCost + (totalCheckoutCost + totalShippingCost) / 10)}</div>
      </div>

      <button class="place-order-button button-primary">
        Place your order
      </button>
    </div>
  `;
  paymentSummary.innerHTML = paymentSummaryHtml;
}

// Function to render item count at Header
function renderItemCountHeader(totalQuantity) {
  itemCountHeader.innerHTML = `${totalQuantity} items`;
}

// Function to retrieve data from cart
function retriveCartData() {
  let orderSummaryHtml = ``;
  let totalCheckoutCost = 0;
  const totalQuantity = myCart.cart.reduce((total, cartProduct) => total + cartProduct.productQuantity, 0);
  let totalShippingCost = 0;

  myCart.cart.forEach((cartProduct) => {
    const id = cartProduct.productId;
    const quantity = cartProduct.productQuantity;
    const product = myProducts.products.find((product) => id === product.id);
    const deliveryOption = deliveryOptions.find(Option => cartProduct.deliveryOption === Option.id);

    // console.log(cartProduct.deliveryOption);

    if (product) {
      orderSummaryHtml += renderOrderSummary(product, quantity, deliveryOption);
      totalCheckoutCost += product.pricePiase * quantity;
      totalShippingCost += deliveryOption.shippingCostPiase;
    }
  });

  orderSummaryContainer.innerHTML = orderSummaryHtml;
  renderPaymentSummary(totalCheckoutCost, totalShippingCost, totalQuantity);
  renderItemCountHeader(totalQuantity);
  attachEventListeners();
}

// Function to attach event listeners
function attachEventListeners() {
  const deleteButtons = document.querySelectorAll('.delete-quantity-link');
  const updateButtons = document.querySelectorAll('.update-quantity-link');
  const saveButtons = document.querySelectorAll('.save-quantity-link');
  const deliveryOptionRadios = document.querySelectorAll('.delivery-option-input');

  deleteButtons.forEach((deleteButton) => {
    deleteButton.addEventListener('click', () => {
      const productId = deleteButton.dataset.productId;
      myCart.removeFromCart(productId);
      document.querySelector(`.cart-item-container-${productId}`).remove();
      retriveCartData();
    });
  });

  updateButtons.forEach((updateButton) => {
    updateButton.addEventListener('click', () => {
      const productId = updateButton.dataset.productId;
      const quantityLabelNumber = document.querySelector(`.quantity-label-number[data-product-id='${productId}']`);
      const saveButton = document.querySelector(`.save-quantity-link[data-product-id='${productId}']`);
      const newQuantityInput = document.querySelector(`.new-quantity-input[data-product-id='${productId}']`);

      saveButton.classList.remove('hide-class');
      updateButton.classList.add('hide-class');
      newQuantityInput.classList.remove('hide-class');
      quantityLabelNumber.classList.add('hide-class');
    });
  });

  saveButtons.forEach((saveButton) => {
    saveButton.addEventListener('click', () => {
      const productId = saveButton.dataset.productId;
      const product = myCart.cart.find((product) => product.productId == productId);
      const quantityLabelNumber = document.querySelector(`.quantity-label-number[data-product-id='${productId}']`);
      const updateButton = document.querySelector(`.update-quantity-link[data-product-id='${productId}']`);
      const newQuantityInput = document.querySelector(`.new-quantity-input[data-product-id='${productId}']`);

      const newQuantity = parseInt(newQuantityInput.value.trim(), 10);
      if (newQuantity > 0) {
        product.productQuantity = newQuantity;
      }

      saveButton.classList.add('hide-class');
      updateButton.classList.remove('hide-class');
      newQuantityInput.classList.add('hide-class');
      quantityLabelNumber.classList.remove('hide-class');

      retriveCartData();
    });
  });

  deliveryOptionRadios.forEach(deliveryOptionRadio => {
    deliveryOptionRadio.addEventListener('click', () => {
      myCart.updateDeliveryOption(deliveryOptionRadio.name, Number(deliveryOptionRadio.value));

      console.log(myCart.cart);
      retriveCartData();
    });
  });

}

// DOM Elements
const orderSummaryContainer = document.querySelector('.js-order-summary');
const paymentSummary = document.querySelector('.payment-summary');
const itemCountHeader = document.querySelector('.return-to-home-link');

// Initialize rendering
retriveCartData();



/*import * as myCart from '../data/cart.js';
import * as myProducts from '../data/products.js';
import { formatMoney } from './utils/money.js';

// console.log(myCart.cart);

// function to render order summary container
function renderOrderSummary(product, quantity){
  
  return `
    <div class="cart-item-container cart-item-container-${product.id}">
      <div class="delivery-date">
        Delivery date: Tuesday, June 21
      </div>

      <div class="cart-item-details-grid">
        <img class="product-image"
          src="${product.image}">

        <div class="cart-item-details">
          <div class="product-name">
            ${product.name}
          </div>
          <div class="product-price">
            ₹${formatMoney(product.pricePiase)}
          </div>
          <div class="product-quantity">
            <span>
              Quantity: <span class="quantity-label" >
                <span class="quantity-label-number" data-product-id = "${product.id}">${quantity}</span>
                <input type="number" class="new-quantity-input hide-class" value="${quantity}" data-product-id = "${product.id}">
              </span>
            </span>
            <span class="update-quantity-link link-primary" data-product-id = "${product.id}">
              Update
            </span>
            <span class="save-quantity-link hide-class link-primary" data-product-id = "${product.id}">
              Save
            </span>
            <span class="delete-quantity-link link-primary" data-product-id = "${product.id}">
              Delete
            </span>
          </div>
        </div>

        <div class="delivery-options">
          <div class="delivery-options-title">
            Choose a delivery option:
          </div>
          <div class="delivery-option">
            <input type="radio" 
              class="delivery-option-input"
              name="delivery-option-${product.id}">
            <div>
              <div class="delivery-option-date">
                Tuesday, June 21
              </div>
              <div class="delivery-option-price">
                FREE Shipping
              </div>
            </div>
          </div>
          <div class="delivery-option">
            <input type="radio"
              class="delivery-option-input"
              name="delivery-option-${product.id}">
            <div>
              <div class="delivery-option-date">
                Wednesday, June 15
              </div>
              <div class="delivery-option-price">
                ₹4.99 - Shipping
              </div>
            </div>
          </div>
          <div class="delivery-option">
            <input type="radio" checked
              class="delivery-option-input"
              name="delivery-option-${product.id}">
            <div>
              <div class="delivery-option-date">
                Monday, June 13
              </div>
              <div class="delivery-option-price">
                ₹9.99 - Shipping
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  `  
}

// function to render order summary container
function renderPaymentSummary(totalCheckoutCost, totalQuantity){
  
  let paymentSummaryHtml = `
  <div class="payment-summary">
    <div class="payment-summary-title">
      Order Summary
    </div>

    <div class="payment-summary-row">
      <div>Items (${totalQuantity}):</div>
      <div class="payment-summary-money">₹${formatMoney(totalCheckoutCost)}</div>
    </div>

    <div class="payment-summary-row">
      <div>Shipping &amp; handling:</div>
      <div class="payment-summary-money">₹4.99</div>
    </div>

    <div class="payment-summary-row subtotal-row">
      <div>Total before tax:</div>
      <div class="payment-summary-money">₹${formatMoney(totalCheckoutCost + 499)}</div>
    </div>

    <div class="payment-summary-row">
      <div>Estimated tax (10%):</div>
      <div class="payment-summary-money">₹${formatMoney((totalCheckoutCost + 499) / 10)}</div>
    </div>

    <div class="payment-summary-row total-row">
      <div>Order total:</div>
      <div class="payment-summary-money">₹${formatMoney(totalCheckoutCost + 499 + (totalCheckoutCost + 499) / 10)}</div>
    </div>

    <button class="place-order-button button-primary">
      Place your order
    </button>
  </div>
  `
  paymentSummary.innerHTML = paymentSummaryHtml;
}

// Function to render item count at Header
function renderItemCountHeader(totalQuantity){
  itemCountHeader.innerHTML = `${totalQuantity} items`
}

// Rendering checkout summary
const orderSummaryContainer = document.querySelector('.js-order-summary');
const paymentSummary = document.querySelector('.payment-summary');
const itemCountHeader = document.querySelector('.return-to-home-link');
retriveCartData();

//DOM Elements
const deleteButtons = document.querySelectorAll('.delete-quantity-link');
const updateButtons = document.querySelectorAll('.update-quantity-link');
const saveButtons = document.querySelectorAll('.save-quantity-link');
const quantityLabelNumbers = document.querySelectorAll('.quantity-label-number');
const newQuantityInputs = document.querySelectorAll('.new-quantity-input');

// Function to retrive data from cart
function retriveCartData(){

  let orderSummaryHtml = ``;
  let totalCheckoutCost = 0;
  const totalQuantity = myCart.cart.reduce(((total, cartProduct) => total += cartProduct.productQuantity), 0);

  // console.log(myCart.cart.reduce((total, cartProduct) => total = cartProduct.quantity));

  myCart.cart.forEach((cartProduct) => {
    const id = cartProduct.productId;
    const quantity = cartProduct.productQuantity;

    // finding the product form "products" array using id
    const product = myProducts.products.find((product) => id === product.id);

    if(product){
      // console.log(product);
      orderSummaryHtml += renderOrderSummary(product, quantity);

      // Accumilation the cost of all products
      totalCheckoutCost += product.pricePiase * quantity;
    }
  });

  // console.log(totalCheckoutCost/100);

  // rendering the payment summary
  renderPaymentSummary(totalCheckoutCost, totalQuantity);

  // rendering the item count at Header
  renderItemCountHeader(totalQuantity);

  orderSummaryContainer.innerHTML = orderSummaryHtml;
}

// Event listeners
deleteButtons.forEach((deleteButton) => {
  deleteButton.addEventListener('click', () => {
    const productId = deleteButton.dataset.productId;
    myCart.removeFromCart(productId);
    // console.log(myCart.cart);
    document.querySelector(`.cart-item-container-${productId}`).remove();
  });
});

updateButtons.forEach((updateButton) => {
  updateButton.addEventListener('click', () => {

    const productId = updateButton.dataset.productId;
    const quantityLabelNumber = Array.from(quantityLabelNumbers).find(label => label.dataset.productId == productId);
    const saveButton = Array.from(saveButtons).find(saveButton => saveButton.dataset.productId == productId);
    const newQuantityInput = Array.from(newQuantityInputs).find(input => input.dataset.productId == productId);

    saveButton.classList.remove('hide-class');
    updateButton.classList.add('hide-class');
    newQuantityInput.classList.remove('hide-class');
    quantityLabelNumber.classList.add('hide-class');

  });
});

saveButtons.forEach((saveButton) => {
  saveButton.addEventListener('click', () => {

    const productId = saveButton.dataset.productId;
    const product = Array.from(myCart.cart).find(product => product.productId == productId);
    const quantityLabelNumber = Array.from(quantityLabelNumbers).find(label => label.dataset.productId == productId);
    const updateButton = Array.from(updateButtons).find(updateButton => updateButton.dataset.productId == productId);
    const newQuantityInput = Array.from(newQuantityInputs).find(input => input.dataset.productId == productId);

    const newQuantity = newQuantityInput.value.trim();
    product.productQuantity = newQuantity;

    saveButton.classList.add('hide-class');
    updateButton.classList.remove('hide-class');
    newQuantityInput.classList.add('hide-class');
    quantityLabelNumber.classList.remove('hide-class');

    retriveCartData();
  });
});
*/

// best wat to wrie this code:
/* 
import * as myCart from '../data/cart.js';
import * as myProducts from '../data/products.js';
import { formatMoney } from './utils/money.js';

// Function to render order summary container
function renderOrderSummary(product, quantity) {
  return `
    <div class="cart-item-container cart-item-container-${product.id}">
      <div class="delivery-date">
        Delivery date: Tuesday, June 21
      </div>

      <div class="cart-item-details-grid">
        <img class="product-image" src="${product.image}">

        <div class="cart-item-details">
          <div class="product-name">
            ${product.name}
          </div>
          <div class="product-price">
            ₹${formatMoney(product.pricePiase)}
          </div>
          <div class="product-quantity">
            <span>
              Quantity: <span class="quantity-label">
                <span class="quantity-label-number" data-product-id="${product.id}">${quantity}</span>
                <input type="number" class="new-quantity-input hide-class" value="${quantity}" data-product-id="${product.id}">
              </span>
            </span>
            <span class="update-quantity-link link-primary" data-action="update" data-product-id="${product.id}">
              Update
            </span>
            <span class="save-quantity-link hide-class link-primary" data-action="save" data-product-id="${product.id}">
              Save
            </span>
            <span class="delete-quantity-link link-primary" data-action="delete" data-product-id="${product.id}">
              Delete
            </span>
          </div>
        </div>

        <div class="delivery-options">
          <div class="delivery-options-title">
            Choose a delivery option:
          </div>
          <div class="delivery-option">
            <input type="radio" class="delivery-option-input" name="delivery-option-${product.id}">
            <div>
              <div class="delivery-option-date">
                Tuesday, June 21
              </div>
              <div class="delivery-option-price">
                FREE Shipping
              </div>
            </div>
          </div>
          <div class="delivery-option">
            <input type="radio" class="delivery-option-input" name="delivery-option-${product.id}">
            <div>
              <div class="delivery-option-date">
                Wednesday, June 15
              </div>
              <div class="delivery-option-price">
                ₹4.99 - Shipping
              </div>
            </div>
          </div>
          <div class="delivery-option">
            <input type="radio" checked class="delivery-option-input" name="delivery-option-${product.id}">
            <div>
              <div class="delivery-option-date">
                Monday, June 13
              </div>
              <div class="delivery-option-price">
                ₹9.99 - Shipping
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  `;
}

// Function to render payment summary
function renderPaymentSummary(totalCheckoutCost, totalQuantity) {
  const paymentSummaryHtml = `
    <div class="payment-summary">
      <div class="payment-summary-title">
        Order Summary
      </div>

      <div class="payment-summary-row">
        <div>Items (${totalQuantity}):</div>
        <div class="payment-summary-money">₹${formatMoney(totalCheckoutCost)}</div>
      </div>

      <div class="payment-summary-row">
        <div>Shipping &amp; handling:</div>
        <div class="payment-summary-money">₹4.99</div>
      </div>

      <div class="payment-summary-row subtotal-row">
        <div>Total before tax:</div>
        <div class="payment-summary-money">₹${formatMoney(totalCheckoutCost + 499)}</div>
      </div>

      <div class="payment-summary-row">
        <div>Estimated tax (10%):</div>
        <div class="payment-summary-money">₹${formatMoney((totalCheckoutCost + 499) / 10)}</div>
      </div>

      <div class="payment-summary-row total-row">
        <div>Order total:</div>
        <div class="payment-summary-money">₹${formatMoney(totalCheckoutCost + 499 + (totalCheckoutCost + 499) / 10)}</div>
      </div>

      <button class="place-order-button button-primary">
        Place your order
      </button>
    </div>
  `;
  paymentSummary.innerHTML = paymentSummaryHtml;
}

// Function to render item count at Header
function renderItemCountHeader(totalQuantity) {
  itemCountHeader.innerHTML = `${totalQuantity} items`;
}

// Function to retrieve data from cart
function retriveCartData() {
  let orderSummaryHtml = ``;
  let totalCheckoutCost = 0;
  const totalQuantity = myCart.cart.reduce((total, cartProduct) => total + cartProduct.productQuantity, 0);

  myCart.cart.forEach((cartProduct) => {
    const id = cartProduct.productId;
    const quantity = cartProduct.productQuantity;
    const product = myProducts.products.find((product) => id === product.id);

    if (product) {
      orderSummaryHtml += renderOrderSummary(product, quantity);
      totalCheckoutCost += product.pricePiase * quantity;
    }
  });

  orderSummaryContainer.innerHTML = orderSummaryHtml;
  renderPaymentSummary(totalCheckoutCost, totalQuantity);
  renderItemCountHeader(totalQuantity);
}

// Event delegation for handling cart actions
orderSummaryContainer.addEventListener('click', (event) => {
  const action = event.target.dataset.action;
  const productId = event.target.dataset.productId;

  if (!action || !productId) return;

  if (action === 'delete') {
    myCart.removeFromCart(productId);
    document.querySelector(`.cart-item-container-${productId}`).remove();
    retriveCartData();
  }

  if (action === 'update') {
    const quantityLabelNumber = document.querySelector(`.quantity-label-number[data-product-id='${productId}']`);
    const saveButton = document.querySelector(`.save-quantity-link[data-product-id='${productId}']`);
    const newQuantityInput = document.querySelector(`.new-quantity-input[data-product-id='${productId}']`);

    saveButton.classList.remove('hide-class');
    event.target.classList.add('hide-class');
    newQuantityInput.classList.remove('hide-class');
    quantityLabelNumber.classList.add('hide-class');
  }

  if (action === 'save') {
    const product = myCart.cart.find((product) => product.productId == productId);
    const quantityLabelNumber = document.querySelector(`.quantity-label-number[data-product-id='${productId}']`);
    const updateButton = document.querySelector(`.update-quantity-link[data-product-id='${productId}']`);
    const newQuantityInput = document.querySelector(`.new-quantity-input[data-product-id='${productId}']`);

    const newQuantity = parseInt(newQuantityInput.value.trim(), 10);
    if (newQuantity > 0) {
      product.productQuantity = newQuantity;
    }

    event.target.classList.add('hide-class');
    updateButton.classList.remove('hide-class');
    newQuantityInput.classList.add('hide-class');
    quantityLabelNumber.classList.remove('hide-class');

    retriveCartData();
  }
});

// DOM Elements
const orderSummaryContainer = document.querySelector('.js-order-summary');
const paymentSummary = document.querySelector('.payment-summary');
const itemCountHeader = document.querySelector('.return-to-home-link');

// Initialize rendering
retriveCartData();

*/