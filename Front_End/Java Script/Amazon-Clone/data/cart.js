// export let cart = [{
//   productId: "e43638ce-6aa0-4b85-b27f-e1d07eb678c6",
//   productQuantity: 10
// },{
//   productId: "83d4ca15-0f35-48f5-b7a3-1ea210004f2e",
//   productQuantity: 1
// }];

export let cart = JSON.parse(localStorage.getItem('cart')) || [];

// function to locally store cart
function localStorageCart(){
  localStorage.setItem('cart', JSON.stringify(cart));
}

// function to add items to cart
export function addToCart(productId, productQuantity){

  let duplicatecartProduct;

  cart.forEach((cartProduct) => {
    if(productId === cartProduct.productId){
      duplicatecartProduct = cartProduct;
    }
  });

  if(duplicatecartProduct){
    duplicatecartProduct.productQuantity += productQuantity;
    localStorageCart();
  }else{
    cart.push({
      productId,
      productQuantity,
      deliveryOption: 3
    });
    localStorageCart();
  }
}

// function to remove items from cart
export function removeFromCart(productId){
  cart = cart.filter(cartProduct => cartProduct.productId !== productId);
  localStorageCart();
}