package com.cw.common.domain.news;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 公告实体类
 * @author yuanguangjie
 *
 */
@XmlRootElement
public class News implements Serializable {

	private static final long serialVersionUID = -7893094577107799554L;
	private int newsId; //公告编号
	private String title; //标题
	private String content; //内容
	private String creator; //创建者
	private Date createTime; // 创建时间
	private int userId; //用户编号
	
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public static void main(String[] args) {
 
		
	}
	
}
