package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.topic.*;
import com.tl.server.ticker.entity.TopicEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;

import java.util.Date;
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
        TopicEntity topicEntity = TopicEntity.formTopicEntity(topic);
        this.save(topicEntity);
    }

    public SearchTopicResult searchTopic(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset, @ThriftField(value = 4, name = "status", requiredness = ThriftField.Requiredness.NONE) TOPICSTATUS status,String mobile) throws RpcException, TException {

        String sql = " SELECT p.* FROM ticker.t_topic p ,t_consumer c where  c.id = p.user_id ";

        if(StringUtils.isNotBlank(mobile)){
            sql += " and c.mobile like :mobile ";
        }

        sql += " order by p.update_time desc ";

        BaseDaoImpl baseDao = this.setSql(sql).setLimit(limit).setOffset(offset);

        if(StringUtils.isNotBlank(mobile)){
            baseDao.setParameter("mobile","%"+mobile);
        }

        List<TopicEntity> list = baseDao.execute();

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
