package com.tl.rpc.recharge;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("Recharge")
public final class Recharge
{
    public Recharge() {
    }

    private String id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public String getId() { return id; }

    @ThriftField
    public void setId(final String id) { this.id = id; }

    private String userId;

    @ThriftField(value=2, name="userId", requiredness=Requiredness.NONE)
    public String getUserId() { return userId; }

    @ThriftField
    public void setUserId(final String userId) { this.userId = userId; }

    private long amount;

    @ThriftField(value=3, name="amount", requiredness=Requiredness.NONE)
    public long getAmount() { return amount; }

    @ThriftField
    public void setAmount(final long amount) { this.amount = amount; }

    private long giveAmount;

    @ThriftField(value=4, name="giveAmount", requiredness=Requiredness.NONE)
    public long getGiveAmount() { return giveAmount; }

    @ThriftField
    public void setGiveAmount(final long giveAmount) { this.giveAmount = giveAmount; }

    private long createTime;

    @ThriftField(value=5, name="createTime", requiredness=Requiredness.NONE)
    public long getCreateTime() { return createTime; }

    @ThriftField
    public void setCreateTime(final long createTime) { this.createTime = createTime; }

    private String source;

    @ThriftField(value=6, name="source", requiredness=Requiredness.NONE)
    public String getSource() { return source; }

    @ThriftField
    public void setSource(final String source) { this.source = source; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("userId", userId)
            .add("amount", amount)
            .add("giveAmount", giveAmount)
            .add("createTime", createTime)
            .add("source", source)
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

        Recharge other = (Recharge)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(userId, other.userId) &&
            Objects.equals(amount, other.amount) &&
            Objects.equals(giveAmount, other.giveAmount) &&
            Objects.equals(createTime, other.createTime) &&
            Objects.equals(source, other.source);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            userId,
            amount,
            giveAmount,
            createTime,
            source
        });
    }
}
