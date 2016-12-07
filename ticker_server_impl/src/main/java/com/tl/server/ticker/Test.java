package com.tl.server.ticker;


import com.tl.rpc.common.ServiceToken;
import com.tl.rpc.consumer.Consumer;
import com.tl.rpc.consumer.ConsumerService;
import com.tl.rpc.consumer.SearchResult;
import com.tl.rpc.sys.SysUser;
import com.tl.rpc.sys.SysUserService;
import com.tl.server.ticker.entity.SysUserEntity;
import com.tl.server.ticker.service.ConsumerServiceImpl;
import com.tl.server.ticker.service.SysUserServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by pangjian on 16-11-26.
 */
public class Test {

    public static void main(String[] args) throws Exception{

        /*Configuration configure = new Configuration().configure();

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
        sessionFactory.close();*/

        ClassPathXmlApplicationContext parentContent = new ClassPathXmlApplicationContext(new String[] { "/applicationContext.xml" },
                false);

        parentContent.setValidating(false);
        parentContent.refresh();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.setParent(parentContent);
        context.refresh();

        SysUserService sysUserService = context.getBean(SysUserServiceImpl.class);

        SysUser sysUser = sysUserService.getByAccount(new ServiceToken(), "pangjian");

        System.out.println(sysUser.getAccount());
    }
}
