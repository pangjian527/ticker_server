package com.tl.server.ticker.entity;

import com.tl.rpc.lottery.LotteryData;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pangjian on 16-11-26.
 */
@Table
@Entity(name = "t_lottery_data")
public class LotteryDataEntity {

    private String id;

    private String baseDataId;

    private int stage;

    private int year;

    private int number;

    private Date createTime;

    private Date updateTime;

    private Date lotteryTime;//开奖日期

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

    @Column(name = "stage")
    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    @Column(name = "base_data_id")
    public String getBaseDataId() {
        return baseDataId;
    }

    public void setBaseDataId(String baseDataId) {
        this.baseDataId = baseDataId;
    }

    @Column(name = "lottery_time")
    public Date getLotteryTime() {
        return lotteryTime;
    }

    public void setLotteryTime(Date lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    public static LotteryDataEntity formLotteryDataEntity(LotteryData lotteryData){

        LotteryDataEntity entity = new LotteryDataEntity();
        entity.id = lotteryData.getId();
        entity.baseDataId = lotteryData.getBaseDataId();
        entity.year = lotteryData.getYear();
        entity.number = lotteryData.getNumber();
        entity.stage = lotteryData.getStage();
        entity.createTime = new Date(lotteryData.getCreateTime());
        entity.updateTime = new Date(lotteryData.getUpdateTime());
        entity.lotteryTime = new Date(lotteryData.getLotteryTime());

        return entity;
    }

    public LotteryData toLotteryData(){
        LotteryData lotteryData = new LotteryData();

        lotteryData.setId(this.id);
        lotteryData.setYear(this.year);
        lotteryData.setUpdateTime(this.updateTime.getTime());
        lotteryData.setCreateTime(this.createTime.getTime());
        lotteryData.setNumber(this.number);
        lotteryData.setStage(this.stage);
        lotteryData.setLotteryTime(this.lotteryTime.getTime());
        lotteryData.setBaseDataId(this.baseDataId);

        return lotteryData;
    }



}
