package com.dzxc.entity.Photoword;

/**
 * AbstractPhotoword entity provides the base persistence definition of the
 * Photoword entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPhotoword implements java.io.Serializable {

	// Fields

	private Integer photowordId;
	private String title;
	private String content;
	private String wordDate;
	private Integer userId;
	private Integer photoId;

	// Constructors

	/** default constructor */
	public AbstractPhotoword() {
	}

	/** full constructor */
	public AbstractPhotoword(String title, String content, String wordDate,
			Integer userId, Integer photoId) {
		this.title = title;
		this.content = content;
		this.wordDate = wordDate;
		this.userId = userId;
		this.photoId = photoId;
	}

	// Property accessors

	public Integer getPhotowordId() {
		return this.photowordId;
	}

	public void setPhotowordId(Integer photowordId) {
		this.photowordId = photowordId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWordDate() {
		return this.wordDate;
	}

	public void setWordDate(String wordDate) {
		this.wordDate = wordDate;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPhotoId() {
		return this.photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

}