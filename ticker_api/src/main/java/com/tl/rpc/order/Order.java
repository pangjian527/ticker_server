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

    private String topicId;

    @ThriftField(value=4, name="topicId", requiredness=Requiredness.NONE)
    public String getTopicId() { return topicId; }

    @ThriftField
    public void setTopicId(final String topicId) { this.topicId = topicId; }

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

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("amount", amount)
            .add("userId", userId)
            .add("topicId", topicId)
            .add("status", status)
            .add("year", year)
            .add("stage", stage)
            .add("result", result)
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
            Objects.equals(topicId, other.topicId) &&
            Objects.equals(status, other.status) &&
            Objects.equals(year, other.year) &&
            Objects.equals(stage, other.stage) &&
            Objects.equals(result, other.result);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            amount,
            userId,
            topicId,
            status,
            year,
            stage,
            result
        });
    }
}
