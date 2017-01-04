package com.tl.server.ticker;

import com.facebook.swift.codec.ThriftCodec;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServerConfig;
import com.facebook.swift.service.ThriftServiceProcessor;
import com.tl.rpc.base.BaseDataService;
import com.tl.rpc.consumer.ConsumerService;
import com.tl.rpc.lottery.LotteryDataService;
import com.tl.rpc.msg.MsgService;
import com.tl.rpc.order.OrderService;
import com.tl.rpc.product.ProductService;
import com.tl.rpc.recharge.RechargeService;
import com.tl.rpc.reply.ReplyService;
import com.tl.rpc.sys.SysUser;
import com.tl.rpc.sys.SysUserService;
import com.tl.rpc.topic.TopicService;
import com.tl.server.ticker.service.*;
import io.airlift.units.Duration;
import org.apache.thrift.server.TSimpleServer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by pangjian on 16-11-26.
 */
public class TickerServer {

    public static void main(String[] args){

        SysUserService sysUserService = new SysUserServiceImpl();
        TopicService topicService = new TopicServiceImpl();
        ReplyService replyService = new ReplyServiceImpl();
        RechargeService rechargeService = new RechargeServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        MsgService msgService = new MsgServiceImpl();
        LotteryDataService lotteryDataService = new LotteryDataServiceImpl();
        BaseDataService baseDataService = new BaseDataServiceImpl();
        ConsumerService consumerService = new ConsumerServiceImpl();
        ProductService productService = new ProductServiceImpl();

        ThriftServiceProcessor processor =
                new ThriftServiceProcessor(new ThriftCodecManager(new ThriftCodec[0]),
                        new ArrayList(),
                        new Object[]{sysUserService,topicService,replyService,rechargeService
                        ,orderService,msgService,lotteryDataService,baseDataService
                                ,consumerService,productService});

        ThriftServerConfig serverConfig = new ThriftServerConfig();
        serverConfig.setBindAddress("localhost");
        serverConfig.setPort(20000);
        new ThriftServer(processor, serverConfig).start();
    }
}
