package com.cw.common.domain.user;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 角色类
 * @author yuanguangjie
 *
 */
@XmlRootElement
public class Role implements Serializable {
	private static final long serialVersionUID = -6541723313940343320L;
	private int roleId; //角色编号
	private String authority; //权限
	private String roleName; //角色名称
	private String roleCode; //角色代码
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

}
