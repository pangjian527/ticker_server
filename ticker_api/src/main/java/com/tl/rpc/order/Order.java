package com.tl.rpc.order;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("Order")
public final class Order
{
    public Order() {
    }

    private String id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public String getId() { return id; }

    @ThriftField
    public void setId(final String id) { this.id = id; }

    private long amount;

    @ThriftField(value=2, name="amount", requiredness=Requiredness.NONE)
    public long getAmount() { return amount; }

    @ThriftField
    public void setAmount(final long amount) { this.amount = amount; }

    private String userId;

    @ThriftField(value=3, name="userId", requiredness=Requiredness.NONE)
    public String getUserId() { return userId; }

    @ThriftField
    public void setUserId(final String userId) { this.userId = userId; }

    private String productId;

    @ThriftField(value=4, name="productId", requiredness=Requiredness.NONE)
    public String getProductId() { return productId; }

    @ThriftField
    public void setProductId(final String productId) { this.productId = productId; }

    private ORDERSTATUS status;

    @ThriftField(value=5, name="status", requiredness=Requiredness.NONE)
    public ORDERSTATUS getStatus() { return status; }

    @ThriftField
    public void setStatus(final ORDERSTATUS status) { this.status = status; }

    private int year;

    @ThriftField(value=6, name="year", requiredness=Requiredness.NONE)
    public int getYear() { return year; }

    @ThriftField
    public void setYear(final int year) { this.year = year; }

    private int stage;

    @ThriftField(value=7, name="stage", requiredness=Requiredness.NONE)
    public int getStage() { return stage; }

    @ThriftField
    public void setStage(final int stage) { this.stage = stage; }

    private String result;

    @ThriftField(value=8, name="result", requiredness=Requiredness.NONE)
    public String getResult() { return result; }

    @ThriftField
    public void setResult(final String result) { this.result = result; }

    private long createTime;

    @ThriftField(value=9, name="createTime", requiredness=Requiredness.NONE)
    public long getCreateTime() { return createTime; }

    @ThriftField
    public void setCreateTime(final long createTime) { this.createTime = createTime; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("amount", amount)
            .add("userId", userId)
            .add("productId", productId)
            .add("status", status)
            .add("year", year)
            .add("stage", stage)
            .add("result", result)
            .add("createTime", createTime)
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

        Order other = (Order)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(amount, other.amount) &&
            Objects.equals(userId, other.userId) &&
            Objects.equals(productId, other.productId) &&
            Objects.equals(status, other.status) &&
            Objects.equals(year, other.year) &&
            Objects.equals(stage, other.stage) &&
            Objects.equals(result, other.result) &&
            Objects.equals(createTime, other.createTime);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            amount,
            userId,
            productId,
            status,
            year,
            stage,
            result,
            createTime
        });
    }
}
