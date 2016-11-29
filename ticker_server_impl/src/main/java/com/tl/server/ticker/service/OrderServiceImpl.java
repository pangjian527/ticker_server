package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.order.Order;
import com.tl.rpc.order.OrderResult;
import com.tl.rpc.order.OrderService;
import com.tl.server.ticker.entity.OrderEntity;
import org.apache.thrift.TException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class OrderServiceImpl extends BaseDaoImpl<OrderEntity> implements OrderService {

    public OrderServiceImpl(){
        super(OrderEntity.class);
    }

    public void saveOrder(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "order", requiredness = ThriftField.Requiredness.NONE) Order order) throws RpcException, TException {
        this.save(OrderEntity.formOrderEntity(order));
    }

    public OrderResult searchOrder(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset) throws RpcException, TException {

        String sql = "select * from t_order o order by o.update_time desc ";

        List<OrderEntity> list = this.setSql(sql).setLimit(limit).setOffset(offset).execute();

        List<Order> resultList = new LinkedList<Order>();
        for (OrderEntity entity:list) {
            resultList.add(entity.toOrder());
        }

        OrderResult result = new OrderResult();
        result.setTotalCount(this.getCount());
        result.setResult(resultList);

        return result;
    }

    public OrderResult searchOrderByUserId(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset, @ThriftField(value = 4, name = "userId", requiredness = ThriftField.Requiredness.NONE) String userId) throws RpcException, TException {
        String sql = "select * from t_order o where o.user_id =:userId order by o.update_time desc ";

        List<OrderEntity> list = this.setSql(sql).setParameter("iserId",userId).setLimit(limit).setOffset(offset).execute();

        List<Order> resultList = new LinkedList<Order>();
        for (OrderEntity entity:list) {
            resultList.add(entity.toOrder());
        }

        OrderResult result = new OrderResult();
        result.setTotalCount(this.getCount());
        result.setResult(resultList);

        return result;
    }
}
