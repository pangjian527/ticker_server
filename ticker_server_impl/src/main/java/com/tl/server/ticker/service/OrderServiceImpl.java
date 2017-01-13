package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.order.Order;
import com.tl.rpc.order.OrderResult;
import com.tl.rpc.order.OrderService;
import com.tl.server.ticker.entity.BaseDataEntity;
import com.tl.server.ticker.entity.OrderEntity;
import org.apache.thrift.TException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.math.BigInteger;
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

        String sql = "select * from t_order o order by o.create_time desc ";

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
        String sql = "select * from t_order o where o.user_id =:userId order by o.create_time desc ";

        List<OrderEntity> list = this.setSql(sql).setParameter("userId",userId).setLimit(limit).setOffset(offset).execute();

        List<Order> resultList = new LinkedList<Order>();
        for (OrderEntity entity:list) {
            resultList.add(entity.toOrder());
        }

        OrderResult result = new OrderResult();
        result.setTotalCount(this.getCount());
        result.setResult(resultList);

        return result;
    }

    @Override
    public int totalCountByProductId(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "productId", requiredness = ThriftField.Requiredness.NONE) String productId) throws RpcException, TException {

        StringBuilder sql = new StringBuilder("select count(1) from t_order o where 1=1 ");

        Session session = this.getSession();

        if(productId != null){
            sql.append(" and o.product_Id = :productId");
        }

        Query query = session.createNativeQuery(sql.toString());

        if(productId != null){
            query.setParameter("productId",productId);
        }

        Object object = query.uniqueResult();

        return Integer.valueOf(object.toString());
    }

    @Override
    public List<Order> getOrderByProductId(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "productId", requiredness = ThriftField.Requiredness.NONE) String productId) throws RpcException, TException {
        StringBuilder sql = new StringBuilder("select * from t_order o where 1=1 ");

        if(productId != null){
            sql.append(" and o.product_Id = :productId");
        }

        List<OrderEntity> list = this.setSql(sql.toString()).setParameter("productId",productId).execute();

        List<Order> resultList = new LinkedList<Order>();
        for (OrderEntity entity:list) {
            resultList.add(entity.toOrder());
        }

        return resultList;
    }
}
