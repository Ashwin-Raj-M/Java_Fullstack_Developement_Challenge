import * as myCart from "../../data/cart.js";

// Function to render item count at Header
export function renderItemCountHeader() {
  const itemCountHeader = document.querySelector('.return-to-home-link');
  itemCountHeader.innerHTML = `${myCart.getCartQuantity()} items`;
}