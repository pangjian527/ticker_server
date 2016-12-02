package com.tl.server.ticker.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pangjian on 16-11-26.
 */
public class BaseDaoImpl<T> {

    private final Class<T> clazz;

    private Map<String,Object> param;

    private Session session ;
    private SessionFactory sessionFactory;

    private NativeQuery<T> nativeQuery;

    private StringBuilder sql ;

    private int offset;
    private int limit;

    public BaseDaoImpl(Class<T> clazz){
        Configuration configure = new Configuration().configure();
        this.sessionFactory = configure.buildSessionFactory();
        this.session = sessionFactory.openSession();

        this.clazz = clazz;

        param= new HashMap<String, Object>();
    }

    public void save(T t){
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


    protected BaseDaoImpl setSql(String sql){
        this.sql = new StringBuilder(sql);
        return this;
    }

    protected BaseDaoImpl setParameter(String name, String value){
        this.param.put(name,value);
        return this;
    }

    protected BaseDaoImpl setOffset(int offset){
        this.offset = offset;
        return this;
    }

    protected BaseDaoImpl setLimit(int limit){
        this.limit = limit;
        return this;
    }

    public List<T> execute(){

        StringBuilder sqlTemp =  new StringBuilder( this.sql.toString());

        if(limit >0 ){
            sqlTemp.append(" limit ").append(offset).append(",").append(limit);
        }

        return this.getSession().createNativeQuery(sqlTemp.toString(),this.clazz).setProperties(this.param).list();
    }

    public int getCount(){
        return Integer.valueOf(this.getSession().createNativeQuery("select count(1) from ("+ this.sql+") t_count_temp ").setProperties(this.param).uniqueResult().toString());
    }


    public T get(Serializable id){
        return (T) session.get(clazz,id);
    }

    public Session getSession(){
        return this.session;
    }
}
