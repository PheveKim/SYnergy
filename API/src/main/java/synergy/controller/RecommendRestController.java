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
import synergy.model.dto.OneRM;
import synergy.model.dto.Routine;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RecommendRestController {

	

	@PostMapping("/recommend/searchRoutine")
	@ApiOperation(value = "운동 루틴 정보를 출력한다.", response = String.class)
	public ResponseEntity<?> searchRoutine(@RequestBody Routine routine) {
		try {
			String query = "";
			
			
			query += "몸무게는 " + routine.getPerson_weight() + "kg, ";
			query += "키는 " + routine.getPerson_height() + "cm 입니다. 이것을 바탕으로 BMI 를 계산해주세요. 그리고";
			query += "벤치프레스의 1RM 은 " + routine.getB() + "kg, ";
			query += "데드리프트의 1RM 은 : " + routine.getD() + "kg, ";
			query += "스쿼트는의 1RM 은 " + routine.getS() + "kg 입니다. 이 세가지 1RM 무게를 바탕으로 운동루틴을 2분할로 무게와 횟수를 꼭 포함시켜서 추천해주세요. 그 다음으로 운동루틴을 3분할로 무게와 횟수를 꼭 포함시켜서 추천해주세요. 무게는 kg을 꼭 명시해줘야합니다. 예를 들어 80kg으로 10회 반복해라는 식으로";
			
			boolean is_valid = false;
			try {
				ProcessBuilder pb = new ProcessBuilder("C:\\Users\\SSAFY\\AppData\\Local\\Programs\\Python\\Python39\\python",
						System.getProperty("user.dir") + "\\src\\main\\resources\\python\\bard_calculateRoutine.py", query);
	            Process process = pb.start();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "euc-kr"));
	            String line = " ";
	            String output = "";
	            while(line != null) {
	            	output += line;
	            	line = reader.readLine();
	            	output += "\n";
	            }
	            
//	            String reline = line.replaceAll("[^0-9]","");
	            return new ResponseEntity<String>(output, HttpStatus.OK);
	            
	        } catch (Exception e) {
	        	return exceptionHandling(e);
	        }
			
			
			

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/recommend/searchFood")
	@ApiOperation(value = "운동 루틴 정보를 출력한다.", response = String.class)
	public ResponseEntity<?> searchFood(@RequestBody Routine routine) {
		try {
			String query = "";
			
			
			query += "몸무게는 " + routine.getPerson_weight() + "kg, ";
			query += "키는 " + routine.getPerson_height() + "cm, ";
			query += "벤치프레스의 1RM 은 " + routine.getB() + "kg, ";
			query += "데드리프트의 1RM 은 : " + routine.getD() + "kg, ";
			query += "스쿼트는의 1RM 은 " + routine.getS() + "kg 입니다. 이 다섯가지 정보를 바탕으로 맞춤 식단을 추천해주는데, 다이어트 식단, 유지 식단, 벌크업 식단 세가지로 나누어서 각각 식단을 추천해주세요.";
			
			boolean is_valid = false;
			try {
				ProcessBuilder pb = new ProcessBuilder("C:\\Users\\SSAFY\\AppData\\Local\\Programs\\Python\\Python39\\python",
						System.getProperty("user.dir") + "\\src\\main\\resources\\python\\bard_calculateRoutine.py", query);
	            Process process = pb.start();
	            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "euc-kr"));
	            String line = " ";
	            String output = "";
	            while(line != null) {
	            	output += line;
	            	line = reader.readLine();
	            	output += "\n";
	            }
	            
//	            String reline = line.replaceAll("[^0-9]","");
	            return new ResponseEntity<String>(output, HttpStatus.OK);
	            
	        } catch (Exception e) {
	        	return exceptionHandling(e);
	        }
			
			
			

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
