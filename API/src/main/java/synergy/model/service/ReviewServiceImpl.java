package synergy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import synergy.model.dto.SearchCondition;
import synergy.model.dto.Review;
import synergy.model.dao.ReviewDao;


@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewDao reviewDao;
	
	@Autowired
	public void setReviewRepo(ReviewDao reviewRepo) {
		this.reviewDao = reviewRepo;
	}
	
	public ReviewDao getReviewRepo() {
		return this.reviewDao;
	}
	
	@Override
	@Transactional
	public int insert(Review review) {
		return reviewDao.insert(review);
	}

	@Override
	@Transactional
	public int delete(String id) {
		return reviewDao.delete(id);
	}

	@Override
	@Transactional
	public int update(Review review) {
		return reviewDao.update(review);
	}

	@Override
	public Review searchById(String id) {
		return reviewDao.searchById(id);
	}

	@Override
	public List<Review> selectAll() {
		return reviewDao.selectAll();
	}

	@Override
	public List<Review> searchByTitle(String title) {
		return reviewDao.searchByTitle(title);
	}

	@Override
	public List<Review> searchByCondition(SearchCondition con) {
		return reviewDao.searchByCondition(con);
	}

}
