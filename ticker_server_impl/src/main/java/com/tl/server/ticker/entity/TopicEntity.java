package com.tl.server.ticker.entity;

import com.tl.rpc.reply.Reply;
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

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "readCount")
    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    @Column(name = "replyCount")
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


    public static TopicEntity formTopicEntity(Topic topic){

        TopicEntity entity = new TopicEntity();
        try{
            BeanUtils.copyProperties(entity,topic);
        }catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }

    public Topic toTopic(){
        Topic topic = new Topic();
        try{
            BeanUtils.copyProperties(topic,this);
        }catch (Exception e){
            e.printStackTrace();
        }
        return topic;
    }

}
