package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.msg.Msg;
import com.tl.rpc.msg.MsgService;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class MsgServiceImpl implements MsgService {
    public void sendMsg(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "mobile", requiredness = ThriftField.Requiredness.NONE) String mobile, @ThriftField(value = 3, name = "content", requiredness = ThriftField.Requiredness.NONE) String content) throws RpcException, TException {

    }

    public List<Msg> search(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "mobile", requiredness = ThriftField.Requiredness.NONE) String mobile) throws RpcException, TException {
        return null;
    }
}
