package com.tl.server.ticker.entity;

import com.tl.rpc.product.PRODUCTSTATUS;
import com.tl.rpc.product.Product;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pangjian on 16-12-7.
 */
@Table
@Entity(name = "t_product")
public class ProductEntity {

    private String id;

    private String expect;

    private double balance;

    private Date createTime;

    private int year;

    private int stage;

    private Date updateTime;

    private String status;

    private String title;

    private String mobile;

    private int virtualCount;

    private String probability;

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

    @Column(name = "expect")
    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Column(name = "create_Time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    @Column(name = "update_Time")
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "virtual_Count")
    public int getVirtualCount() {
        return virtualCount;
    }

    public void setVirtualCount(int virtualCount) {
        this.virtualCount = virtualCount;
    }

    @Column(name = "probability")
    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public static ProductEntity fromProduct(Product product){
        ProductEntity entity = new ProductEntity();

        entity.setId(product.getId());
        entity.setStatus(product.getStatus().name());
        entity.setStage(product.getStage());
        entity.setCreateTime(new Date(product.getCreateTime()));
        entity.setBalance(product.getBalance());
        entity.setExpect(product.getExpect());
        entity.setUpdateTime(new Date(product.getUpdateTime()));
        entity.setYear(product.getYear());
        entity.setTitle(product.getTitle());
        entity.setMobile(product.getMobile());
        entity.setVirtualCount(product.getVirtualCount());
        entity.setProbability(product.getProbability());

        return entity;
    }

    public Product toProduct(){
        Product product = new Product();

        product.setId(this.getId());
        product.setStatus(PRODUCTSTATUS.valueOf(this.getStatus()));
        product.setStage(this.getStage());
        product.setCreateTime(this.getCreateTime().getTime());
        product.setBalance((long)this.getBalance());
        product.setExpect(this.getExpect());
        product.setUpdateTime(this.getUpdateTime().getTime());
        product.setYear(this.getYear());
        product.setTitle(this.getTitle());
        product.setMobile(this.getMobile());
        product.setVirtualCount(this.getVirtualCount());
        product.setProbability(this.getProbability());

        return product;
    }



}
