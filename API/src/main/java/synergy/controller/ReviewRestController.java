package synergy.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

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
import synergy.model.dto.Review;
import synergy.model.service.ReviewService;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReviewRestController {

	@Autowired
	ReviewService rs;

	@GetMapping("/review")
	@ApiOperation(value = "등록된 모든 리뷰 정보를 반환한다.", response = Review.class)
	public ResponseEntity<?> selectAll() {
		try {
			List<Review> reviews = rs.selectAll();
			if (reviews != null && reviews.size() > 0) {
				return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/review/{id}")
	@ApiOperation(value = "{id}에 해당하는 리뷰 정보를 반환한다.", response = Review.class)
	public ResponseEntity<?> select(@PathVariable String id) {
		try {
			Review review = rs.searchById(id);
			if (review != null) {
				return new ResponseEntity<Review>(review, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/review/search")
	@ApiOperation(value = "SearchCondition 에 부합하는 조건을 가진 리뷰 목록을 반환한다.", response = Review.class)
	public ResponseEntity<?> search(SearchCondition con) {
		try {
			List<Review> reviews = rs.searchByCondition(con);
			if (reviews != null && reviews.size() > 0) {
				return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
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
	
	@PostMapping("/review")
	@ApiOperation(value = "리뷰 정보를 삽입한다.", response = Integer.class)
	public ResponseEntity<?> insert(@RequestBody Review review) {
		try {
			boolean is_valid = false;
			try {
				ProcessBuilder pb = new ProcessBuilder("C:\\Users\\SSAFY\\AppData\\Local\\Programs\\Python\\Python39\\python",
						System.getProperty("user.dir") + "\\src\\main\\resources\\python\\bard_validInput.py", review.getTitle() + review.getContent());
	            Process process = pb.start();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "euc-kr"));
	            String line;
	            line = reader.readLine();
	            String reline = line.replaceAll("[^0-9]","");
	            if(reline.equals("1")) is_valid = false;
	            else if(reline.equals("2")) is_valid = true;
	            int exitCode = process.waitFor();
	            
	        } catch (Exception e) {
	        	is_valid = true;
	        }
			
			if(is_valid) {
				int result = rs.insert(review);
				return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<String>("Invalid Input : 욕설이 존재합니다.", HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@PutMapping("/review")
	@ApiOperation(value = "리뷰 정보를 수정한다.", response = Integer.class)
	public ResponseEntity<?> update(@RequestBody Review review) {
		try {
			int result = rs.update(review);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/review/{id}")
	@ApiOperation(value = "{id} 에 해당하는 리뷰 정보를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			int result = rs.delete(id);
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
