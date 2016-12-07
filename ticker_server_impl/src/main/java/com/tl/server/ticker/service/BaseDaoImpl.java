package com.tl.server.ticker.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

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

    private NativeQuery<T> nativeQuery;

    private StringBuilder sql ;

    private int offset;
    private int limit;

    private SessionFactory sessionFactory;

    public BaseDaoImpl(Class<T> clazz){
        this.clazz = clazz;
        param= new HashMap<String, Object>();
    }

    protected Session getSession(){
        if(sessionFactory == null){
            Configuration configure = new Configuration().configure();
            sessionFactory = configure.buildSessionFactory();
        }
        Session session = sessionFactory.openSession();
        return session;
    }

    public void save(T t){
        Session session = this.getSession();

        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();

        session.close();
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

        Session session = this.getSession();

        NativeQuery<T> nativeQuery =session.createNativeQuery(sqlTemp.toString(), this.clazz);

        List<T> list = nativeQuery.setProperties(this.param).list();
        session.close();

        return list;
    }

    public int getCount(){
        Session session = this.getSession();
        String count = session.createNativeQuery("select count(1) from (" + this.sql + ") t_count_temp ").setProperties(this.param).uniqueResult().toString();

        session.close();
        return Integer.valueOf(count);
    }

    public T get(Serializable id){
        Session session = this.getSession();
        T t = session.get(clazz, id);
        session.close();
        return  t;
    }

}
