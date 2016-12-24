package com.tl.server.ticker.entity;

import com.tl.rpc.reply.REPLYSTATUS;
import com.tl.rpc.reply.Reply;
import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pangjian on 16-11-26.
 */
@Table
@Entity(name = "t_reply")
public class ReplyEntity {

    private String id;

    private String content;

    private String userId;

    private Date createTime;

    private Date updateTime;

    private String status;

    private String topicId;

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

    @Column(name = "content")
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

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "topic_id")
    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public static ReplyEntity formReplyEntity(Reply reply){

        ReplyEntity entity = new ReplyEntity();
        entity.id = reply.getId();
        entity.content = reply.getContent();
        entity.userId = reply.getUserId();
        entity.createTime = new Date(reply.getCreateTime());
        entity.topicId = reply.getTopicId();
        entity.status = reply.getStatus().name();

        return entity;
    }

    public Reply toReply(){
        Reply reply = new Reply();

        reply.setUserId(this.getUserId());
        reply.setContent(this.content);
        reply.setId(this.id);
        reply.setCreateTime(this.createTime.getTime());
        reply.setTopicId(this.topicId);
        reply.setStatus(REPLYSTATUS.valueOf(this.status));

        return reply;
    }
}
