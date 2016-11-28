package com.tl.rpc.common;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftStruct("ServiceToken")
public final class ServiceToken
{
    public ServiceToken() {
    }

    private String tid;

    @ThriftField(value=1, name="tid", requiredness=Requiredness.NONE)
    public String getTid() { return tid; }

    @ThriftField
    public void setTid(final String tid) { this.tid = tid; }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("tid", tid)
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

        ServiceToken other = (ServiceToken)o;

        return
            Objects.equals(tid, other.tid);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(new Object[] {
            tid
        });
    }
}
