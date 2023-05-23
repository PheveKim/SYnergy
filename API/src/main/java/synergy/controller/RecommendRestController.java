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

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RecommendRestController {

	

	@PostMapping("/recommend/searchOneRM")
	@ApiOperation(value = "OneRM 정보를 출력한다.", response = String.class)
	public ResponseEntity<?> searchOneRM(@RequestBody OneRM oneRM) {
		try {
			String query = "";
			query += "벤치프레스 : " + oneRM.getBenchpress_weight() + "kg " + oneRM.getBenchpress_rep() + "회, ";
			query += "데드리프트 : " + oneRM.getDeadlift_weight() + "kg " + oneRM.getDeadlift_rep() + "회, ";
			query += "스쿼트 : " + oneRM.getSquat_weight() + "kg " + oneRM.getSquat_rep() + "회";
			
			boolean is_valid = false;
			try {
				ProcessBuilder pb = new ProcessBuilder("C:\\Users\\SSAFY\\AppData\\Local\\Programs\\Python\\Python39\\python",
						System.getProperty("user.dir") + "\\src\\main\\resources\\python\\bard_calculateOneRM.py", query);
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
