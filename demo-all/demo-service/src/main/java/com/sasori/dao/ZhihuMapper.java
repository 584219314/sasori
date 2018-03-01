package com.sasori.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sasori.model.Zhihu;

public interface ZhihuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhihu record);

    int insertSelective(Zhihu record);

    Zhihu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhihu record);

    int updateByPrimaryKey(Zhihu record);

	void insertList(@Param("list")List<Zhihu> req);

	void zhihuGroup(@Param("code")String code);
}