package com.tl.rpc.order;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("OrderService")
public interface OrderService
{
    @ThriftService("OrderService")
    public interface Async
    {
        @ThriftMethod(value = "save",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<Void> save(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="order", requiredness=Requiredness.NONE) final Order order
        );

        @ThriftMethod(value = "search",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<List<OrderResult>> search(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
            @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset
        );

        @ThriftMethod(value = "searchByUserId",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<List<OrderResult>> searchByUserId(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
            @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset,
            @ThriftField(value=4, name="userId", requiredness=Requiredness.NONE) final String userId
        );
    }
    @ThriftMethod(value = "save",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    void save(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="order", requiredness=Requiredness.NONE) final Order order
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "search",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    List<OrderResult> search(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
        @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "searchByUserId",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    List<OrderResult> searchByUserId(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
        @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset,
        @ThriftField(value=4, name="userId", requiredness=Requiredness.NONE) final String userId
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;
}