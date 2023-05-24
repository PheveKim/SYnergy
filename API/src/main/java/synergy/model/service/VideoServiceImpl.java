package synergy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import synergy.model.dto.SearchCondition;
import synergy.model.dto.Video;
import synergy.model.dao.VideoDao;


@Service
public class VideoServiceImpl implements VideoService {
	
	private VideoDao videoDao;
	
	@Autowired
	public void setVideoRepo(VideoDao videoRepo) {
		this.videoDao = videoRepo;
	}
	
	public VideoDao getVideoRepo() {
		return this.videoDao;
	}
	
	@Override
	@Transactional
	public int insert(Video video) {
		return videoDao.insert(video);
	}

	@Override
	@Transactional
	public int delete(String id) {
		return videoDao.delete(id);
	}

	@Override
	@Transactional
	public int update(Video video) {
		return videoDao.update(video);
	}

	@Override
	public Video searchById(String id) {
		return videoDao.searchById(id);
	}

	@Override
	public List<Video> selectAll() {
		return videoDao.selectAll();
	}

	@Override
	public List<Video> searchByTitle(String title) {
		return videoDao.searchByTitle(title);
	}

	@Override
	public List<Video> searchByCondition(SearchCondition con) {
		
		return videoDao.searchByCondition(con);
	}



}
