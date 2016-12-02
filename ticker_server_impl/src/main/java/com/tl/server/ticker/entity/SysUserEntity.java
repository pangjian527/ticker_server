package com.tl.server.ticker.entity;

import com.tl.rpc.sys.SYSUSERSTATUS;
import com.tl.rpc.sys.SysUser;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by pangjian on 16-11-26.
 */
@Entity
@Table(name = "sys_user")
public class SysUserEntity {

    private String id;

    private String account;

    private String pwd;

    private Date createTime;

    private Date updateTime;

    private String role;

    private String status;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "ACCOUNT")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "PWD")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "UPDATE_TIME")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    @Column(name = "ROLE")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SysUser toSysUser(){
        SysUser sysUser = new SysUser();
        sysUser.setAccount(this.account);
        sysUser.setId(this.id);
        sysUser.setRole(this.role);
        sysUser.setStatus(SYSUSERSTATUS.valueOf(this.status));
        sysUser.setCreateTime(this.createTime.getTime());
        sysUser.setUpdateTime(this.updateTime.getTime());
        sysUser.setPwd(this.pwd);
        return sysUser;
    }
}
