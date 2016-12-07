package com.tl.rpc.product;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("SearchProductResult")
public final class SearchProductResult
{
    public SearchProductResult() {
    }

    private int totalCount;

    @ThriftField(value=1, name="totalCount", requiredness=Requiredness.NONE)
    public int getTotalCount() { return totalCount; }

    @ThriftField
    public void setTotalCount(final int totalCount) { this.totalCount = totalCount; }

    private List<Product> result;

    @ThriftField(value=2, name="result", requiredness=Requiredness.NONE)
    public List<Product> getResult() { return result; }

    @ThriftField
    public void setResult(final List<Product> result) { this.result = result; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("totalCount", totalCount)
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

        SearchProductResult other = (SearchProductResult)o;

        return
            Objects.equals(totalCount, other.totalCount) &&
            Objects.equals(result, other.result);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            totalCount,
            result
        });
    }
}
