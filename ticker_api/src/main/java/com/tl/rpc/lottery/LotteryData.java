package com.tl.rpc.lottery;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("LotteryData")
public final class LotteryData
{
    public LotteryData() {
    }

    private String id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public String getId() { return id; }

    @ThriftField
    public void setId(final String id) { this.id = id; }

    private String baseDataId;

    @ThriftField(value=2, name="baseDataId", requiredness=Requiredness.NONE)
    public String getBaseDataId() { return baseDataId; }

    @ThriftField
    public void setBaseDataId(final String baseDataId) { this.baseDataId = baseDataId; }

    private int stage;

    @ThriftField(value=3, name="stage", requiredness=Requiredness.NONE)
    public int getStage() { return stage; }

    @ThriftField
    public void setStage(final int stage) { this.stage = stage; }

    private int year;

    @ThriftField(value=4, name="year", requiredness=Requiredness.NONE)
    public int getYear() { return year; }

    @ThriftField
    public void setYear(final int year) { this.year = year; }

    private int number;

    @ThriftField(value=5, name="number", requiredness=Requiredness.NONE)
    public int getNumber() { return number; }

    @ThriftField
    public void setNumber(final int number) { this.number = number; }

    private long createTime;

    @ThriftField(value=6, name="createTime", requiredness=Requiredness.NONE)
    public long getCreateTime() { return createTime; }

    @ThriftField
    public void setCreateTime(final long createTime) { this.createTime = createTime; }

    private long updateTime;

    @ThriftField(value=7, name="updateTime", requiredness=Requiredness.NONE)
    public long getUpdateTime() { return updateTime; }

    @ThriftField
    public void setUpdateTime(final long updateTime) { this.updateTime = updateTime; }

    private long lotteryTime;

    @ThriftField(value=8, name="lotteryTime", requiredness=Requiredness.NONE)
    public long getLotteryTime() { return lotteryTime; }

    @ThriftField
    public void setLotteryTime(final long lotteryTime) { this.lotteryTime = lotteryTime; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("baseDataId", baseDataId)
            .add("stage", stage)
            .add("year", year)
            .add("number", number)
            .add("createTime", createTime)
            .add("updateTime", updateTime)
            .add("lotteryTime", lotteryTime)
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

        LotteryData other = (LotteryData)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(baseDataId, other.baseDataId) &&
            Objects.equals(stage, other.stage) &&
            Objects.equals(year, other.year) &&
            Objects.equals(number, other.number) &&
            Objects.equals(createTime, other.createTime) &&
            Objects.equals(updateTime, other.updateTime) &&
            Objects.equals(lotteryTime, other.lotteryTime);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            baseDataId,
            stage,
            year,
            number,
            createTime,
            updateTime,
            lotteryTime
        });
    }
}
