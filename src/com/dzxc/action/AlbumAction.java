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
	 * 找到当前用户的相册列表
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
	 * 初始化添加相册种类信息
	 * @return
	 */
	public String findAllKindForAdd() {
		allKind = albumService.findAllKind();
		this.setDynamicUrl("albumAdd.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author HC
	 * 添加相册
	 * @return
	 */
	public String addAlbum() {
		albumService.addAlbum(album);
		this.setDynamicUrl("/Album_findAllAlbum.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author HC
	 * 初始化添加相片信息
	 * @return
	 */
	public String findAllAlbumForAdd() {
		allAlbum = albumService.findAllAlbum();
		this.setDynamicUrl("/photoAdd.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author HC
	 * 找到需要更新相册信息
	 * @return
	 */
	public String findAlbumById() {
		album = albumService.findAlbumById(album.getAlbumId());
		this.setDynamicUrl("albumupdate.jsp");
		return this.DYNAMIC;
	}

	/**
	 * @author HC
	 * 删除相册
	 * @return
	 */
	public String deleteAlbum() {
		albumService.deleteAlbum(album.getAlbumId());
		this.setDynamicUrl("/Album_findAllAlbum.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author HC
	 * 更新相册
	 * @return
	 */
	public String updateAlbum() {
		albumService.updateAlbum(album);
		this.setDynamicUrl("/Album_findAllAlbum.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author HC update by t.anjie
	 * 找到所有用户的相册列表/加入分页
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
	 * 找到所有相册种类
	 * @return
	 */
	public String findAllKind() {
		allKind = albumService.findAllKind();
		this.setDynamicUrl("/kindlist.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author Bobo
	 * 找到需要更新的种类信息
	 * @return
	 */
	public String findKindById() {
		kind = albumService.findKindById(kind.getKindId());
		this.setDynamicUrl("/kindupdate.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author Bobo
	 * 添加相册种类
	 * @return
	 */
	public String addKind() {
		albumService.addKind(kind);
		this.setDynamicUrl("/Album_findAllKind.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author Bobo
	 * 更新相册种类
	 * @return
	 */
	public String updateKind() {
		albumService.updateKind(kind);
		this.setDynamicUrl("/Album_findAllKind.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author Bobo
	 * 删除相册种类
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
