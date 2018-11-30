package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Cart;

@Mapper
public interface CartMapper {
	public int insert(Cart cart);
	public List<Cart> selectAll(String email);
}
