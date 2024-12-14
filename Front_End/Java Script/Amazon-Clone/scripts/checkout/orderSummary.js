import * as myCart from '../../data/cart.js';
import * as myProducts from '../../data/products.js';
import * as myOptions from '../../data/deliveryOptions.js';
import formatMoney from '../utils/money.js';
import * as date from '../utils/date.js'
import renderItemCountHeader from './checkoutHeader.js';
import * as paymentSummary from './paymentSummary.js'

// Function to render order summary container
export function renderOrderSummary(product, quantity, deliveryOption) {

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

  myOptions.deliveryOptions.forEach(deliveryOption => {
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

// Function to retrieve data from cart
export function retriveCartData() {

  const orderSummaryContainer = document.querySelector('.js-order-summary');
  
  let orderSummaryHtml = ``;
  let totalCheckoutCost = 0;
  const totalQuantity = myCart.getCartQuantity();
  let totalShippingCost = 0;

  myCart.cart.forEach((cartProduct) => {
    const quantity = cartProduct.productQuantity;
    const product = myProducts.findProduct(cartProduct.productId);
    const deliveryOption = myOptions.findDeliveryOption(cartProduct.deliveryOption);

    // console.log(deliveryOption);
    

    if (product) {
      orderSummaryHtml += renderOrderSummary(product, quantity, deliveryOption);
      totalCheckoutCost += product.pricePiase * quantity;
      totalShippingCost += deliveryOption.shippingCostPiase;
    }
  });

  orderSummaryContainer.innerHTML = orderSummaryHtml;
  // renderPaymentSummary(totalCheckoutCost, totalShippingCost, totalQuantity);
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
      paymentSummary.renderPaymentSummary();
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
      const product = myCart.findCartProduct(productId);
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
      paymentSummary.renderPaymentSummary();
    });
  });

  deliveryOptionRadios.forEach(deliveryOptionRadio => {
    deliveryOptionRadio.addEventListener('click', () => {
      myCart.updateDeliveryOption(deliveryOptionRadio.name, Number(deliveryOptionRadio.value));

      console.log(myCart.cart);
      retriveCartData();
      paymentSummary.renderPaymentSummary();
    });
  });

}