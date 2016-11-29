package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.msg.Msg;
import com.tl.rpc.msg.MsgService;
import com.tl.server.ticker.entity.MsgEntity;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class MsgServiceImpl extends BaseDaoImpl<MsgEntity> implements MsgService {

    public MsgServiceImpl(){
        super(MsgEntity.class);
    }

    public void sendMsg(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "msg", requiredness = ThriftField.Requiredness.NONE) Msg msg) throws RpcException, TException {
        this.save(MsgEntity.formMsgEntity(msg));
    }

    public List<Msg> searchMsg(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "mobile", requiredness = ThriftField.Requiredness.NONE) String mobile) throws RpcException, TException {

        String sql = "select * from t_msg m where m.mobile = mobile ";

        List<MsgEntity> list = this.setSql(sql).setParameter("mobile", mobile).execute();

        List<Msg> listMsg = new ArrayList<Msg>();
        for (MsgEntity entity:list) {
            listMsg.add(entity.toMsg());
        }

        return listMsg;
    }
}
