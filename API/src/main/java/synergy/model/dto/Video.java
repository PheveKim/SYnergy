package synergy.model.dto;

import org.springframework.stereotype.Component;

public class Video {

	private String id; // 비디오아이디
	private String title; // 제목
	private String content; // 본문
	private String fitpartname;// 운동부위
	private String youtubeurl; // 유튜브링크
	private String channelname; // 채널명
	private int viewcnt; // 조회수
	private int videolike;// 좋아요
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Video(String id, String title, String content, String fitpartname, String youtubeurl, String channelname,
			int viewcnt, int videolike) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.fitpartname = fitpartname;
		this.youtubeurl = youtubeurl;
		this.channelname = channelname;
		this.viewcnt = viewcnt;
		this.videolike = videolike;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getFitpartname() {
		return fitpartname;
	}
	public void setFitpartname(String fitpartname) {
		this.fitpartname = fitpartname;
	}
	public String getYoutubeurl() {
		return youtubeurl;
	}
	public void setYoutubeurl(String youtubeurl) {
		this.youtubeurl = youtubeurl;
	}
	public String getChannelname() {
		return channelname;
	}
	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getVideolike() {
		return videolike;
	}
	public void setLike(int like) {
		this.videolike = like;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", content=" + content + ", fitpartname=" + fitpartname
				+ ", youtubeurl=" + youtubeurl + ", channelname=" + channelname + ", viewcnt=" + viewcnt + ", like="
				+ videolike + "]";
	}

	
}
