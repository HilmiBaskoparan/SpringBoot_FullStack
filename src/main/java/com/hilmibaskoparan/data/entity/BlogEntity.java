package com.hilmibaskoparan.data.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "blog")
public class BlogEntity extends BaseEntity implements Serializable {

    public static final Long serialVersionUID = 1L;

    @Column(name = "header", columnDefinition = "varchar(255) default 'Header girmediniz'")
    private String header;

    @Column(name = "content", columnDefinition = "varchar(255) default 'Header girmediniz'")
    private String content;

}
