package com.sasori.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

import com.sasori.model.CrawlerData;

public interface CrawlerDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CrawlerData record);

    int insertSelective(CrawlerData record);

    CrawlerData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CrawlerData record);

    int updateByPrimaryKey(CrawlerData record);

	void insertList(@Param("list")List<CrawlerData> list);

	void crawlerGroup(@Param("code") String code);
}