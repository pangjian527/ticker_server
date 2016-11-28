package com.tl.rpc.base;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("BaseData")
public final class BaseData
{
    public BaseData() {
    }

    private String id;

    @ThriftField(value=1, name="id", requiredness=Requiredness.NONE)
    public String getId() { return id; }

    @ThriftField
    public void setId(final String id) { this.id = id; }

    private int stage;

    @ThriftField(value=2, name="stage", requiredness=Requiredness.NONE)
    public int getStage() { return stage; }

    @ThriftField
    public void setStage(final int stage) { this.stage = stage; }

    private int number;

    @ThriftField(value=3, name="number", requiredness=Requiredness.NONE)
    public int getNumber() { return number; }

    @ThriftField
    public void setNumber(final int number) { this.number = number; }

    private int year;

    @ThriftField(value=4, name="year", requiredness=Requiredness.NONE)
    public int getYear() { return year; }

    @ThriftField
    public void setYear(final int year) { this.year = year; }

    private String zodiacCode;

    @ThriftField(value=5, name="zodiacCode", requiredness=Requiredness.NONE)
    public String getZodiacCode() { return zodiacCode; }

    @ThriftField
    public void setZodiacCode(final String zodiacCode) { this.zodiacCode = zodiacCode; }

    private String colorCode;

    @ThriftField(value=6, name="colorCode", requiredness=Requiredness.NONE)
    public String getColorCode() { return colorCode; }

    @ThriftField
    public void setColorCode(final String colorCode) { this.colorCode = colorCode; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("id", id)
            .add("stage", stage)
            .add("number", number)
            .add("year", year)
            .add("zodiacCode", zodiacCode)
            .add("colorCode", colorCode)
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

        BaseData other = (BaseData)o;

        return
            Objects.equals(id, other.id) &&
            Objects.equals(stage, other.stage) &&
            Objects.equals(number, other.number) &&
            Objects.equals(year, other.year) &&
            Objects.equals(zodiacCode, other.zodiacCode) &&
            Objects.equals(colorCode, other.colorCode);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            id,
            stage,
            number,
            year,
            zodiacCode,
            colorCode
        });
    }
}
