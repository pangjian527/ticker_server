package com.tl.rpc.topic;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("Topic")
public final class Topic
{
    public Topic() {
    }

    private String title;

    @ThriftField(value=1, name="title", requiredness=Requiredness.NONE)
    public String getTitle() { return title; }

    @ThriftField
    public void setTitle(final String title) { this.title = title; }

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

    private int readCount;

    @ThriftField(value=4, name="readCount", requiredness=Requiredness.NONE)
    public int getReadCount() { return readCount; }

    @ThriftField
    public void setReadCount(final int readCount) { this.readCount = readCount; }

    private int replyCount;

    @ThriftField(value=5, name="replyCount", requiredness=Requiredness.NONE)
    public int getReplyCount() { return replyCount; }

    @ThriftField
    public void setReplyCount(final int replyCount) { this.replyCount = replyCount; }

    private TOPICSTATUS status;

    @ThriftField(value=6, name="status", requiredness=Requiredness.NONE)
    public TOPICSTATUS getStatus() { return status; }

    @ThriftField
    public void setStatus(final TOPICSTATUS status) { this.status = status; }

    private TOPICTYPE type;

    @ThriftField(value=7, name="type", requiredness=Requiredness.NONE)
    public TOPICTYPE getType() { return type; }

    @ThriftField
    public void setType(final TOPICTYPE type) { this.type = type; }

    private int year;

    @ThriftField(value=8, name="year", requiredness=Requiredness.NONE)
    public int getYear() { return year; }

    @ThriftField
    public void setYear(final int year) { this.year = year; }

    private int stage;

    @ThriftField(value=9, name="stage", requiredness=Requiredness.NONE)
    public int getStage() { return stage; }

    @ThriftField
    public void setStage(final int stage) { this.stage = stage; }

    private long createTime;

    @ThriftField(value=10, name="createTime", requiredness=Requiredness.NONE)
    public long getCreateTime() { return createTime; }

    @ThriftField
    public void setCreateTime(final long createTime) { this.createTime = createTime; }

    private String id;

    @ThriftField(value=11, name="id", requiredness=Requiredness.NONE)
    public String getId() { return id; }

    @ThriftField
    public void setId(final String id) { this.id = id; }

    private long balance;

    @ThriftField(value=12, name="balance", requiredness=Requiredness.NONE)
    public long getBalance() { return balance; }

    @ThriftField
    public void setBalance(final long balance) { this.balance = balance; }

    private String expect;

    @ThriftField(value=13, name="expect", requiredness=Requiredness.NONE)
    public String getExpect() { return expect; }

    @ThriftField
    public void setExpect(final String expect) { this.expect = expect; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("title", title)
            .add("content", content)
            .add("userId", userId)
            .add("readCount", readCount)
            .add("replyCount", replyCount)
            .add("status", status)
            .add("type", type)
            .add("year", year)
            .add("stage", stage)
            .add("createTime", createTime)
            .add("id", id)
            .add("balance", balance)
            .add("expect", expect)
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

        Topic other = (Topic)o;

        return
            Objects.equals(title, other.title) &&
            Objects.equals(content, other.content) &&
            Objects.equals(userId, other.userId) &&
            Objects.equals(readCount, other.readCount) &&
            Objects.equals(replyCount, other.replyCount) &&
            Objects.equals(status, other.status) &&
            Objects.equals(type, other.type) &&
            Objects.equals(year, other.year) &&
            Objects.equals(stage, other.stage) &&
            Objects.equals(createTime, other.createTime) &&
            Objects.equals(id, other.id) &&
            Objects.equals(balance, other.balance) &&
            Objects.equals(expect, other.expect);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            title,
            content,
            userId,
            readCount,
            replyCount,
            status,
            type,
            year,
            stage,
            createTime,
            id,
            balance,
            expect
        });
    }
}
