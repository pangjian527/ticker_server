package com.tl.server.ticker.entity;

import com.tl.rpc.consumer.CONSUMERSTATUS;
import com.tl.rpc.consumer.Consumer;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pangjian on 16-11-26.
 */
@Table
@Entity(name = "t_consumer")
public class ConsumerEntity {

    private String id;

    private String mobile;

    private long balance;

    private Date createTime;

    private Date updateTime;

    private String refereeId;

    private String pwd;

    private String status;

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "balance")
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Column(name = "CREATE_TIME")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "UPDATE_TIME")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "referee_id")
    public String getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(String refereeId) {
        this.refereeId = refereeId;
    }

    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static ConsumerEntity formConsumerEntity(Consumer consumer){

        ConsumerEntity entity = new ConsumerEntity();
        entity.setId(consumer.getId());
        entity.setMobile(consumer.getMobile());
        entity.setPwd(consumer.getPwd());
        entity.setRefereeId(consumer.getRefereeId());
        entity.setCreateTime(new Date(consumer.getCreateTime()));
        entity.setUpdateTime(new Date(consumer.getUpdateTime()));
        entity.setStatus(consumer.getStatus().name());
        entity.setBalance(consumer.getBalance());
        return entity;
    }

    public Consumer toConsumer(){
        Consumer consumer = new Consumer();
        consumer.setId(this.id);
        consumer.setMobile(this.mobile);
        consumer.setPwd(this.pwd);
        consumer.setRefereeId(this.refereeId);
        consumer.setCreateTime(this.createTime.getTime());
        consumer.setUpdateTime(this.updateTime.getTime());
        consumer.setStatus(CONSUMERSTATUS.valueOf(this.status));
        consumer.setBalance(this.balance);
        return consumer;
    }
}
