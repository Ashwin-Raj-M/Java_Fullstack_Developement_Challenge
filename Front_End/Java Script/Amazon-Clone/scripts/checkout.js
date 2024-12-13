import * as myCart from '../data/cart.js';
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
              Quantity: <span class="quantity-label">
                ${quantity}
              </span>
            </span>
            <span class="update-quantity-link link-primary" data-product-id = "${product.id}">
              Update
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
