package synergy.model.dto;

import org.springframework.stereotype.Component;

public class Review {

	private String id; // 리뷰아이디
	private String userid; // 유저아이디 (리뷰를 작성한 작성자)
	private String videoid; // 비디오아이디 (리뷰가 작성된 비디오)
	private String title;// 제목
	private String content; // 본문
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(String id, String userid, String videoid, String title, String content) {
		super();
		this.id = id;
		this.userid = userid;
		this.videoid = videoid;
		this.title = title;
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getVideoid() {
		return videoid;
	}
	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", userid=" + userid + ", videoid=" + videoid + ", title=" + title + ", content="
				+ content + "]";
	}
	
	
}
