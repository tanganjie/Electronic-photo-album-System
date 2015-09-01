package com.dzxc.entity.Album;

/**
 * AbstractAlbum entity provides the base persistence definition of the Album
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAlbum implements java.io.Serializable {

	// Fields

	private Integer albumId;
	private String albumName;
	private String albumDesc;
	private String createDate;
	private Integer userId;
	private Integer kindId;
	private String cover;

	// Constructors

	/** default constructor */
	public AbstractAlbum() {
	}

	/** minimal constructor */
	public AbstractAlbum(String albumName, String createDate, Integer userId,
			Integer kindId) {
		this.albumName = albumName;
		this.createDate = createDate;
		this.userId = userId;
		this.kindId = kindId;
	}

	/** full constructor */
	public AbstractAlbum(String albumName, String albumDesc, String createDate,
			Integer userId, Integer kindId, String cover) {
		this.albumName = albumName;
		this.albumDesc = albumDesc;
		this.createDate = createDate;
		this.userId = userId;
		this.kindId = kindId;
		this.cover = cover;
	}

	// Property accessors

	public Integer getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumDesc() {
		return this.albumDesc;
	}

	public void setAlbumDesc(String albumDesc) {
		this.albumDesc = albumDesc;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getKindId() {
		return this.kindId;
	}

	public void setKindId(Integer kindId) {
		this.kindId = kindId;
	}

	public String getCover() {
		return this.cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

}