package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.topic.*;
import com.tl.server.ticker.entity.TopicEntity;
import org.apache.thrift.TException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class TopicServiceImpl extends BaseDaoImpl<TopicEntity> implements TopicService {

    public TopicServiceImpl(){
        super(TopicEntity.class);
    }

    public void saveTopic(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "topic", requiredness = ThriftField.Requiredness.NONE) Topic topic) throws RpcException, TException {
        this.save(TopicEntity.formTopicEntity(topic));
    }

    public SearchTopicResult searchTopic(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset, @ThriftField(value = 4, name = "status", requiredness = ThriftField.Requiredness.NONE) TOPICSTATUS status) throws RpcException, TException {

        String sql = " select * from t_topic t order by t.update_time desc ";

        List<TopicEntity> list = this.setSql(sql).setLimit(limit).setOffset(offset).execute();

        List<Topic> result = new LinkedList<Topic>();
        for (TopicEntity entity : list) {
            result.add(entity.toTopic());
        }

        SearchTopicResult searchResult = new SearchTopicResult();
        searchResult.setTotalCount(this.getCount());
        searchResult.setResult(result);

        return searchResult;
    }


    @Override
    public Topic getByTopicId(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "topicId", requiredness = ThriftField.Requiredness.NONE) String topicId) throws RpcException, TException {
        return this.get(topicId).toTopic();
    }

}
