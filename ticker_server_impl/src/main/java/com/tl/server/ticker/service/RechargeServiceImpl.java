package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.recharge.Recharge;
import com.tl.rpc.recharge.RechargeService;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class RechargeServiceImpl implements RechargeService {
    public void save(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "Recharge", requiredness = ThriftField.Requiredness.NONE) Recharge recharge) throws RpcException, TException {

    }

    public List<Recharge> search(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset, @ThriftField(value = 4, name = "userId", requiredness = ThriftField.Requiredness.NONE) String userId) throws RpcException, TException {
        return null;
    }
}
