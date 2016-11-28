package com.tl.rpc.consumer;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("Consumer")
public final class Consumer
{
    public Consumer() {
    }

    private String id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public String getId() { return id; }

    @ThriftField
    public void setId(final String id) { this.id = id; }

    private String mobile;

    @ThriftField(value=2, name="mobile", requiredness=Requiredness.NONE)
    public String getMobile() { return mobile; }

    @ThriftField
    public void setMobile(final String mobile) { this.mobile = mobile; }

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

    private long balance;

    @ThriftField(value=5, name="balance", requiredness=Requiredness.NONE)
    public long getBalance() { return balance; }

    @ThriftField
    public void setBalance(final long balance) { this.balance = balance; }

    private CONSUMERSTATUS status;

    @ThriftField(value=6, name="status", requiredness=Requiredness.NONE)
    public CONSUMERSTATUS getStatus() { return status; }

    @ThriftField
    public void setStatus(final CONSUMERSTATUS status) { this.status = status; }

    private String pwd;

    @ThriftField(value=7, name="pwd", requiredness=Requiredness.NONE)
    public String getPwd() { return pwd; }

    @ThriftField
    public void setPwd(final String pwd) { this.pwd = pwd; }

    private String refereeId;

    @ThriftField(value=8, name="refereeId", requiredness=Requiredness.NONE)
    public String getRefereeId() { return refereeId; }

    @ThriftField
    public void setRefereeId(final String refereeId) { this.refereeId = refereeId; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("mobile", mobile)
            .add("createTime", createTime)
            .add("updateTime", updateTime)
            .add("balance", balance)
            .add("status", status)
            .add("pwd", pwd)
            .add("refereeId", refereeId)
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

        Consumer other = (Consumer)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(mobile, other.mobile) &&
            Objects.equals(createTime, other.createTime) &&
            Objects.equals(updateTime, other.updateTime) &&
            Objects.equals(balance, other.balance) &&
            Objects.equals(status, other.status) &&
            Objects.equals(pwd, other.pwd) &&
            Objects.equals(refereeId, other.refereeId);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            mobile,
            createTime,
            updateTime,
            balance,
            status,
            pwd,
            refereeId
        });
    }
}
