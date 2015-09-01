package com.dzxc.service;

import java.util.List;

import com.dzxc.entity.Photo.Photo;
import com.dzxc.entity.Photoword.Photoword;

public interface IPhotoService {
	/**
	 * 添加相片
	 * 
	 * @param title
	 * @param photoDesc
	 * @param picUrl
	 * @param smallPicUrl
	 * @param uploadDate
	 * @param albumId
	 */
	public void addPhoto(Photo photo,String cover);
	
	/**
	 * 找到需要更新的相片信息
	 */
	public Photo findPhotoById(int photoId);
	
	/**
	 * 修改相片说明
	 * 
	 * @param title
	 * @param photoDesc
	 */
	public void updatePhoto(Photo photo); 
	
	/**
	 * 删除相片
	 * 
	 * @param photoId
	 */
	public void deletePhoto(int photoId);
	
	/**
	 * 找到当前用户相册的相片列表
	 * 
	 * @param albumId
	 * @return
	 */
	public List findAllByAlbum(int albumId);
	
	/**
	 * 找到当前用户相册的相片的数量
	 * 
	 * @param albumId
	 * @return
	 */
	public int findCountByAlbum(int albumId);
	
	/**
	 * 添加相片评论
	 * 
	 * @param title
	 * @param content
	 * @param wordDate
	 * @param photoId
	 */
	public void addPhotoWord(Photoword photoword);
	
	/**
	 * 找到指定相片评论列表
	 * 
	 * @param photoId
	 * @return
	 */
	public List findPhotoWordByPhoto(int photoId);
	
	/**
	 * 添加相片评论
	 * 
	 * @param title
	 * @param content
	 * @param photoId
	 */
	public void addPhotoword(Photoword photoword);
}
