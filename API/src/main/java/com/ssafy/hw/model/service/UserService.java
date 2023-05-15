package com.ssafy.hw.model.service;

import java.util.List;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;

public interface UserService {

	int insert(User user);
	
	int delete(String id);
	
	int update(User user);
	
	User searchById(String id);
	
	List<User> selectAll();
	
	List<User> searchByName(String name);
	
	List<User> searchByCondition(SearchCondition con);
}
