export let cart = [];

export function addToCart(productId, productQuantity){

  let duplicatecartProduct;

  cart.forEach((cartProduct) => {
    if(productId === cartProduct.productId){
      duplicatecartProduct = cartProduct;
    }
  });

  if(duplicatecartProduct){
    duplicatecartProduct.productQuantity += productQuantity;
  }else{
    cart.push({
      productId,
      productQuantity 
    });
  }
}