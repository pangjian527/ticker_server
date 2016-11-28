package com.tl.rpc.consumer;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("ConsumerService")
public interface ConsumerService
{
    @ThriftService("ConsumerService")
    public interface Async
    {
        @ThriftMethod(value = "getByMobile",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<Consumer> getByMobile(
            @ThriftField(value=1, name="serviceToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken serviceToken,
            @ThriftField(value=2, name="mobile", requiredness=Requiredness.NONE) final String mobile
        );

        @ThriftMethod(value = "save",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<Void> save(
            @ThriftField(value=1, name="serviceToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken serviceToken,
            @ThriftField(value=2, name="consumer", requiredness=Requiredness.NONE) final Consumer consumer
        );

        @ThriftMethod(value = "search",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<SearchResult> search(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
            @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset
        );
    }
    @ThriftMethod(value = "getByMobile",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    Consumer getByMobile(
        @ThriftField(value=1, name="serviceToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken serviceToken,
        @ThriftField(value=2, name="mobile", requiredness=Requiredness.NONE) final String mobile
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "save",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    void save(
        @ThriftField(value=1, name="serviceToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken serviceToken,
        @ThriftField(value=2, name="consumer", requiredness=Requiredness.NONE) final Consumer consumer
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "search",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    SearchResult search(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
        @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;
}