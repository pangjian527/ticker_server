package com.tl.rpc.product;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("Product")
public final class Product
{
    public Product() {
    }

    private String id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public String getId() { return id; }

    @ThriftField
    public void setId(final String id) { this.id = id; }

    private String expect;

    @ThriftField(value=2, name="expect", requiredness=Requiredness.NONE)
    public String getExpect() { return expect; }

    @ThriftField
    public void setExpect(final String expect) { this.expect = expect; }

    private long balance;

    @ThriftField(value=3, name="balance", requiredness=Requiredness.NONE)
    public long getBalance() { return balance; }

    @ThriftField
    public void setBalance(final long balance) { this.balance = balance; }

    private long createTime;

    @ThriftField(value=4, name="createTime", requiredness=Requiredness.NONE)
    public long getCreateTime() { return createTime; }

    @ThriftField
    public void setCreateTime(final long createTime) { this.createTime = createTime; }

    private int year;

    @ThriftField(value=5, name="year", requiredness=Requiredness.NONE)
    public int getYear() { return year; }

    @ThriftField
    public void setYear(final int year) { this.year = year; }

    private int stage;

    @ThriftField(value=6, name="stage", requiredness=Requiredness.NONE)
    public int getStage() { return stage; }

    @ThriftField
    public void setStage(final int stage) { this.stage = stage; }

    private long updateTime;

    @ThriftField(value=7, name="updateTime", requiredness=Requiredness.NONE)
    public long getUpdateTime() { return updateTime; }

    @ThriftField
    public void setUpdateTime(final long updateTime) { this.updateTime = updateTime; }

    private PRODUCTSTATUS status;

    @ThriftField(value=8, name="status", requiredness=Requiredness.NONE)
    public PRODUCTSTATUS getStatus() { return status; }

    @ThriftField
    public void setStatus(final PRODUCTSTATUS status) { this.status = status; }

    private String title;

    @ThriftField(value=9, name="title", requiredness=Requiredness.NONE)
    public String getTitle() { return title; }

    @ThriftField
    public void setTitle(final String title) { this.title = title; }

    private String mobile;

    @ThriftField(value=10, name="mobile", requiredness=Requiredness.NONE)
    public String getMobile() { return mobile; }

    @ThriftField
    public void setMobile(final String mobile) { this.mobile = mobile; }

    private int virtualCount;

    @ThriftField(value=11, name="virtualCount", requiredness=Requiredness.NONE)
    public int getVirtualCount() { return virtualCount; }

    @ThriftField
    public void setVirtualCount(final int virtualCount) { this.virtualCount = virtualCount; }

    private String probability;

    @ThriftField(value=13, name="probability", requiredness=Requiredness.NONE)
    public String getProbability() { return probability; }

    @ThriftField
    public void setProbability(final String probability) { this.probability = probability; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("expect", expect)
            .add("balance", balance)
            .add("createTime", createTime)
            .add("year", year)
            .add("stage", stage)
            .add("updateTime", updateTime)
            .add("status", status)
            .add("title", title)
            .add("mobile", mobile)
            .add("virtualCount", virtualCount)
            .add("probability", probability)
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

        Product other = (Product)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(expect, other.expect) &&
            Objects.equals(balance, other.balance) &&
            Objects.equals(createTime, other.createTime) &&
            Objects.equals(year, other.year) &&
            Objects.equals(stage, other.stage) &&
            Objects.equals(updateTime, other.updateTime) &&
            Objects.equals(status, other.status) &&
            Objects.equals(title, other.title) &&
            Objects.equals(mobile, other.mobile) &&
            Objects.equals(virtualCount, other.virtualCount) &&
            Objects.equals(probability, other.probability);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            expect,
            balance,
            createTime,
            year,
            stage,
            updateTime,
            status,
            title,
            mobile,
            virtualCount,
            probability
        });
    }
}
