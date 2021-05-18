/**
 * @(#)mongoTest.java, 2021-04-01.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.study.my_springboot.test;

import com.google.common.collect.Lists;
import com.study.my_springboot.MySpringbootApplication;
import com.study.my_springboot.dao.CommentRepository;
import com.study.my_springboot.entity.Comment;
import com.study.my_springboot.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringbootApplication.class)
public class MongoTest {

    @Autowired
    CommentService commentService;

    @Test
    public void testSaveComment() {
        Comment comment = new Comment();
        comment.setArticleid("100000");
        comment.setContent("测试添加的数据2");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1004");
        comment.setNickname("凯撒大帝");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);

        commentService.saveComment(comment);
    }


    /**
     * * 查询所有数据     
     */
    @Test

    public void testFindAll() {
        List<Comment> list = commentService.findCommentList();
        System.out.println(list);
    }


    /**
     *     * 测试根据id查询     
     */
    @Test

    public void testFindCommentById() {
        Comment comment = commentService.findCommentById("606bd94c4fd323546cfb8bd1");
        System.out.println(comment);
    }


    /**
     *     * 测试根据父id查询子评论的分页列表     
     */
    @Test
    public void testFindCommentListPageByParentid() {
        Page<Comment> pageResponse = commentService.findCommentListByParentid("null", 1, 2);
        System.out.println("----总记录数：" + pageResponse.getTotalElements());
        System.out.println("----当前页数据：" + pageResponse.getContent());
    }


    /**
     *     * 点赞数+1     
     */
    @Test

    public void testUpdateCommentLikenum() {  //对606bd94c4fd323546cfb8bd1号文档的点赞数+1       
        commentService.updateCommentLikenum("606bd94c4fd323546cfb8bd1");
    }


}

