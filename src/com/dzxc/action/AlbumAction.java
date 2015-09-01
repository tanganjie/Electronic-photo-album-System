package com.dzxc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dzxc.base.action.BaseAction;
import com.dzxc.base.entity.PageBean;
import com.dzxc.entity.Album.Album;
import com.dzxc.entity.Kind.Kind;
import com.dzxc.service.IAlbumService;

public class AlbumAction extends BaseAction {
	private static final long serialVersionUID = 3164542994039679770L;


	private IAlbumService albumService;
	private List<Kind> allKind = new ArrayList<Kind>();
	private List<Album> allAlbum = new ArrayList<Album>();
	
	private Album album;
	private Kind kind;
	private PageBean pageBean;
	private int page;
	
	/**
	 * @author HC
	 * �ҵ���ǰ�û�������б�
	 * @return
	 */
	public String findAllAlbum() {
		HttpServletRequest request = ServletActionContext.getRequest();
		allAlbum = albumService.findAllAlbum();
		int albumCount = albumService.findCountByUser();
		request.setAttribute("albumCount", albumCount);
		this.setDynamicUrl("/myAlbumlist.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author HC
	 * ��ʼ��������������Ϣ
	 * @return
	 */
	public String findAllKindForAdd() {
		allKind = albumService.findAllKind();
		this.setDynamicUrl("albumAdd.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author HC
	 * ������
	 * @return
	 */
	public String addAlbum() {
		albumService.addAlbum(album);
		this.setDynamicUrl("/Album_findAllAlbum.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author HC
	 * ��ʼ�������Ƭ��Ϣ
	 * @return
	 */
	public String findAllAlbumForAdd() {
		allAlbum = albumService.findAllAlbum();
		this.setDynamicUrl("/photoAdd.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author HC
	 * �ҵ���Ҫ���������Ϣ
	 * @return
	 */
	public String findAlbumById() {
		album = albumService.findAlbumById(album.getAlbumId());
		this.setDynamicUrl("albumupdate.jsp");
		return this.DYNAMIC;
	}

	/**
	 * @author HC
	 * ɾ�����
	 * @return
	 */
	public String deleteAlbum() {
		albumService.deleteAlbum(album.getAlbumId());
		this.setDynamicUrl("/Album_findAllAlbum.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author HC
	 * �������
	 * @return
	 */
	public String updateAlbum() {
		albumService.updateAlbum(album);
		this.setDynamicUrl("/Album_findAllAlbum.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author HC update by t.anjie
	 * �ҵ������û�������б�/�����ҳ
	 * @return
	 */
	public String findAll() {
		System.out.println(page);
		pageBean = albumService.queryForPage(4, page);
		allAlbum = pageBean.getList();
		this.setDynamicUrl("/albumlist.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author HC
	 * �ҵ������������
	 * @return
	 */
	public String findAllKind() {
		allKind = albumService.findAllKind();
		this.setDynamicUrl("/kindlist.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author Bobo
	 * �ҵ���Ҫ���µ�������Ϣ
	 * @return
	 */
	public String findKindById() {
		kind = albumService.findKindById(kind.getKindId());
		this.setDynamicUrl("/kindupdate.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author Bobo
	 * ����������
	 * @return
	 */
	public String addKind() {
		albumService.addKind(kind);
		this.setDynamicUrl("/Album_findAllKind.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author Bobo
	 * �����������
	 * @return
	 */
	public String updateKind() {
		albumService.updateKind(kind);
		this.setDynamicUrl("/Album_findAllKind.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author Bobo
	 * ɾ���������
	 * @return
	 */
	public String deleteKind() {
		albumService.deleteKind(kind.getKindId());
		this.setDynamicUrl("/Album_findAllKind.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * get&set
	 * @return
	 */
	public IAlbumService getAlbumService() {
		return albumService;
	}

	public void setAlbumService(IAlbumService albumService) {
		this.albumService = albumService;
	}

	public List<Kind> getAllKind() {
		return allKind;
	}

	public void setAllKind(List<Kind> allKind) {
		this.allKind = allKind;
	}

	public List<Album> getAllAlbum() {
		return allAlbum;
	}

	public void setAllAlbum(List<Album> allAlbum) {
		this.allAlbum = allAlbum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
