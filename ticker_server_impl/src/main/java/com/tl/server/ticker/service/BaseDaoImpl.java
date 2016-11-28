package com.tl.server.ticker.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

/**
 * Created by pangjian on 16-11-26.
 */
public class BaseDaoImpl<T> {

    private final Class<T> clazz;

    private Session session ;
    private SessionFactory sessionFactory;

    public BaseDaoImpl(Class<T> clazz){
        Configuration configure = new Configuration().configure();
        this.sessionFactory = configure.buildSessionFactory();
        this.session = sessionFactory.openSession();

        this.clazz = clazz;
    }

    public void save(T t){
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public T get(Serializable id){
        return (T) session.get(clazz,id);
    }

    public Session getSession(){
        return this.session;
    }
}
