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
@Entity(name = "t_reaharge")
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
        try{
            BeanUtils.copyProperties(entity,recharge);
        }catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }

    public Recharge toRecharge(){
        Recharge recharge = new Recharge();
        try{
            BeanUtils.copyProperties(recharge,this);
        }catch (Exception e){
            e.printStackTrace();
        }
        return recharge;
    }
}
