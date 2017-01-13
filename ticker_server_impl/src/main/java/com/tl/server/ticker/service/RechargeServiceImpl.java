package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.recharge.Recharge;
import com.tl.rpc.recharge.RechargeService;
import com.tl.rpc.recharge.SearchResult;
import com.tl.server.ticker.entity.RechargeEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class RechargeServiceImpl extends BaseDaoImpl<RechargeEntity> implements RechargeService {

    public RechargeServiceImpl(){
        super(RechargeEntity.class);
    }

    public void saveRecharge(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "Recharge", requiredness = ThriftField.Requiredness.NONE) Recharge recharge) throws RpcException, TException {
        this.save(RechargeEntity.formRechargeEntity(recharge));
    }

    public SearchResult searchRecharge(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset, @ThriftField(value = 4, name = "userId", requiredness = ThriftField.Requiredness.NONE) String userId) throws RpcException, TException {

        StringBuilder sql = new StringBuilder("select * from t_recharge r ");

        if(StringUtils.isNotBlank(userId)){
            sql.append(" where r.user_id = :userId");
            this.setParameter("userId",userId);
        }

        sql.append(" order by  r.create_time desc ");

        List<RechargeEntity> list = this.setSql(sql.toString()).setLimit(limit).setOffset(offset).execute();

        List<Recharge> listResult = new LinkedList<Recharge>();
        for (RechargeEntity entity: list) {
            listResult.add(entity.toRecharge());
        }

        SearchResult result = new SearchResult();
        result.setTotalCount(this.getCount());
        result.setResult(listResult);

        return result;
    }
}
