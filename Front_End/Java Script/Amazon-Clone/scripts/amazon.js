// Importing nessary data
import * as myCart from '../data/cart.js'
import { products } from '../data/products.js';
import formatMoney from './utils/money.js';

// Function to render the Product Griid
function renderProductGrid(){
  let productsHtml =``;

  products.forEach((product) => {
    productsHtml += `
      <div class="product-container">
        <div class="product-image-container">
          <img class="product-image"
            src=${product.image}>
        </div>

        <div class="product-name limit-text-to-2-lines">
          ${product.name}
        </div>

        <div class="product-rating-container">
          <img class="product-rating-stars"
            src="images/ratings/rating-${(product.rating.stars) * 10}.png">
          <div class="product-rating-count link-primary">
            ${product.rating.count}
          </div>
        </div>

        <div class="product-price">
          ₹${formatMoney(product.pricePiase)}
        </div>

        <div class="product-quantity-container">
          <select class="js-quantity-selector" data-product-id = "${product.id}">
            <option selected product="1">1</option>
            <option product="2">2</option>
            <option product="3">3</option>
            <option product="4">4</option>
            <option product="5">5</option>
            <option product="6">6</option>
            <option product="7">7</option>
            <option product="8">8</option>
            <option product="9">9</option>
            <option product="10">10</option>
          </select>
        </div>

        <div class="product-spacer"></div>

        <div class="added-to-cart added-to-cart-hide" data-product-id = "${product.id}">
          <img src="images/icons/checkmark.png">
          Added
        </div>

        <button class="add-to-cart-button button-primary js-add-to-cart"
        data-product-id = "${product.id}">
          Add to Cart
        </button>
      </div>
    `
  });
  productGrid.innerHTML = productsHtml;
}

// Function to render cart quantity indicator
function renderCartQuantity(){
  cartQuantityIndicator.innerHTML = myCart.cart.reduce((total,obj) => total += obj.productQuantity, 0);
}

// function to show the added text
function showAdded(productId){
  const addedIndicator = Array.from(addedIndicators).find(obj => obj.dataset.productId === productId);
  if(addedIndicator != undefined){
    addedIndicator.classList.remove('added-to-cart-hide');
  }
  setTimeout(() => {
    addedIndicator.classList.add('added-to-cart-hide')
  }, 1000);
}

// Rendering the Product Grid
const productGrid = document.querySelector('.js-products-grid');
renderProductGrid();

// DOM Elements
const addToCartButtons = document.querySelectorAll('.js-add-to-cart');
const quantitySelectorFields = document.querySelectorAll('.js-quantity-selector');
const cartQuantityIndicator = document.querySelector('.js-cart-quantity');
const addedIndicators = document.querySelectorAll('.added-to-cart');

// inetial rendering of the cart quantity in the header
renderCartQuantity();

// Event Listeners
// Add to cart event
addToCartButtons.forEach((button) => {
  button.addEventListener('click', () => {
    
    const productId = button.dataset.productId;
    const productQuantity = Number(Array.from(quantitySelectorFields).find(obj => obj.dataset.productId === productId).value);

    myCart.addToCart(productId, productQuantity);
    renderCartQuantity();
    showAdded(productId);
    console.log(myCart.cart);
  });
});