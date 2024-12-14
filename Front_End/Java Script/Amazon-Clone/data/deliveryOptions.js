export const deliveryOptions = [{
  id:1,
  shippingDays: 7,
  shippingCostPiase: 0
},{
  id:2,
  shippingDays: 3,
  shippingCostPiase: 499
},{
  id:3,
  shippingDays: 1,
  shippingCostPiase: 999
}];

// function to find delivery option
export function findDeliveryOption(cartdeliveryOption){
  return deliveryOptions.find(deliveryOption => cartdeliveryOption === deliveryOption.id);
}