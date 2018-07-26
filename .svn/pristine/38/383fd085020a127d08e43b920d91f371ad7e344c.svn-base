package com.cw.common.util;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * 模块功能实体类
 * @author yuanguangjie
 *
 */
public class MenuItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6302881094214911822L;
	private String menuId; // 模块编号
	private String menuHref; // 模块url链接请求地址，这里设置的为action类中的请求链接地址，详细请看action类中方法设置的注解value值
	private String menuName; //模块名称
	private int menuSeq;     // 模块序列，根据表数据查看序列设置的规律
	private String authority;  // 权限；这里可以查看et_role权限表
	private String parentId;   // 模块父级编号
	private String icon;       // 模块显示图标；这是使用font awesome图标框架，可以根据系统页面和font awesome官网查看图标设置
	private boolean visiable; // 是否可见
	public boolean isVisiable() {
		return visiable;
	}

	public void setVisiable(boolean visiable) {
		this.visiable = visiable;
	}
	private LinkedHashMap<String,MenuItem> childMap;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public LinkedHashMap<String, MenuItem> getChildMap() {
		return childMap;
	}

	public void setChildMap(LinkedHashMap<String, MenuItem> childMap) {
		this.childMap = childMap;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuHref() {
		return menuHref;
	}

	public void setMenuHref(String menuHref) {
		this.menuHref = menuHref;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(int menuSeq) {
		this.menuSeq = menuSeq;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public MenuItem(){}
	public MenuItem(String menuId, String menuHref, String menuName, int menuSeq, String authority, String parentId,
			String icon) {
		super();
		this.menuId = menuId;
		this.menuHref = menuHref;
		this.menuName = menuName;
		this.menuSeq = menuSeq;
		this.authority = authority;
		this.parentId = parentId;
		this.icon = icon;
	}

}
