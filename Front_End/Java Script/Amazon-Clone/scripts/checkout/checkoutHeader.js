// Function to render item count at Header
export default function renderItemCountHeader(totalQuantity) {
  const itemCountHeader = document.querySelector('.return-to-home-link');

  itemCountHeader.innerHTML = `${totalQuantity} items`;
}