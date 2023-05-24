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
import synergy.model.dto.Video;
import synergy.model.service.VideoService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class VideoRestController {

	@Autowired
	VideoService vs;

	@GetMapping("/video")
	@ApiOperation(value = "등록된 모든 비디오 정보를 반환한다.", response = Video.class)
	public ResponseEntity<?> selectAll() {
		try {
			List<Video> videos = vs.selectAll();
			if (videos != null && videos.size() > 0) {
				return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/video/{id}")
	@ApiOperation(value = "{id}에 해당하는 비디오 정보를 반환한다.", response = Video.class)
	public ResponseEntity<?> select(@PathVariable String id) {
		try {
			Video video = vs.searchById(id);
			if (video != null) {
				return new ResponseEntity<Video>(video, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/video/search")
	@ApiOperation(value = "SearchCondition 에 부합하는 조건을 가진 비디오 목록을 반환한다.", response = Video.class)
	public ResponseEntity<?> search(SearchCondition con) {
		try {
			List<Video> videos = vs.searchByCondition(con);
			if (videos != null && videos.size() > 0) {
				return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

//	@PostMapping("/video/search")
//	@ApiOperation(value = "SearchCondition 에 부합하는 조건을 가진 사용자 목록을 반환한다.", response = Video.class)
//	public ResponseEntity<?> search2(@RequestBody SearchCondition con) {
//		try {
//			List<Video> users = vs.searchByCondition(con);
//			if (users != null && users.size() > 0) {
//				return new ResponseEntity<List<Video>>(users, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//			}
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}

	// 유튜브 url 로 비디오 등록하기
	// url 입력시 바로 등록되도록.
	@PostMapping("/video")
	@ApiOperation(value = "비디오 정보를 삽입한다.", response = Integer.class)
	public ResponseEntity<?> insert(@RequestBody Video video) {
		String YoutubeURL = video.getYoutubeurl();
		String videoID = YoutubeURL.substring(32, YoutubeURL.length());
		if (YoutubeURL != null) {
			String apiUrl = YoutubeURL;
			try { 
				Document doc = Jsoup.connect(apiUrl).get();
				Element body = doc.body();
				String title = doc.select("meta[name=title]").attr("content");
				String content = doc.select("meta[name=description]").attr("content");
				String channelName = doc.select("a.yt-simple-endpoint.style-scope.yt-formatted-string").text();
				String genre = body.getElementsByAttributeValue("itemprop", "genre").attr("content");
				
				video.setTitle(title);
				video.setContent(content);
				video.setChannelname(channelName);
				video.setYoutubeurl(videoID);
				
				String fitpartname = "전신";
				try {
					ProcessBuilder pb = new ProcessBuilder("C:\\Users\\SSAFY\\AppData\\Local\\Programs\\Python\\Python39\\python",
							System.getProperty("user.dir") + "\\src\\main\\resources\\python\\bard_fitpartname.py", title + content);
		            Process process = pb.start();
		            
		            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "euc-kr"));
		            String line;
		            line = reader.readLine();
		            String reline = line.replaceAll("[^0-9]","");
		            
		            if(reline.equals("1")) fitpartname = "등";
		            else if(reline.equals("2")) fitpartname = "가슴";
		            else if(reline.equals("3")) fitpartname = "하체";
		            else if(reline.equals("4")) fitpartname = "어깨";
		            else if(reline.equals("5")) fitpartname = "팔";
		            
		            int exitCode = process.waitFor();
		        } catch (Exception e) {
		            fitpartname = "전신";
		        }
				video.setFitpartname(fitpartname);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		try {
			int result = vs.insert(video);
			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
			
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	// 기존 영상 등록
//	@PostMapping("/video")
//	@ApiOperation(value = "비디오 정보를 삽입한다.", response = Integer.class)
//	public ResponseEntity<?> insert(@RequestBody Video video) {
//		try {
//			System.out.println(video);
//			int result = vs.insert(video);
//			return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
//
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}

	@PutMapping("/video")
	@ApiOperation(value = "비디오 정보를 수정한다.", response = Integer.class)
	public ResponseEntity<?> update(@RequestBody Video video) {
		try {
			int result = vs.update(video);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	@PutMapping("/video/{id}")
	@ApiOperation(value = "비디오 좋아요 정보를 수정한다.", response = Integer.class)
	public ResponseEntity<?> updateLike(@RequestBody Video video) {
		video.setLike(video.getVideolike()+1);
		try {
			int result = vs.update(video);
			return new ResponseEntity<Integer>(result, HttpStatus.OK);

		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/video/{id}")
	@ApiOperation(value = "{id} 에 해당하는 비디오 정보를 삭제한다.", response = Integer.class)
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			int result = vs.delete(id);
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
