package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.sys.SysUser;
import com.tl.rpc.sys.SysUserService;
import com.tl.server.ticker.entity.SysUserEntity;
import org.apache.thrift.TException;

import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class SysUserServiceImpl extends BaseDaoImpl<SysUserEntity> implements SysUserService{

    public SysUserServiceImpl(){
        super(SysUserEntity.class);
    }


    public SysUser getByAccount(@ThriftField(value = 1, name = "serviceToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken serviceToken, @ThriftField(value = 2, name = "userId", requiredness = ThriftField.Requiredness.NONE) String userId) throws RpcException, TException {
        return this.get(userId).toSysUser();
    }

}
