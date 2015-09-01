package com.dzxc.service;

import java.util.List;

import com.dzxc.base.entity.PageBean;
import com.dzxc.entity.Album.Album;
import com.dzxc.entity.Kind.Kind;

public interface IAlbumService {
	/**
	 * 添加相册
	 * @param albumName
	 * @param albumDesc
	 * @param kindId
	 */
	public void addAlbum(Album album);
	
	/**
	 * 修改相册
	 */
	public void updateAlbum(Album album);
	
	/**
	 * 删除相册
	 * 
	 * @param albumId
	 */
	public void deleteAlbum(int albumId);
	
	/**
	 *找到当前用户的相册列表
	 * 
	 * @param userId
	 * @return
	 */
	public List findAllAlbum();
	
	/**
	 *找到所有用户的相册列表
	 * 
	 * @param userId
	 * @return
	 */
	public List findAll();
	
	/**
	 * 找到当前用户相册的数量
	 * 
	 * @param userId
	 * @return
	 */
	public int findCountByUser();
	
	/**
	 * 添加相册种类
	 * 
	 * @param kindName
	 */
	public void addKind(Kind kind);
	
	/**
	 * 修改相册种类
	 */
	public void updateKind(Kind kind);
	
	/**
	 * 删除相册种类
	 */
	public void deleteKind(int kindId);
	
	/**
	 *找到相册种类列表
	 * 
	 * @return
	 */
	public List findAllKind();
	
	/**
	 *找到种类信息
	 * 
	 * @param kindId
	 * @return
	 */
	public Kind findKindById(int kindId);
	
	/**
	 * 找到相册信息
	 * @param albumId
	 * @return
	 */
	public Album findAlbumById(int albumId);
	
	/**
	 * 分页查询
	 * @param pageSize
	 * @param Page
	 * @return
	 */
	public PageBean queryForPage(int pageSize, int Page);
}
