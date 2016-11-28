package com.tl.rpc.msg;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("Msg")
public final class Msg
{
    public Msg() {
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

    private String content;

    @ThriftField(value=3, name="content", requiredness=Requiredness.NONE)
    public String getContent() { return content; }

    @ThriftField
    public void setContent(final String content) { this.content = content; }

    private long createTime;

    @ThriftField(value=4, name="createTime", requiredness=Requiredness.NONE)
    public long getCreateTime() { return createTime; }

    @ThriftField
    public void setCreateTime(final long createTime) { this.createTime = createTime; }

    private MSGSTATUS status;

    @ThriftField(value=5, name="status", requiredness=Requiredness.NONE)
    public MSGSTATUS getStatus() { return status; }

    @ThriftField
    public void setStatus(final MSGSTATUS status) { this.status = status; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("mobile", mobile)
            .add("content", content)
            .add("createTime", createTime)
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

        Msg other = (Msg)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(mobile, other.mobile) &&
            Objects.equals(content, other.content) &&
            Objects.equals(createTime, other.createTime) &&
            Objects.equals(status, other.status);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            mobile,
            content,
            createTime,
            status
        });
    }
}
