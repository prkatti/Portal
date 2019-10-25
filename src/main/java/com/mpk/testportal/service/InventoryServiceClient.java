package com.mpk.testportal.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "inventory-ws")
public interface InventoryServiceClient {

	@PostMapping("/inventory/{itemId}/{transactionType}")
	public ResponseEntity updateInventory(@PathVariable String itemId,
			@PathVariable("transactionType") String transactionType);

}
