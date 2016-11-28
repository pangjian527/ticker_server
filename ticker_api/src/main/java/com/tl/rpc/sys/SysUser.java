package com.tl.rpc.sys;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("SysUser")
public final class SysUser
{
    public SysUser() {
    }

    private String id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public String getId() { return id; }

    @ThriftField
    public void setId(final String id) { this.id = id; }

    private String account;

    @ThriftField(value=2, name="account", requiredness=Requiredness.NONE)
    public String getAccount() { return account; }

    @ThriftField
    public void setAccount(final String account) { this.account = account; }

    private long createTime;

    @ThriftField(value=3, name="createTime", requiredness=Requiredness.NONE)
    public long getCreateTime() { return createTime; }

    @ThriftField
    public void setCreateTime(final long createTime) { this.createTime = createTime; }

    private long updateTime;

    @ThriftField(value=4, name="updateTime", requiredness=Requiredness.NONE)
    public long getUpdateTime() { return updateTime; }

    @ThriftField
    public void setUpdateTime(final long updateTime) { this.updateTime = updateTime; }

    private String role;

    @ThriftField(value=5, name="role", requiredness=Requiredness.NONE)
    public String getRole() { return role; }

    @ThriftField
    public void setRole(final String role) { this.role = role; }

    private SYSUSERSTATUS status;

    @ThriftField(value=6, name="status", requiredness=Requiredness.NONE)
    public SYSUSERSTATUS getStatus() { return status; }

    @ThriftField
    public void setStatus(final SYSUSERSTATUS status) { this.status = status; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("account", account)
            .add("createTime", createTime)
            .add("updateTime", updateTime)
            .add("role", role)
            .add("status", status)
            .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SysUser other = (SysUser)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(account, other.account) &&
            Objects.equals(createTime, other.createTime) &&
            Objects.equals(updateTime, other.updateTime) &&
            Objects.equals(role, other.role) &&
            Objects.equals(status, other.status);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            account,
            createTime,
            updateTime,
            role,
            status
        });
    }
}
