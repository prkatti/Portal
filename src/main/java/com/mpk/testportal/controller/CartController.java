package com.mpk.testportal.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mpk.testportal.service.CartService;
import com.mpk.testportal.shared.CartDto;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	private CartDto cart = null;


	@GetMapping
	public String getCart(Model model) {

		if (cart == null) {
			cart = new CartDto();
			cart.setId(UUID.randomUUID().toString());
			cart.setUserId("demo_mpk");
			cart.setCartTotal(0.0);
		}
		
		model.addAttribute("cart", cart);
		return "";

	}

}
