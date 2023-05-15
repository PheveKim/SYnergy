package synergy.model.service;

import java.util.List;

import synergy.model.dto.SearchCondition;
import synergy.model.dto.User;

public interface UserService {

	int insert(User user);
	
	int delete(String id);
	
	int update(User user);
	
	User searchById(String id);
	
	List<User> selectAll();
	
	List<User> searchByName(String name);
	
	List<User> searchByCondition(SearchCondition con);
}
