package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.lottery.LotteryData;
import com.tl.rpc.lottery.LotteryDataService;
import com.tl.rpc.lottery.SearchResult;
import com.tl.server.ticker.entity.LotteryDataEntity;
import org.apache.thrift.TException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class LotteryDataServiceImpl extends BaseDaoImpl<LotteryDataEntity> implements LotteryDataService {

    public LotteryDataServiceImpl(){
        super(LotteryDataEntity.class);
    }

    public SearchResult search(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken,
                               @ThriftField(value = 2, name = "year", requiredness = ThriftField.Requiredness.NONE) int year,
                               @ThriftField(value = 3, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit,
                               @ThriftField(value = 4, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset) throws RpcException, TException {

        String sql = "select * from t_lottery_data d where d.year = :year order by d.update_time desc ";

        List<LotteryDataEntity> list = this.setSql(sql).setParameter("year", year + "")
                .setOffset(offset).setLimit(limit).execute();

        List<LotteryData> resultList = new LinkedList<LotteryData>();

        SearchResult result= new SearchResult();
        for (LotteryDataEntity entity:list) {
            resultList.add(entity.toLotteryData());
        }

        result.setTotalCount(this.getCount());
        result.setResult(resultList);
        return result;
    }

    public void save(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "lotteryData", requiredness = ThriftField.Requiredness.NONE) LotteryData lotteryData) throws RpcException, TException {
        this.save(LotteryDataEntity.formLotteryDataEntity(lotteryData));
    }
}
