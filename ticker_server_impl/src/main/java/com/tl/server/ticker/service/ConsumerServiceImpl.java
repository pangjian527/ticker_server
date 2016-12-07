package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.consumer.Consumer;
import com.tl.rpc.consumer.ConsumerService;
import com.tl.rpc.consumer.SearchResult;
import com.tl.server.ticker.entity.ConsumerEntity;
import org.apache.thrift.TException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pangjian on 16-12-2.
 */
public class ConsumerServiceImpl extends BaseDaoImpl<ConsumerEntity>  implements ConsumerService{

    public ConsumerServiceImpl(){ super(ConsumerEntity.class);    }

    @Override
    public Consumer getByMobile(@ThriftField(value = 1, name = "serviceToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken serviceToken, @ThriftField(value = 2, name = "mobile", requiredness = ThriftField.Requiredness.NONE) String mobile) throws RpcException, TException {

        StringBuilder sql = new StringBuilder("select * from t_consumer u where u.mobile = :account");

        List<ConsumerEntity> list = this.setSql(sql.toString()).setParameter("account", mobile).execute();

        if(list.size() > 0 ){
            return list.get(0).toConsumer();
        }
        return null;
    }

    @Override
    public Consumer getById(@ThriftField(value = 1, name = "serviceToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken serviceToken, @ThriftField(value = 2, name = "id", requiredness = ThriftField.Requiredness.NONE) String id) throws RpcException, TException {

        ConsumerEntity entity = this.get(id);

        if(entity != null){
            return entity.toConsumer();
        }

        return null;
    }

    @Override
    public void saveConsumer(@ThriftField(value = 1, name = "serviceToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken serviceToken, @ThriftField(value = 2, name = "consumer", requiredness = ThriftField.Requiredness.NONE) Consumer consumer) throws RpcException, TException {
        this.save(ConsumerEntity.formConsumerEntity(consumer));
    }

    @Override
    public SearchResult searchConsumer(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset) throws RpcException, TException {
        String sql = "select * from t_consumer o order by o.update_time desc ";

        List<ConsumerEntity> list = this.setSql(sql).setLimit(limit).setOffset(offset).execute();

        List<Consumer> resultList = new LinkedList<Consumer>();
        for (ConsumerEntity entity:list) {
            resultList.add(entity.toConsumer());
        }

        SearchResult result = new SearchResult();
        result.setTotalCount(this.getCount());
        result.setResult(resultList);

        return result;
    }

}
