package com.dzxc.base.service;

import org.apache.log4j.Logger;

import com.dzxc.dao.IAlbumDAO;
import com.dzxc.dao.IDQuestionDAO;
import com.dzxc.dao.IKindDAO;
import com.dzxc.dao.IPhotoDAO;
import com.dzxc.dao.IPhotowordDAO;
import com.dzxc.dao.IUserDAO;


public class BaseService {
	private IUserDAO userDAO;
	private IAlbumDAO albumDAO;
	private IKindDAO kindDAO;
	private IPhotoDAO photoDAO;
	private IPhotowordDAO photowordDAO;
	private IDQuestionDAO dQuestionDAO;
	
	public IUserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public IAlbumDAO getAlbumDAO() {
		return albumDAO;
	}
	public void setAlbumDAO(IAlbumDAO albumDAO) {
		this.albumDAO = albumDAO;
	}
	public IKindDAO getKindDAO() {
		return kindDAO;
	}
	public void setKindDAO(IKindDAO kindDAO) {
		this.kindDAO = kindDAO;
	}
	public IPhotoDAO getPhotoDAO() {
		return photoDAO;
	}
	public void setPhotoDAO(IPhotoDAO photoDAO) {
		this.photoDAO = photoDAO;
	}
	public IPhotowordDAO getPhotowordDAO() {
		return photowordDAO;
	}
	public void setPhotowordDAO(IPhotowordDAO photowordDAO) {
		this.photowordDAO = photowordDAO;
	}
	public IDQuestionDAO getdQuestionDAO() {
		return dQuestionDAO;
	}
	public void setdQuestionDAO(IDQuestionDAO dQuestionDAO) {
		this.dQuestionDAO = dQuestionDAO;
	}
}
