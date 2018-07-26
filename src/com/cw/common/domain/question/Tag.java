package com.cw.common.domain.question;

import java.io.Serializable;
import java.util.Date;

/**
 * 试题标签类
 * @author yuanguangjie
 *
 */
public class Tag implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4266590307234837998L;
	private int tagId; //标签编号
    private String tagName; //标签名称
    private Date createTime; //创建时间
    private int creator; //创建者编号
    private String creatorName; //创建者名称
    private boolean privatee; //是否为私人的
    private String memo; //备注

    public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public boolean isPrivatee() {
        return privatee;
    }

    public void setPrivatee(boolean privatee) {
        this.privatee = privatee;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
