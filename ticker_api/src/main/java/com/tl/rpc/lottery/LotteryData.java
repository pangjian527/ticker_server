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

    private int flatNumber1;

    @ThriftField(value=9, name="flatNumber1", requiredness=Requiredness.NONE)
    public int getFlatNumber1() { return flatNumber1; }

    @ThriftField
    public void setFlatNumber1(final int flatNumber1) { this.flatNumber1 = flatNumber1; }

    private int flatNumber2;

    @ThriftField(value=10, name="flatNumber2", requiredness=Requiredness.NONE)
    public int getFlatNumber2() { return flatNumber2; }

    @ThriftField
    public void setFlatNumber2(final int flatNumber2) { this.flatNumber2 = flatNumber2; }

    private int flatNumber3;

    @ThriftField(value=11, name="flatNumber3", requiredness=Requiredness.NONE)
    public int getFlatNumber3() { return flatNumber3; }

    @ThriftField
    public void setFlatNumber3(final int flatNumber3) { this.flatNumber3 = flatNumber3; }

    private int flatNumber4;

    @ThriftField(value=12, name="flatNumber4", requiredness=Requiredness.NONE)
    public int getFlatNumber4() { return flatNumber4; }

    @ThriftField
    public void setFlatNumber4(final int flatNumber4) { this.flatNumber4 = flatNumber4; }

    private int flatNumber5;

    @ThriftField(value=13, name="flatNumber5", requiredness=Requiredness.NONE)
    public int getFlatNumber5() { return flatNumber5; }

    @ThriftField
    public void setFlatNumber5(final int flatNumber5) { this.flatNumber5 = flatNumber5; }

    private int flatNumber6;

    @ThriftField(value=14, name="flatNumber6", requiredness=Requiredness.NONE)
    public int getFlatNumber6() { return flatNumber6; }

    @ThriftField
    public void setFlatNumber6(final int flatNumber6) { this.flatNumber6 = flatNumber6; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("stage", stage)
            .add("year", year)
            .add("number", number)
            .add("createTime", createTime)
            .add("updateTime", updateTime)
            .add("lotteryTime", lotteryTime)
            .add("flatNumber1", flatNumber1)
            .add("flatNumber2", flatNumber2)
            .add("flatNumber3", flatNumber3)
            .add("flatNumber4", flatNumber4)
            .add("flatNumber5", flatNumber5)
            .add("flatNumber6", flatNumber6)
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
            Objects.equals(stage, other.stage) &&
            Objects.equals(year, other.year) &&
            Objects.equals(number, other.number) &&
            Objects.equals(createTime, other.createTime) &&
            Objects.equals(updateTime, other.updateTime) &&
            Objects.equals(lotteryTime, other.lotteryTime) &&
            Objects.equals(flatNumber1, other.flatNumber1) &&
            Objects.equals(flatNumber2, other.flatNumber2) &&
            Objects.equals(flatNumber3, other.flatNumber3) &&
            Objects.equals(flatNumber4, other.flatNumber4) &&
            Objects.equals(flatNumber5, other.flatNumber5) &&
            Objects.equals(flatNumber6, other.flatNumber6);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            stage,
            year,
            number,
            createTime,
            updateTime,
            lotteryTime,
            flatNumber1,
            flatNumber2,
            flatNumber3,
            flatNumber4,
            flatNumber5,
            flatNumber6
        });
    }
}
