package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.dao.entity.News;
import com.sm.dao.mapper.INewsMapper;


public class NewsServiceImp implements NewsService {
	private INewsMapper newsDao;

	@Override
	public List<News> queryAllNews() {
		return newsDao.queryAllNews();
	}

}
