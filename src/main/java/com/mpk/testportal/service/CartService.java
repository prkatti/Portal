package com.mpk.testportal.service;

import org.springframework.stereotype.Service;

import com.mpk.testportal.shared.CartDto;

@Service
public class CartService {
	
	public CartDto createCart( CartDto dto) {
		
		return new CartDto();
		
	}

}
