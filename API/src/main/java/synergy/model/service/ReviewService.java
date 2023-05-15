package synergy.model.service;

import java.util.List;

import synergy.model.dto.Review;
import synergy.model.dto.SearchCondition;

public interface ReviewService {

	int insert(Review review);
	
	int delete(String id);
	
	int update(Review review);
	
	Review searchById(String id);
	
	List<Review> selectAll();
	
	List<Review> searchByTitle(String title);

	List<Review> searchByCondition(SearchCondition con);
}
