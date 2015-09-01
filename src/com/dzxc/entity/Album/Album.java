package com.dzxc.entity.Album;

import com.dzxc.entity.Kind.Kind;
import com.dzxc.entity.User.User;

/**
 * Album entity. @author MyEclipse Persistence Tools
 */
public class Album extends AbstractAlbum implements java.io.Serializable {

	private Kind kind;
	
	private User user;
	
	// Constructors

	/** default constructor */
	public Album() {
	}

	/** minimal constructor */
	public Album(String albumName, String createDate, Integer userId,
			Integer kindId) {
		super(albumName, createDate, userId, kindId);
	}

	/** full constructor */
	public Album(String albumName, String albumDesc, String createDate,
			Integer userId, Integer kindId, String cover) {
		super(albumName, albumDesc, createDate, userId, kindId, cover);
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
