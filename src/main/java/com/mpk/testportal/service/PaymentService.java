package com.mpk.testportal.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;

@Service
public class PaymentService {

	private Logger logger = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	private InventoryServiceClient inventoryServiceClient;

	@Autowired
	org.springframework.core.env.Environment env;

	public void makePayment(String nonce, Double amount) {

		BraintreeGateway gateway = new BraintreeGateway(Environment.SANDBOX, env.getProperty("braintree.merchant.id"),
				env.getProperty("braintree.merchant.public_key"), env.getProperty("braintree.merchant.private_key"));

		TransactionRequest request = new TransactionRequest().amount(new BigDecimal("" + amount))
				.paymentMethodNonce(nonce).options().submitForSettlement(true).done();

		Result<Transaction> result = gateway.transaction().sale(request);

		if (result.isSuccess()) {
			logger.info("Transaction was successful");

			// update inventory
			logger.info("Before Running inventory service in separate thread ....");
			Thread inventoryThread = new Thread(
					new InventoryRunner("oieurr9", Activity.PURCHASE.toString(), inventoryServiceClient));
			inventoryThread.start();
			logger.info("After Running inventory service in separate thread .....");

		} else {

			logger.info("Something went wrong ... with payment");
		}

	}

}

class InventoryRunner implements Runnable {

	private String itemId;
	private String activityType;

	private InventoryServiceClient inventoryServiceClient;

	private Logger logger = LoggerFactory.getLogger(InventoryRunner.class);

	InventoryRunner(String itemId, String activityType, InventoryServiceClient inventoryServiceClient) {

		this.itemId = itemId;
		this.activityType = activityType;
		this.inventoryServiceClient = inventoryServiceClient;

	}

	@Override
	public void run() {

		// update inventory
		logger.info("Before Calling inventory service ....");
		inventoryServiceClient.updateInventory(itemId, activityType);
		logger.info("After Calling inventory service .....");

	}

}

enum Activity {

	PURCHASE, RETURN
}
