package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private int id;
	private String name;
	private int price;
	private String image;
	private String detail;
	private String deliveryCharge;
	private int hitcount;
	private String size;
	private String color;
//	private String seller;
	
}
