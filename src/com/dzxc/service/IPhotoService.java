package com.dzxc.service;

import java.util.List;

import com.dzxc.entity.Photo.Photo;
import com.dzxc.entity.Photoword.Photoword;

public interface IPhotoService {
	/**
	 * �����Ƭ
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
	 * �ҵ���Ҫ���µ���Ƭ��Ϣ
	 */
	public Photo findPhotoById(int photoId);
	
	/**
	 * �޸���Ƭ˵��
	 * 
	 * @param title
	 * @param photoDesc
	 */
	public void updatePhoto(Photo photo); 
	
	/**
	 * ɾ����Ƭ
	 * 
	 * @param photoId
	 */
	public void deletePhoto(int photoId);
	
	/**
	 * �ҵ���ǰ�û�������Ƭ�б�
	 * 
	 * @param albumId
	 * @return
	 */
	public List findAllByAlbum(int albumId);
	
	/**
	 * �ҵ���ǰ�û�������Ƭ������
	 * 
	 * @param albumId
	 * @return
	 */
	public int findCountByAlbum(int albumId);
	
	/**
	 * �����Ƭ����
	 * 
	 * @param title
	 * @param content
	 * @param wordDate
	 * @param photoId
	 */
	public void addPhotoWord(Photoword photoword);
	
	/**
	 * �ҵ�ָ����Ƭ�����б�
	 * 
	 * @param photoId
	 * @return
	 */
	public List findPhotoWordByPhoto(int photoId);
	
	/**
	 * �����Ƭ����
	 * 
	 * @param title
	 * @param content
	 * @param photoId
	 */
	public void addPhotoword(Photoword photoword);
}
