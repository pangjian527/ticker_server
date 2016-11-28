package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.lottery.LotteryData;
import com.tl.rpc.lottery.LotteryDataService;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class LotteryDataServiceImpl implements LotteryDataService {
    public List<LotteryData> search(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "year", requiredness = ThriftField.Requiredness.NONE) int year, @ThriftField(value = 3, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 4, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset) throws RpcException, TException {

        
        return null;
    }

    public void save(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "lotteryData", requiredness = ThriftField.Requiredness.NONE) LotteryData lotteryData) throws RpcException, TException {

    }
}
