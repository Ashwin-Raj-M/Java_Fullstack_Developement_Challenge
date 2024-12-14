import * as myCart from "../../data/cart.js";
import * as myOptions from "../../data/deliveryOptions.js";
import * as myProducts from "../../data/products.js";
import formatMoney from "../utils/money.js";

// Function to render payment summary
export function renderPaymentSummary() {

  const paymentSummary = document.querySelector('.payment-summary');

  const totalQuantity = myCart.getCartQuantity();
  console.log(myCart.getCartQuantity());
  let totalCheckoutCost = 0;
  let totalShippingCost = 0;

  myCart.cart.forEach((cartProduct) => {
    const quantity = cartProduct.productQuantity;
    const product = myProducts.findProduct(cartProduct.productId);
    const deliveryOption = myOptions.findDeliveryOption(cartProduct.deliveryOption);

    // console.log(deliveryOption);

    if (product) {
      totalCheckoutCost += product.pricePiase * quantity;
      totalShippingCost += deliveryOption.shippingCostPiase;
    }
  });

  console.log(totalCheckoutCost);
  console.log(totalShippingCost);

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
  console.log(paymentSummary.innerHTML);

}