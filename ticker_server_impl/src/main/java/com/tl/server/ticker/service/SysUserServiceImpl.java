package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.sys.SysUser;
import com.tl.rpc.sys.SysUserService;
import com.tl.server.ticker.entity.SysUserEntity;
import org.apache.thrift.TException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class SysUserServiceImpl extends BaseDaoImpl<SysUserEntity> implements SysUserService{

    public SysUserServiceImpl(){
        super(SysUserEntity.class);
    }

    public SysUser getByAccount(@ThriftField(value = 1, name = "serviceToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken serviceToken, @ThriftField(value = 2, name = "account", requiredness = ThriftField.Requiredness.NONE) String account) throws RpcException, TException {

        StringBuilder sql = new StringBuilder("select * from sys_user u where u.account = :account");

        List<SysUserEntity> list = this.setSql(sql.toString()).setParameter("account", account).execute();

        if(list.size() > 0 ){
            return list.get(0).toSysUser();
        }

        return null;
    }
}
