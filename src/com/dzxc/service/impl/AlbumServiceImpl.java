package com.dzxc.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dzxc.base.entity.PageBean;
import com.dzxc.base.service.BaseService;
import com.dzxc.entity.Album.Album;
import com.dzxc.entity.Kind.Kind;
import com.dzxc.entity.User.User;
import com.dzxc.service.IAlbumService;

public class AlbumServiceImpl extends BaseService implements IAlbumService {

	@Override
	public void addAlbum(Album album) {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		album.setCreateDate(sdf.format(date));
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		album.setUserId(user.getUserId());
		this.getAlbumDAO().save(album);
	}

	@Override
	public void updateAlbum(Album album) {
		// TODO Auto-generated method stub
		Album newAlbum = this.getAlbumDAO().findById(album.getAlbumId());
		newAlbum.setAlbumName(album.getAlbumName());
		newAlbum.setAlbumDesc(album.getAlbumDesc());
		this.getAlbumDAO().merge(newAlbum);
	}

	@Override
	public void deleteAlbum(int albumId) {
		// TODO Auto-generated method stub
		Album album = this.getAlbumDAO().findById(albumId);
		this.getAlbumDAO().delete(album);
	}

	@Override
	public List findAllAlbum() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Album> list=this.getAlbumDAO().findByUserId(user.getUserId());
		for(Album t:list){
			t.setKind(this.getKindDAO().findById(t.getKindId()));
		}
		return list;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		List<Album> list=this.getAlbumDAO().findAll();
		for(Album t:list){
			t.setKind(this.getKindDAO().findById(t.getKindId()));
			t.setUser(this.getUserDAO().findById(t.getUserId()));
		}
		return list;
	}

	@Override
	public int findCountByUser() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return this.getAlbumDAO().findByUserId(user.getUserId()).size();
	}

	@Override
	public void addKind(Kind kind) {
		// TODO Auto-generated method stub
		this.getKindDAO().save(kind);
	}

	@Override
	public void updateKind(Kind kind) {
		// TODO Auto-generated method stub
		System.out.println("@@"+kind.getKindId()+"@@");
		Kind newKind = this.getKindDAO().findById(kind.getKindId());
		newKind.setKindName(kind.getKindName());
		newKind.setKindDesc(kind.getKindDesc());
		this.getKindDAO().merge(newKind);
	}

	@Override
	public void deleteKind(int kindId) {
		// TODO Auto-generated method stub
		Kind kind = this.getKindDAO().findById(kindId);
		this.getKindDAO().delete(kind);
	}

	@Override
	public List findAllKind() {
		// TODO Auto-generated method stub
		return this.getKindDAO().findAll();
	}

	@Override
	public Kind findKindById(int kindId) {
		// TODO Auto-generated method stub
		return this.getKindDAO().findById(kindId);
	}

	@Override
	public Album findAlbumById(int albumId) {
		// TODO Auto-generated method stub
		return this.getAlbumDAO().findById(albumId);
	}

	@Override
	public PageBean queryForPage(int pageSize, int Page) {
		// TODO Auto-generated method stub
		final String hql = "from Album"; 				//查询语句
		int allRow = this.getAlbumDAO().getAllRowCount(hql);		//总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow);		//总页数
		final int offset = PageBean.countOffset(pageSize, Page);		//当前页开始记录
		final int length = pageSize;		//每页记录数
		final int currentPage = PageBean.countCurrentPage(Page);
		List<Album> list = this.getAlbumDAO().queryForPage(hql,offset, length);		//"一页"的记录
		for(Album t:list){
			t.setKind(this.getKindDAO().findById(t.getKindId()));
			t.setUser(this.getUserDAO().findById(t.getUserId()));
		}
		//把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	
}
