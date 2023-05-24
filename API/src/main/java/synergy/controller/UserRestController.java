package synergy.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import synergy.model.dto.SearchCondition;
import synergy.model.dto.User;
import synergy.model.service.UserService;
import synergy.util.JwtUtil;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserRestController {

	@Autowired
	UserService us;
	
	@Autowired
	JwtUtil jwtUtil;

	
	//jwt 로그인 ------------------------------------------------------------
	@PostMapping("/login")
	@ApiOperation("로그인")
	public ResponseEntity<?> login(@RequestBody User user) throws UnsupportedEncodingException{
		Map<String, Object> result = new HashMap<String, Object>();
		User loginUser = us.searchById(user.getId());

		if(loginUser!=null&& loginUser.getPassword().equals(user.getPassword())) {
			HttpStatus status =null;
			try {
				result.put("accessToken",jwtUtil.createToken(loginUser));
				result.put("message","SUCCESS");
				status=HttpStatus.ACCEPTED;
			}catch(UnsupportedEncodingException e){
				result.put("message","FAIL");
				status= HttpStatus.UNAUTHORIZED;
			}
			return new ResponseEntity<Map<String,Object>>(result,status);
			
			
		}else {
			result.put("message","FAIL");
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	
	
	//---------------------------------------------------------------------
	@GetMapping("/user")
	@ApiOperation(value = "등록된 모든 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectAll() {
		try {
			List<User> users = us.selectAll();
			if (users != null && users.size() > 0) {
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/user/{id}")
	@ApiOperation(value = "{id}에 해당하는 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> select(@PathVariable String id) {
		try {
			User user = us.searchById(id);
			if (user != null) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/user/search")
	@ApiOperation(value = "SearchCondition 에 부합하는 조건을 가진 사용자 목록을 반환한다.", response = User.class)
	public ResponseEntity<?> search(SearchCondition con) {
		try {
			List<User> users = us.searchByCondition(con);
			if (users != null && users.size() > 0) {
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

//	@PostMapping("/user/search")
//	@ApiOperation(value = "SearchCondition 에 부합하는 조건을 가진 사용자 목록을 반환한다.", response = User.class)
//	public ResponseEntity<?> search2(@RequestBody SearchCondition con) {
//		try {
//			List<User> users = us.searchByCondition(con);
//			if (users != null && users.size() > 0) {
//				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//			}
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
	
	@PostMapping("/user")
	@ApiOperation(value = "사용자 정보를 삽입한다.", response = Integer.class)
	public ResponseEntity<?> insert(@RequestBody User user) {
		try {
			System.out.println(user);
			int result = us.insert(user);
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@PutMapping("/user")
	@ApiOperation(value = "사용자 정보를 수정한다.", response = Integer.class)
	public ResponseEntity<?> update(@RequestBody User user) {
		us.update(user);
		Map<String, Object> result = new HashMap<String, Object>();
		User loginUser = us.searchById(user.getId());

		if(loginUser!=null&& loginUser.getPassword().equals(user.getPassword())) {
			HttpStatus status =null;
			try {
				result.put("accessToken",jwtUtil.createToken(loginUser));
				result.put("message","SUCCESS");
				status=HttpStatus.ACCEPTED;
			}catch(UnsupportedEncodingException e){
				result.put("message","FAIL");
				status= HttpStatus.UNAUTHORIZED;
			}
			return new ResponseEntity<Map<String,Object>>(result,status);
			
			
		}else {
			result.put("message","FAIL");
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		
		
//		try {
//			int result = us.update(user);
//			return new ResponseEntity<Integer>(result, HttpStatus.OK);
//
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
	}
	
	@DeleteMapping("/user/{id}")
	@ApiOperation(value = "{id} 에 해당하는 사용자 정보를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			int result = us.delete(id);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
