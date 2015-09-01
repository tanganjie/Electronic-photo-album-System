package com.dzxc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dzxc.base.service.BaseService;
import com.dzxc.entity.Album.Album;
import com.dzxc.entity.Photo.Photo;
import com.dzxc.entity.Photoword.Photoword;
import com.dzxc.entity.User.User;
import com.dzxc.service.IPhotoService;

public class PhotoServiceImpl extends BaseService implements IPhotoService {

	@Override
	public void addPhoto(Photo photo,String cover) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		photo.setUploadDate(sdf.format(date));
		Album album = this.getAlbumDAO().findById(photo.getAlbumId());
		int count = this.getPhotoDAO().findByAlbumId(photo.getAlbumId()).size();
		if (count < 1) {
			album.setCover(cover);
			this.getAlbumDAO().merge(album);
		}
		photo.setAlbumId(album.getAlbumId());
		this.getPhotoDAO().save(photo);
	}

	@Override
	public Photo findPhotoById(int photoId) {
		// TODO Auto-generated method stub
		return this.getPhotoDAO().findById(photoId);
	}

	@Override
	public void updatePhoto(Photo photo) {
		// TODO Auto-generated method stub
		Photo newPhoto = this.getPhotoDAO().findById(photo.getPhotoId());
		newPhoto.setTitle(photo.getTitle());
		newPhoto.setPhotoDesc(photo.getPhotoDesc());
		this.getPhotoDAO().merge(newPhoto);
	}

	@Override
	public void deletePhoto(int photoId) {
		// TODO Auto-generated method stub
		Photo newPhoto = this.getPhotoDAO().findById(photoId);
		this.getPhotoDAO().delete(newPhoto);
	}

	@Override
	public List findAllByAlbum(int albumId) {
		// TODO Auto-generated method stub
		return this.getPhotoDAO().findByAlbumId(albumId);
	}

	@Override
	public int findCountByAlbum(int albumId) {
		// TODO Auto-generated method stub
		return this.getPhotoDAO().findByAlbumId(albumId).size();
	}

	@Override
	public void addPhotoWord(Photoword photoword) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		photoword.setWordDate(sdf.format(date));
		this.getPhotowordDAO().save(photoword);
	}

	@Override
	public List findPhotoWordByPhoto(int photoId) {
		// TODO Auto-generated method stub
		List<Photoword> list = this.getPhotowordDAO().findByPhotoId(photoId);
		for(Photoword t:list){
			t.setPhoto(this.getPhotoDAO().findById(photoId));
			t.setUser(this.getUserDAO().findById(t.getUserId()));
		}
		return list;
	}

	@Override
	public void addPhotoword(Photoword photoword) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		photoword.setWordDate(sdf.format(date));
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		photoword.setUserId(user.getUserId());
		this.getPhotowordDAO().save(photoword);
	}
	
}
