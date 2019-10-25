<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>


<div id="dropin-wrapper">
	 
	<div id="dropin-container"></div>
	<button id="submit-button">Submit payment</button>
</div>
<div id="checkout-message"></div>
<script>
	var button = document.querySelector('#submit-button');

	braintree.dropin
			.create(
					{
						// Insert your tokenization key here
						authorization : 'YOU_TOKENIZATION_KEY',
						container : '#dropin-container',
						locale : 'en_IN'
					},
					function(createErr, instance) {
						button
								.addEventListener(
										'click',
										function() {
											instance
													.requestPaymentMethod(function(
															requestPaymentMethodErr,
															payload) {
														// When the user clicks on the 'Submit payment' button this code will send the
														// encrypted payment information in a variable called a payment method nonce
														$
																.ajax(
																		{
																			type : 'POST',
																			url : '/portal/payments',
																			data : {
																				'paymentMethodNonce' : payload.nonce,
																				'amount' : ${amount}
																			}
																		})
																.done(
																		function(
																				result) {
																			// Tear down the Drop-in UI
																			instance
																					.teardown(function(
																							teardownErr) {
																						if (teardownErr) {
																							console
																									.error('Could not tear down Drop-in UI!');
																						} else {
																							console
																									.info('Drop-in UI has been torn down!');
																							// Remove the 'Submit payment' button
																							$(
																									'#submit-button')
																									.remove();
																						}
																					});

																			if (result.success) {
																				console.log('Payment success !!!');
																				location.replace("/payments/success");
																			} else {
																				console.log('Payment success !!!');
																				console
																						.log(result);
																				$('#checkout-message')
																						.html(
																								'<h1>Error</h1><p>Check your console.</p>');
																			}
																		});
													});
										});
					});
</script>


</body>
</html>