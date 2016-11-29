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
        @ThriftMethod(value = "saveTopic",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<Void> saveTopic(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="topic", requiredness=Requiredness.NONE) final Topic topic
        );

        @ThriftMethod(value = "searchTopic",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<SearchTopicResult> searchTopic(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
            @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset,
            @ThriftField(value=4, name="status", requiredness=Requiredness.NONE) final TOPICSTATUS status
        );
    }
    @ThriftMethod(value = "saveTopic",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    void saveTopic(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="topic", requiredness=Requiredness.NONE) final Topic topic
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "searchTopic",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    SearchTopicResult searchTopic(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
        @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset,
        @ThriftField(value=4, name="status", requiredness=Requiredness.NONE) final TOPICSTATUS status
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;
}