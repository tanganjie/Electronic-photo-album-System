package com.dzxc.base.entity;

import java.util.List;

public class PageBean {
	private List list;		//Ҫ���ص�ĳһҳ�ļ�¼�б�
	private int allRow;
	private int totalPage;
	private int currentPage;
	private int pageSize;

	private boolean isFirstPage;
	private boolean isLastPage;
	private boolean hasPreviousPage;
	private boolean hasNextPage;

	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void init(){
		this.isFirstPage=this.isFirstPage();
		this.isLastPage=this.isLastPage();
		this.hasNextPage=this.isHasNextPage();
		this.hasPreviousPage=this.isHasPreviousPage();
	}

	public boolean isFirstPage() {
		return currentPage==1;
	}
	public boolean isLastPage() {
		return currentPage==totalPage;
	}
	public boolean isHasPreviousPage() {
		return currentPage!=1;
	}
	public boolean isHasNextPage() {
		return currentPage!=totalPage;
	}

	/**
	 * ������ҳ��,��̬����,���ⲿֱ��ͨ����������
	 * @param pageSize ÿҳ��¼��
	 * @param allRow �ܼ�¼��
	 * @return ��ҳ��
	 */
	public static int countTotalPage(final int pageSize,final int allRow){
		int totalPage = allRow % pageSize == 0 ? allRow/pageSize : allRow/pageSize+1;
		return totalPage;
	}

	/**
	 * ���㵱ǰҳ��ʼ��¼
	 * @param pageSize ÿҳ��¼��
	 * @param currentPage ��ǰ�ڼ�ҳ
	 * @return ��ǰҳ��ʼ��¼��
	 */
	public static int countOffset(final int pageSize,final int currentPage){
		final int offset = pageSize*(currentPage-1);
		return offset;
	}

	/**
	 * ���㵱ǰҳ,��Ϊ0���������URL��û��"?page=",����1����
	 * @param page ����Ĳ���(����Ϊ��,��0,�򷵻�1)
	 * @return ��ǰҳ
	 */
	public static int countCurrentPage(int page){
		final int curPage = (page==0?1:page);
		return curPage;
	}


}
