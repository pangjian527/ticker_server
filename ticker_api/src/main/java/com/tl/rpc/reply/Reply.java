package com.tl.rpc.reply;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("Reply")
public final class Reply
{
    public Reply() {
    }

    private String id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public String getId() { return id; }

    @ThriftField
    public void setId(final String id) { this.id = id; }

    private String content;

    @ThriftField(value=2, name="content", requiredness=Requiredness.NONE)
    public String getContent() { return content; }

    @ThriftField
    public void setContent(final String content) { this.content = content; }

    private String userId;

    @ThriftField(value=3, name="userId", requiredness=Requiredness.NONE)
    public String getUserId() { return userId; }

    @ThriftField
    public void setUserId(final String userId) { this.userId = userId; }

    private long createTime;

    @ThriftField(value=4, name="createTime", requiredness=Requiredness.NONE)
    public long getCreateTime() { return createTime; }

    @ThriftField
    public void setCreateTime(final long createTime) { this.createTime = createTime; }

    private REPLYSTATUS status;

    @ThriftField(value=5, name="status", requiredness=Requiredness.NONE)
    public REPLYSTATUS getStatus() { return status; }

    @ThriftField
    public void setStatus(final REPLYSTATUS status) { this.status = status; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("content", content)
            .add("userId", userId)
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

        Reply other = (Reply)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(content, other.content) &&
            Objects.equals(userId, other.userId) &&
            Objects.equals(createTime, other.createTime) &&
            Objects.equals(status, other.status);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            content,
            userId,
            createTime,
            status
        });
    }
}
