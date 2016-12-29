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

    private int stage;

    private int year;

    private int number;

    private Date createTime;

    private Date updateTime;

    private Date lotteryTime;//开奖日期

    private int flatNumber1;

    private int flatNumber2;

    private int flatNumber3;

    private int flatNumber4;

    private int flatNumber5;

    private int flatNumber6;

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

    @Column(name = "lottery_time")
    public Date getLotteryTime() {
        return lotteryTime;
    }

    public void setLotteryTime(Date lotteryTime) {
        this.lotteryTime = lotteryTime;
    }

    @Column(name = "flat_Number1")
    public int getFlatNumber1() {
        return flatNumber1;
    }

    public void setFlatNumber1(int flatNumber1) {
        this.flatNumber1 = flatNumber1;
    }

    @Column(name = "flat_Number2")
    public int getFlatNumber2() {
        return flatNumber2;
    }

    public void setFlatNumber2(int flatNumber2) {
        this.flatNumber2 = flatNumber2;
    }

    @Column(name = "flat_Number3")
    public int getFlatNumber3() {
        return flatNumber3;
    }

    public void setFlatNumber3(int flatNumber3) {
        this.flatNumber3 = flatNumber3;
    }
    @Column(name = "flat_Number4")
    public int getFlatNumber4() {
        return flatNumber4;
    }

    public void setFlatNumber4(int flatNumber4) {
        this.flatNumber4 = flatNumber4;
    }
    @Column(name = "flat_Number5")
    public int getFlatNumber5() {
        return flatNumber5;
    }

    public void setFlatNumber5(int flatNumber5) {
        this.flatNumber5 = flatNumber5;
    }
    @Column(name = "flat_Number6")
    public int getFlatNumber6() {
        return flatNumber6;
    }

    public void setFlatNumber6(int flatNumber6) {
        this.flatNumber6 = flatNumber6;
    }

    public static LotteryDataEntity formLotteryDataEntity(LotteryData lotteryData){

        LotteryDataEntity entity = new LotteryDataEntity();
        entity.id = lotteryData.getId();
        entity.year = lotteryData.getYear();
        entity.number = lotteryData.getNumber();
        entity.stage = lotteryData.getStage();
        entity.createTime = new Date(lotteryData.getCreateTime());
        entity.updateTime = new Date(lotteryData.getUpdateTime());
        entity.lotteryTime = new Date(lotteryData.getLotteryTime());
        entity.flatNumber1 = lotteryData.getFlatNumber1();
        entity.flatNumber2 = lotteryData.getFlatNumber2();
        entity.flatNumber3 = lotteryData.getFlatNumber3();
        entity.flatNumber4 = lotteryData.getFlatNumber4();
        entity.flatNumber5 = lotteryData.getFlatNumber5();
        entity.flatNumber6 = lotteryData.getFlatNumber6();

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
        lotteryData.setFlatNumber1(this.getFlatNumber1());
        lotteryData.setFlatNumber2(this.getFlatNumber2());
        lotteryData.setFlatNumber3(this.getFlatNumber3());
        lotteryData.setFlatNumber4(this.getFlatNumber4());
        lotteryData.setFlatNumber5(this.getFlatNumber5());
        lotteryData.setFlatNumber6(this.getFlatNumber6());

        return lotteryData;
    }



}
