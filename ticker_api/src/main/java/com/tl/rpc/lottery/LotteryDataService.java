package com.tl.rpc.lottery;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("LotteryDataService")
public interface LotteryDataService
{
    @ThriftService("LotteryDataService")
    public interface Async
    {
        @ThriftMethod(value = "search",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<List<LotteryData>> search(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="year", requiredness=Requiredness.NONE) final int year,
            @ThriftField(value=3, name="limit", requiredness=Requiredness.NONE) final int limit,
            @ThriftField(value=4, name="offset", requiredness=Requiredness.NONE) final int offset
        );

        @ThriftMethod(value = "save",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<Void> save(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="lotteryData", requiredness=Requiredness.NONE) final LotteryData lotteryData
        );
    }
    @ThriftMethod(value = "search",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    List<LotteryData> search(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="year", requiredness=Requiredness.NONE) final int year,
        @ThriftField(value=3, name="limit", requiredness=Requiredness.NONE) final int limit,
        @ThriftField(value=4, name="offset", requiredness=Requiredness.NONE) final int offset
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "save",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    void save(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="lotteryData", requiredness=Requiredness.NONE) final LotteryData lotteryData
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;
}