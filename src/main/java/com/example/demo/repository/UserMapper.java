package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.User;

@Mapper
public interface UserMapper {

	public int update(User user);
	public int delete(String email);
	public int insert(User user);
	public List<User> selectAll();
	public User selectOne(String email);
	
	
	
}
