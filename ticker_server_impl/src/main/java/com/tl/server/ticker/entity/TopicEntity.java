package com.tl.server.ticker.entity;

import com.tl.rpc.reply.Reply;
import com.tl.rpc.topic.TOPICSTATUS;
import com.tl.rpc.topic.TOPICTYPE;
import com.tl.rpc.topic.Topic;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pangjian on 16-11-26.
 */
@Table
@Entity(name = "t_topic")
public class TopicEntity {

    private String id;

    private String title;

    private String content;

    private String userId;

    private int readCount;

    private int replyCount;

    private Date createTime;

    private Date updateTime;

    private String status;

    private String type;

    private int year;

    private int stage;

    private double balance;

    private String expect;//预测内容，json格式


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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "content",columnDefinition="BLOB", nullable=true)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "user_Id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "read_Count")
    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    @Column(name = "reply_Count")
    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Column(name = "balance")
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Column(name = "expect")
    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public static TopicEntity formTopicEntity(Topic topic){

        TopicEntity entity = new TopicEntity();

        entity.setId(topic.getId());
        entity.setUserId(topic.getUserId());
        entity.setTitle(topic.getTitle());
        entity.setCreateTime(new Date(topic.getCreateTime()));
        entity.setContent(topic.getContent());
        entity.setReadCount(topic.getReadCount());
        entity.setReplyCount(topic.getReplyCount());
        entity.setStage(topic.getStage());
        entity.setYear(topic.getYear());
        entity.setStatus(topic.getStatus().name());
        entity.setType(topic.getType().name());
        entity.setBalance(topic.getBalance());
        entity.setExpect(topic.getExpect());

        return entity;
    }

    public Topic toTopic(){
        Topic topic = new Topic();

        topic.setId(this.id);
        topic.setUserId(this.getUserId());
        topic.setTitle(this.title);
        topic.setCreateTime(this.getCreateTime().getTime());
        topic.setContent(this.getContent());
        topic.setReadCount(this.getReadCount());
        topic.setReplyCount(this.getReplyCount());
        topic.setStage(this.getStage());
        topic.setYear(this.getYear());
        topic.setStatus(TOPICSTATUS.valueOf(this.getStatus()));
        topic.setType(TOPICTYPE.valueOf(this.getType()));
        topic.setBalance((long)this.balance);
        topic.setExpect(this.expect);

        return topic;
    }

}
