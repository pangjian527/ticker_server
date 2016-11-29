package com.tl.rpc.reply;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.service.*;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.*;
import java.util.*;

@ThriftService("ReplyService")
public interface ReplyService
{
    @ThriftService("ReplyService")
    public interface Async
    {
        @ThriftMethod(value = "saveReply",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<Void> saveReply(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="reply", requiredness=Requiredness.NONE) final Reply reply
        );

        @ThriftMethod(value = "searchReplyByTopicId",
                      exception = {
                          @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                      })
        ListenableFuture<SearchReplyResult> searchReplyByTopicId(
            @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
            @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
            @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset,
            @ThriftField(value=4, name="topicId", requiredness=Requiredness.NONE) final String topicId
        );
    }
    @ThriftMethod(value = "saveReply",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    void saveReply(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="reply", requiredness=Requiredness.NONE) final Reply reply
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;

    @ThriftMethod(value = "searchReplyByTopicId",
                  exception = {
                      @ThriftException(type=com.tl.rpc.common.RpcException.class, id=1)
                  })
    SearchReplyResult searchReplyByTopicId(
        @ThriftField(value=1, name="accessToken", requiredness=Requiredness.NONE) final com.tl.rpc.common.ServiceToken accessToken,
        @ThriftField(value=2, name="limit", requiredness=Requiredness.NONE) final int limit,
        @ThriftField(value=3, name="offset", requiredness=Requiredness.NONE) final int offset,
        @ThriftField(value=4, name="topicId", requiredness=Requiredness.NONE) final String topicId
    ) throws com.tl.rpc.common.RpcException, org.apache.thrift.TException;
}