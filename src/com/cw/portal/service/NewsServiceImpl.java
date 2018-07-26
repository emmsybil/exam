package com.cw.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cw.common.domain.news.News;
import com.cw.common.util.Page;
import com.cw.portal.persistence.NewsMapper;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsMapper newsMapper;
	@Override
	public List<News> getNewsList(Page<News> page) {
		// TODO Auto-generated method stub
		return newsMapper.getNewsList(page);
	}

	@Override
	public News getNewsById(int newsId) {
		// TODO Auto-generated method stub
		return newsMapper.getNewsById(newsId);
	}

}
