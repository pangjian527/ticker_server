package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.reply.Reply;
import com.tl.rpc.reply.ReplyService;
import com.tl.rpc.reply.SearchReplyResult;
import com.tl.server.ticker.entity.ReplyEntity;
import org.apache.thrift.TException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pangjian on 16-11-29.
 */
public class ReplyServiceImpl extends BaseDaoImpl<ReplyEntity> implements ReplyService {

    public ReplyServiceImpl(){
        super(ReplyEntity.class);
    }

    public void saveReply(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "reply", requiredness = ThriftField.Requiredness.NONE) Reply reply) throws RpcException, TException {
        this.save(ReplyEntity.formReplyEntity(reply));
    }

    public SearchReplyResult searchReplyByTopicId(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset, @ThriftField(value = 4, name = "topicId", requiredness = ThriftField.Requiredness.NONE) String topicId) throws RpcException, TException {

        StringBuilder sql = new StringBuilder("select * from t_reply r where r.topic_id = topicId order by r.update_time desc ");

        List<ReplyEntity> list = this.setSql(sql.toString()).setParameter("topicId", topicId).setLimit(limit).setOffset(offset).execute();

        List<Reply> result = new LinkedList<Reply>();

        for (ReplyEntity entity : list) {
            result.add(entity.toReply());
        }

        SearchReplyResult searchReplyResult = new SearchReplyResult();
        searchReplyResult.setResult(result);
        searchReplyResult.setTotalCount(this.getCount());

        return searchReplyResult;
    }
}
