package com.study.my_springboot.mapper;

import com.study.my_springboot.bean.pojo.Perm;
import com.study.my_springboot.bean.pojo.PermExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermMapper {
    long countByExample(PermExample example);

    int deleteByExample(PermExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Perm record);

    int insertSelective(Perm record);

    List<Perm> selectByExample(PermExample example);

    Perm selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Perm record, @Param("example") PermExample example);

    int updateByExample(@Param("record") Perm record, @Param("example") PermExample example);

    int updateByPrimaryKeySelective(Perm record);

    int updateByPrimaryKey(Perm record);
}