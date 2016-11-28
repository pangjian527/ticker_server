package com.tl.server.ticker;


import com.tl.server.ticker.entity.SysUserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by pangjian on 16-11-26.
 */
public class Test {

    public static void main(String[] args){

        Configuration configure = new Configuration().configure();

        SessionFactory sessionFactory = configure.buildSessionFactory();

        Session session = sessionFactory.openSession();

        SysUserEntity sysUser = new SysUserEntity();

        sysUser.setAccount("pangjian");
        sysUser.setPwd("123");
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());

        session.beginTransaction();
        session.save(sysUser);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
