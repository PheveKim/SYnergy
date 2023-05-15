package synergy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import synergy.model.dao.UserDao;
import synergy.model.dto.SearchCondition;
import synergy.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public void setUserRepo(UserDao userRepo) {
		this.userDao = userRepo;
	}
	
	public UserDao getUserRepo() {
		return this.userDao;
	}
	
	@Override
	@Transactional
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	@Transactional
	public int delete(String id) {
		return userDao.delete(id);
	}

	@Override
	@Transactional
	public int update(User user) {
		return userDao.update(user);
	}

	@Override
	public User searchById(String id) {
		return userDao.searchById(id);
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public List<User> searchByName(String name) {
		return userDao.searchByName(name);
	}

	@Override
	public List<User> searchByCondition(SearchCondition con) {
		
		return userDao.searchByCondition(con);
	}

}
