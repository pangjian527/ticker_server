package com.tl.rpc.topic;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("TopicService")
public interface TopicService
{
    @ThriftService("TopicService")
    public interface Async
    {
        @ThriftMethod(value = "save",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<Void> save(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="topic", requiredness=Requiredness.NONE) final Topic topic
        );

        @ThriftMethod(value = "search",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<List<Topic>> search(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
            @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset,
            @ThriftField(value=4, name="status", requiredness=Requiredness.NONE) final TOPICSTATUS status
        );

        @ThriftMethod(value = "searchReplyByTopicId",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<List<Reply>> searchReplyByTopicId(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
            @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset,
            @ThriftField(value=4, name="topicId", requiredness=Requiredness.NONE) final String topicId
        );
    }
    @ThriftMethod(value = "save",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    void save(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="topic", requiredness=Requiredness.NONE) final Topic topic
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "search",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    List<Topic> search(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
        @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset,
        @ThriftField(value=4, name="status", requiredness=Requiredness.NONE) final TOPICSTATUS status
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "searchReplyByTopicId",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    List<Reply> searchReplyByTopicId(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
        @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset,
        @ThriftField(value=4, name="topicId", requiredness=Requiredness.NONE) final String topicId
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;
}