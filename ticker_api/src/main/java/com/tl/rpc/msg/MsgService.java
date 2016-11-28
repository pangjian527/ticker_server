package com.tl.rpc.msg;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("MsgService")
public interface MsgService
{
    @ThriftService("MsgService")
    public interface Async
    {
        @ThriftMethod(value = "sendMsg",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<Void> sendMsg(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="msg", requiredness=Requiredness.NONE) final Msg msg
        );

        @ThriftMethod(value = "search",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<List<Msg>> search(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="mobile", requiredness=Requiredness.NONE) final String mobile
        );
    }
    @ThriftMethod(value = "sendMsg",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    void sendMsg(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="msg", requiredness=Requiredness.NONE) final Msg msg
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "search",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    List<Msg> search(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="mobile", requiredness=Requiredness.NONE) final String mobile
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;
}