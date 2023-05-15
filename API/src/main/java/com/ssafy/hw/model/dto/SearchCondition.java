package com.ssafy.hw.model.dto;

public class SearchCondition {

	// 검색 컬럼으로 기본인 none은 검색하지 않는다.
	private String key = "none";
	// 검색어: ex: 토니
	private String word;
	// 검색 결과를 정렬할 컬럼 이름으로 기본인 none은 정렬하지 않는다.
	private String orderBy = "none";
	// 정렬 방향으로 기본은 asc
	private String orderByDir = "asc";

	public SearchCondition() {
	}

	public SearchCondition(String key, String word) {
		this(key, word, "none");
	}

	public SearchCondition(String key, String word, String orderBy) {
		this(key, word, orderBy, "asc");
	}

	public SearchCondition(String key, String word, String orderBy, String orderByDir) {
		this.key = key;
		this.word = word;
		this.orderBy = orderBy;
		this.orderByDir = orderByDir;
	}


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderByDir() {
		return orderByDir;
	}

	public void setOrderByDir(String orderByDir) {
		this.orderByDir = orderByDir;
	}


	@Override
	public String toString() {
		return "SearchCondition [key=" + key + ", word=" + word + ", orderBy=" + orderBy + ", orderByDir=" + orderByDir + "]";
	}

}
