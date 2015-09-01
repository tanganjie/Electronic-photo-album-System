package com.dzxc.service;

import java.util.List;

import com.dzxc.base.entity.PageBean;
import com.dzxc.entity.Album.Album;
import com.dzxc.entity.Kind.Kind;

public interface IAlbumService {
	/**
	 * ������
	 * @param albumName
	 * @param albumDesc
	 * @param kindId
	 */
	public void addAlbum(Album album);
	
	/**
	 * �޸����
	 */
	public void updateAlbum(Album album);
	
	/**
	 * ɾ�����
	 * 
	 * @param albumId
	 */
	public void deleteAlbum(int albumId);
	
	/**
	 *�ҵ���ǰ�û�������б�
	 * 
	 * @param userId
	 * @return
	 */
	public List findAllAlbum();
	
	/**
	 *�ҵ������û�������б�
	 * 
	 * @param userId
	 * @return
	 */
	public List findAll();
	
	/**
	 * �ҵ���ǰ�û���������
	 * 
	 * @param userId
	 * @return
	 */
	public int findCountByUser();
	
	/**
	 * ����������
	 * 
	 * @param kindName
	 */
	public void addKind(Kind kind);
	
	/**
	 * �޸��������
	 */
	public void updateKind(Kind kind);
	
	/**
	 * ɾ���������
	 */
	public void deleteKind(int kindId);
	
	/**
	 *�ҵ���������б�
	 * 
	 * @return
	 */
	public List findAllKind();
	
	/**
	 *�ҵ�������Ϣ
	 * 
	 * @param kindId
	 * @return
	 */
	public Kind findKindById(int kindId);
	
	/**
	 * �ҵ������Ϣ
	 * @param albumId
	 * @return
	 */
	public Album findAlbumById(int albumId);
	
	/**
	 * ��ҳ��ѯ
	 * @param pageSize
	 * @param Page
	 * @return
	 */
	public PageBean queryForPage(int pageSize, int Page);
}
