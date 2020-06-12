package com.example.blog.log.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * SystemLog
 */
@Entity
@Table(name = "table_system_log")
@Getter
@Setter
@ToString
public class SystemLog implements Serializable {
    
    @Id
    @Column(name = "log_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "log_module")
    private String module;
    
    @Column(name = "log_method")
    private String method;

    @Column(name = "log_type")
    private String type;

    @Column(name = "log_code")
    private String code;

    @Column(name = "log_message")
    private String message;

    @Column(name = "log_description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "log_time")
    private String time;

    @Column(name = "user_id")
    private Integer user;

    @Column(name = "user_username")
    private String username;

    @Column(updatable = false, name="log_create_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+7")
    @CreationTimestamp
    private Date createTime;

    @Column(name="log_update_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+7")
    private Date updateTime;

    @Column(name="log_delete_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+7")
    private Date deleteTime;

    @ColumnDefault("0")
    @Column(name="log_is_delete")
    private Integer isDeleted;

}