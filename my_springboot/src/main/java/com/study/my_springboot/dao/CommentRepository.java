/**
 * @(#)CommentRepository.java, 2021-04-01.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.dao;

import com.study.my_springboot.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public interface CommentRepository extends MongoRepository<Comment,String> {

    Page<Comment> findByParentid(String parentid, PageRequest of);
}