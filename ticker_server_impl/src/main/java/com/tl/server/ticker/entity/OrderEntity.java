package com.tl.server.ticker.entity;

import com.tl.rpc.order.ORDERSTATUS;
import com.tl.rpc.order.Order;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pangjian on 16-11-26.
 */
@Table
@Entity(name = "t_order")
public class OrderEntity {

    private String id;

    private double amount;

    private String userId;

    private String productId;

    private String result;

    private Date createTime;

    private Date updateTime;

    private String status;

    private int year;

    private int stage ;

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

    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Column(name = "user_Id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "product_Id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Column(name = "result")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name = "stage")
    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }


    public static OrderEntity formOrderEntity(Order order){

        OrderEntity entity = new OrderEntity();
        entity.setId(order.getId());
        entity.setUserId(order.getUserId());
        entity.setStage(order.getStage());
        entity.setYear(order.getYear());
        entity.setAmount(order.getAmount());
        entity.setResult(order.getResult());
        entity.setStatus(order.getStatus().name());
        entity.setProductId(order.getProductId());
        entity.setCreateTime(new Date(order.getCreateTime()));

        return entity;
    }

    public Order toOrder(){
        Order order = new Order();

        order.setId(this.id);
        order.setUserId(this.userId);
        order.setStage(this.stage);
        order.setYear(this.year);
        order.setAmount((long)this.amount);
        order.setResult(this.result);
        order.setStatus(ORDERSTATUS.valueOf(this.status));
        order.setProductId(this.getProductId());
        order.setCreateTime(this.getCreateTime().getTime());

        return order;
    }
}
