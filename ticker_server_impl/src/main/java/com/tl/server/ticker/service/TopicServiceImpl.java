package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.topic.Reply;
import com.tl.rpc.topic.TOPICSTATUS;
import com.tl.rpc.topic.Topic;
import com.tl.rpc.topic.TopicService;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class TopicServiceImpl implements TopicService {
    public void save(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "topic", requiredness = ThriftField.Requiredness.NONE) Topic topic) throws RpcException, TException {
        System.out.println("发帖成功");
    }

    public List<Topic> search(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset, @ThriftField(value = 4, name = "status", requiredness = ThriftField.Requiredness.NONE) TOPICSTATUS status) throws RpcException, TException {
        return null;
    }

    public List<Reply> searchReplyByTopicId(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset, @ThriftField(value = 4, name = "topicId", requiredness = ThriftField.Requiredness.NONE) String topicId) throws RpcException, TException {
        return null;
    }
}
