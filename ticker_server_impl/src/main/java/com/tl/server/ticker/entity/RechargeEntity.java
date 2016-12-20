package com.tl.server.ticker.entity;

import com.tl.rpc.recharge.Recharge;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pangjian on 16-11-26.
 */
@Table
@Entity(name = "t_recharge")
public class RechargeEntity {

    private String id;

    private String userId;

    private double amount;

    private double giveAmount;

    private Date createTime;

    private Date updateTime;

    private String source;

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

    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "give_amount")
    public double getGiveAmount() {
        return giveAmount;
    }

    public void setGiveAmount(double giveAmount) {
        this.giveAmount = giveAmount;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public static RechargeEntity formRechargeEntity(Recharge recharge){

        RechargeEntity entity = new RechargeEntity();
        entity.setUserId(recharge.getUserId());
        entity.setSource(recharge.getSource());
        entity.setGiveAmount(recharge.getGiveAmount());
        entity.setAmount(recharge.getAmount());
        entity.setId(recharge.getId());
        entity.setCreateTime(new Date(recharge.getCreateTime()));

        return entity;
    }

    public Recharge toRecharge(){
        Recharge recharge = new Recharge();
        recharge.setUserId(this.getUserId());
        recharge.setSource(this.getSource());
        recharge.setGiveAmount((long)this.getGiveAmount());
        recharge.setAmount((long)this.getAmount());
        recharge.setId(this.getId());
        recharge.setCreateTime(this.getCreateTime().getTime());
        return recharge;
    }
}
