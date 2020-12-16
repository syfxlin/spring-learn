package com.sm.dao.mapper;
/*
 * 定义DAO接口，未写实现类（不同于Service层）
 * DAO层实现是由Mybatis框架自动建立接口方法与SQL id之间的映射完成的
 */
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sm.dao.entity.News;

public interface INewsMapper {
	
	public List<News> queryAllNews();
}
