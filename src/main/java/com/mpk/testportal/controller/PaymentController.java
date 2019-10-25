package com.mpk.testportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mpk.testportal.service.PaymentService;

@Controller
@RequestMapping("/payments")
public class PaymentController {
	
	Logger logger = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public String getPaymentMethods(Model model, @RequestParam("total") Float total) {
		
		logger.info("Total amount:"+total);
		
		model.addAttribute("amount", total);
		
		return "payment";
	}
	
	@PostMapping
	public String makePayment(@RequestParam("paymentMethodNonce") String nonce, @RequestParam("amount") Double amount) {
		
		logger.info("Inside make payment ...."+nonce);
		logger.info("Inside make payment amount...."+amount);
		paymentService.makePayment(nonce,  amount);
		return "done";
	}
	
	
	@GetMapping("/success")
	public String getSuccessPage(Model model) {
		
		return "success";
	}
	
}
