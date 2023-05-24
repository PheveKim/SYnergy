package synergy.model.service;

import java.util.List;

import synergy.model.dto.SearchCondition;
import synergy.model.dto.Video;

public interface VideoService {

	int insert(Video video);
	
	int delete(String id);
	
	int update(Video video);
	
	
	Video searchById(String id);
	
	List<Video> selectAll();
	
	List<Video> searchByTitle(String title);

	List<Video> searchByCondition(SearchCondition con);
}
