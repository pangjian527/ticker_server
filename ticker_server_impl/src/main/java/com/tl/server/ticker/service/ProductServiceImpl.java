package com.tl.server.ticker.service;

import com.facebook.swift.codec.ThriftField;
import com.tl.rpc.common.RpcException;
import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.product.Product;
import com.tl.rpc.product.ProductService;
import com.tl.rpc.product.SearchProductResult;
import com.tl.server.ticker.entity.ProductEntity;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pangjian on 16-12-7.
 */
public class ProductServiceImpl extends BaseDaoImpl<ProductEntity> implements ProductService {

    public ProductServiceImpl(){
        super(ProductEntity.class);
    }

    @Override
    public void saveProduct(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "product", requiredness = ThriftField.Requiredness.NONE) Product product) throws RpcException, TException {
        this.save(ProductEntity.fromProduct(product));
    }

    @Override
    public SearchProductResult searchProduct(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "limit", requiredness = ThriftField.Requiredness.NONE) int limit, @ThriftField(value = 3, name = "offset", requiredness = ThriftField.Requiredness.NONE) int offset) throws RpcException, TException {
        String sql = "select * from t_product o order by o.update_time desc ";

        List<ProductEntity> list = this.setSql(sql).setLimit(limit).setOffset(offset).execute();

        List<Product> resultList = new LinkedList<Product>();
        for (ProductEntity entity:list) {
            resultList.add(entity.toProduct());
        }

        SearchProductResult result = new SearchProductResult();
        result.setTotalCount(this.getCount());
        result.setResult(resultList);

        return result;
    }

    @Override
    public Product getByProductId(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "productId", requiredness = ThriftField.Requiredness.NONE) String productId) throws RpcException, TException {
        return this.get(productId).toProduct();
    }

    @Override
    public List<Product> getProductByYearAndStage(@ThriftField(value = 1, name = "accessToken", requiredness = ThriftField.Requiredness.NONE) ServiceToken accessToken, @ThriftField(value = 2, name = "year", requiredness = ThriftField.Requiredness.NONE) int year, @ThriftField(value = 3, name = "stage", requiredness = ThriftField.Requiredness.NONE) int stage) throws RpcException, TException {

        StringBuilder sql = new StringBuilder("select * from t_product p where 1=1 ");

        if(year > 0){
            sql.append(" and p.year = :year");
        }
        if(stage >=0 ){
            sql.append(" and p.stage = :stage");
        }

        BaseDaoImpl baseDao = this.setSql(sql.toString()).setParameter("stage", stage + "").setParameter("year", year + "");

        List<ProductEntity> list = baseDao.execute();

        List<Product> resultList = new LinkedList<Product>();
        for (ProductEntity entity:list) {
            resultList.add(entity.toProduct());
        }

        return resultList;
    }
}
