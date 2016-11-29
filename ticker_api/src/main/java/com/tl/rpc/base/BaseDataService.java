package com.tl.rpc.base;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("BaseDataService")
public interface BaseDataService
{
    @ThriftService("BaseDataService")
    public interface Async
    {
        @ThriftMethod(value = "saveBaseData",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<Void> saveBaseData(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="baseData", requiredness=Requiredness.NONE) final BaseData baseData
        );

        @ThriftMethod(value = "searchBaseData",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<List<BaseData>> searchBaseData(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="year", requiredness=Requiredness.NONE) final int year
        );
    }
    @ThriftMethod(value = "saveBaseData",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    void saveBaseData(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="baseData", requiredness=Requiredness.NONE) final BaseData baseData
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "searchBaseData",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    List<BaseData> searchBaseData(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="year", requiredness=Requiredness.NONE) final int year
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;
}