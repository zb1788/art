package com.boz.shiro.domain;

import java.io.Serializable;

public class Role implements Serializable {
    private static final long serialVersionUID = 6185006106062743054L;
    private Integer roleId;
    private String rolename;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

}
