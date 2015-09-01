package com.dzxc.action;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.dzxc.base.action.BaseAction;
import com.dzxc.entity.Photo.Photo;
import com.dzxc.entity.Photoword.Photoword;
import com.dzxc.service.IPhotoService;

public class PhotoAction extends BaseAction {
	private static final long serialVersionUID = 2250933262265396564L;
	private static final int BUFFER_SIZE = 16 * 1024;

	private IPhotoService photoService;
	private File file;
	private String fileFileName;
	private String imageFileName;
	private List<Photo> allPhoto = new ArrayList<Photo>();
	private List<Photoword> allPhotoword = new ArrayList<Photoword>();
	
	private Photo photo;
	private Photoword photoword;
	
	/**
	 * @author t.anjie
	 * 得到文件名称
	 * @param fileName
	 * @return
	 */
	private String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
	
	/**
	 * @author t.anjie
	 * 拷贝
	 * @param file
	 * @param imageFile
	 * @throws Exception
	 */
	private void copy(File src, File dist) throws Exception {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dist), BUFFER_SIZE);

				byte[] buf = new byte[BUFFER_SIZE];
				while (in.read(buf) > 0) {
					out.write(buf);
				}
				out.close();
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in != null)
					in.close();
				if (out != null)
					out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	/**
	 * @author t.anjie
	 * 缩放处理
	 * @return
	 */
	public void zoom(File imageFile) throws Exception {

		try {

			// 缩略图存放路径
			File todir = new File(ServletActionContext.getServletContext().getRealPath("/UploadImages")+ "/small");
			if (!todir.exists()) {
				todir.mkdir();
			}

			if (!imageFile.isFile())
				throw new Exception(imageFile + " is not image file error in CreateThumbnail!");
			File sImg = new File(todir, fileFileName);

			BufferedImage Bi = ImageIO.read(imageFile);
			// 假设图片宽 高 最大为130 80,使用默认缩略算法
			Image Itemp = Bi.getScaledInstance(130, 80, Bi.SCALE_DEFAULT);

			double Ratio = 0.0;
			if ((Bi.getHeight() > 130) || (Bi.getWidth() > 80)) {
				if (Bi.getHeight() > Bi.getWidth())
					Ratio = 80.0 / Bi.getHeight();
				else
					Ratio = 130.0 / Bi.getWidth();

				AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(Ratio, Ratio), null);
				Itemp = op.filter(Bi, null);
			}

			ImageIO.write((BufferedImage) Itemp, "jpg", sImg);

		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception(e);
		}
	}
	
	/**
	 * @author t.anjie
	 * 图片上传
	 * @return
	 */
	public String addPhoto() throws Exception {
		imageFileName = new Date().getTime() + getExtention(fileFileName);

		// 得到文件存放路径
		String dir = ServletActionContext.getServletContext().getRealPath("/UploadImages");
		File dirs = new File(dir);
		if (!dirs.exists())
			dirs.mkdir();
		// 使用原来的文件名保存图片
		String path = dir + "/" + imageFileName;
		File imageFile = new File(path);

		copy(file, imageFile);

		// 缩放
		zoom(imageFile);
		String newpath = "UploadImages/small/" + fileFileName;
		String picUrl = "UploadImages/" + imageFileName;
		photo.setPicUrl(picUrl);
		photo.setSmallPicUrl(newpath);
		this.getPhotoService().addPhoto(photo,newpath);
		this.setDynamicUrl("/Album_findAllAlbum.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author HC
	 * 按用户相册找出所有照片
	 * @return
	 */
	public String findUserAllPhoto(){
		allPhoto=this.photoService.findAllByAlbum(photo.getAlbumId());
		this.setDynamicUrl("/Myphotolist.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author HC
	 * 查询照片评论
	 * @return
	 */
	public String findPhotowords(){
		photo = photoService.findPhotoById(photo.getPhotoId());
		allPhotoword = photoService.findPhotoWordByPhoto(photo.getPhotoId());
		this.setDynamicUrl("/photoInfo.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author HC
	 * 添加相片评论
	 * @return
	 */
	public String addPhotoword() {
		System.out.println(photoword.getTitle()+"&&"+photoword.getContent());
		photoword.setPhotoId(photo.getPhotoId());
		photoService.addPhotoword(photoword);
		this.setDynamicUrl("/Photo_findPhotowords.action?photo.photoId="+photo.getPhotoId());
		return this.MYREDIRCT;
	}
	
	/**
	 * @author HC
	 * 当前用户相片的评论列表
	 * @return
	 */
	public String findUserPhotowords() {
		photo = photoService.findPhotoById(photo.getPhotoId());
		allPhotoword = photoService.findPhotoWordByPhoto(photo.getPhotoId());
		this.setDynamicUrl("/MyphotoInfo.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author HC
	 * 获得相片信息
	 * @return
	 */
	public String findPhotoById() {
		photo = photoService.findPhotoById(photo.getPhotoId());
		this.setDynamicUrl("/photoUpdate.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author HC
	 * 修改相片说明
	 * @return
	 */
	public String updatePhoto() {
		photoService.updatePhoto(photo);
		this.setDynamicUrl("/Photo_findUserPhotowords.action?photo.photoId="+photo.getPhotoId());
		return this.MYREDIRCT;
	}
	
	/**
	 * @author HC
	 * 删除相片
	 * @return
	 */
	public String deletePhoto() {
		photo=this.getPhotoService().findPhotoById(photo.getPhotoId());
		photoService.deletePhoto(photo.getPhotoId());
		this.setDynamicUrl("/Photo_findUserAllPhoto.action?photo.albumId="+photo.getAlbumId());
		return this.MYREDIRCT;
	}
	
	/**
	 * @author HC
	 * 找到所有相册的相片列表
	 * @return
	 */
	public String findAllPhoto() {
		allPhoto = photoService.findAllByAlbum(photo.getAlbumId());
		this.setDynamicUrl("/photolist.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * get&set
	 * @return
	 */
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public List<Photo> getAllPhoto() {
		return allPhoto;
	}
	public void setAllPhoto(List<Photo> allPhoto) {
		this.allPhoto = allPhoto;
	}
	public List<Photoword> getAllPhotoword() {
		return allPhotoword;
	}
	public void setAllPhotoword(List<Photoword> allPhotoword) {
		this.allPhotoword = allPhotoword;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public Photoword getPhotoword() {
		return photoword;
	}
	public void setPhotoword(Photoword photoword) {
		this.photoword = photoword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static int getBufferSize() {
		return BUFFER_SIZE;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public IPhotoService getPhotoService() {
		return photoService;
	}

	public void setPhotoService(IPhotoService photoService) {
		this.photoService = photoService;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
}
