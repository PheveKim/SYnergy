package synergy.model.dao;

import java.util.List;

import synergy.model.dto.SearchCondition;
import synergy.model.dto.Review;

public interface ReviewDao {
	int insert(Review review);
	
	int delete(String id);
	
	int update(Review review);
	
	Review searchById(String id);
	
	List<Review> selectAll();
	
	List<Review> searchByTitle(String title);

	List<Review> searchByCondition(SearchCondition con);
}
