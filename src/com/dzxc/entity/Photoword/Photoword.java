package com.dzxc.entity.Photoword;

import com.dzxc.entity.Photo.Photo;
import com.dzxc.entity.User.User;

/**
 * Photoword entity. @author MyEclipse Persistence Tools
 */
public class Photoword extends AbstractPhotoword implements
		java.io.Serializable {

	private User user;
	
	private Photo photo;
	
	// Constructors

	/** default constructor */
	public Photoword() {
	}

	/** full constructor */
	public Photoword(String title, String content, String wordDate,
			Integer userId, Integer photoId) {
		super(title, content, wordDate, userId, photoId);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

}
