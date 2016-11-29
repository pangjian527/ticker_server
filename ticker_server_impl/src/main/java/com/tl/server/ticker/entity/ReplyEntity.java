package com.tl.server.ticker.entity;

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

    @Column(name = "userId")
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

    public static ReplyEntity formReplyEntity(Reply reply){

        ReplyEntity entity = new ReplyEntity();
        try{
            BeanUtils.copyProperties(entity,reply);
        }catch (Exception e){
            e.printStackTrace();
        }
        return entity;
    }

    public Reply toReply(){
        Reply reply = new Reply();
        try{
            BeanUtils.copyProperties(reply,this);
        }catch (Exception e){
            e.printStackTrace();
        }
        return reply;
    }
}
