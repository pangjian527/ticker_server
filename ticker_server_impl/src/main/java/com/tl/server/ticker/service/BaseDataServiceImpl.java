package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.base.BaseData;
import com.tl.rpc.base.BaseDataService;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.server.ticker.entity.BaseDataEntity;
import org.apache.thrift.TException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pangjian on 16-11-26.
 */
public class BaseDataServiceImpl extends BaseDaoImpl<BaseDataEntity> implements BaseDataService{

    public BaseDataServiceImpl(){
        super(BaseDataEntity.class);
    }

    public void saveBaseData(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "baseData", requiredness = ThriftField.Requiredness.NONE) BaseData baseData) throws RpcException, TException {
        this.save(BaseDataEntity.formBaseDataEntity(baseData));
    }

    public List<BaseData> searchBaseData(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "year", requiredness = ThriftField.Requiredness.NONE) int year) throws RpcException, TException {

        String sql = "select * from t_base_data b where b.year =:year";

        Session session = this.getSession();

        List<BaseDataEntity> list = session.createNativeQuery(sql,BaseDataEntity.class).setParameter("year",year).list();

        session.close();

        List<BaseData> resultList = new LinkedList<BaseData>();
        for (BaseDataEntity entity : list) {
            resultList.add(entity.toBaseData());
        }

        return resultList;
    }

}
