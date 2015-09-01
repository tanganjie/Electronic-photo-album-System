package com.dzxc.entity.Photo;

import com.dzxc.entity.Album.Album;

/**
 * Photo entity. @author MyEclipse Persistence Tools
 */
public class Photo extends AbstractPhoto implements java.io.Serializable {

	private Album album;
	
	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** minimal constructor */
	public Photo(String title, String picUrl, String smallPicUrl,
			String uploadDate, Integer albumId) {
		super(title, picUrl, smallPicUrl, uploadDate, albumId);
	}

	/** full constructor */
	public Photo(String title, String photoDesc, String picUrl,
			String smallPicUrl, String uploadDate, Integer albumId) {
		super(title, photoDesc, picUrl, smallPicUrl, uploadDate, albumId);
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

}
