package com.dzxc.entity.Photo;

/**
 * AbstractPhoto entity provides the base persistence definition of the Photo
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPhoto implements java.io.Serializable {

	// Fields

	private Integer photoId;
	private String title;
	private String photoDesc;
	private String picUrl;
	private String smallPicUrl;
	private String uploadDate;
	private Integer albumId;

	// Constructors

	/** default constructor */
	public AbstractPhoto() {
	}

	/** minimal constructor */
	public AbstractPhoto(String title, String picUrl, String smallPicUrl,
			String uploadDate, Integer albumId) {
		this.title = title;
		this.picUrl = picUrl;
		this.smallPicUrl = smallPicUrl;
		this.uploadDate = uploadDate;
		this.albumId = albumId;
	}

	/** full constructor */
	public AbstractPhoto(String title, String photoDesc, String picUrl,
			String smallPicUrl, String uploadDate, Integer albumId) {
		this.title = title;
		this.photoDesc = photoDesc;
		this.picUrl = picUrl;
		this.smallPicUrl = smallPicUrl;
		this.uploadDate = uploadDate;
		this.albumId = albumId;
	}

	// Property accessors

	public Integer getPhotoId() {
		return this.photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhotoDesc() {
		return this.photoDesc;
	}

	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getSmallPicUrl() {
		return this.smallPicUrl;
	}

	public void setSmallPicUrl(String smallPicUrl) {
		this.smallPicUrl = smallPicUrl;
	}

	public String getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

}