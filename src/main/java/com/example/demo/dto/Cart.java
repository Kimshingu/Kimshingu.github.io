package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	private String user_email;
	private int product_id;
	private String cart_size;
	private String cart_color;
	private int cart_count;
}
