package com.expava.cstopics.mybatis;





import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleMapperIntegration {

	@Autowired
	ArticleMapper articleMapper;

	@PostConstruct 
	public void whenRecordsInDatabase_shouldReturnArticleWithGivenId() {
		Article article = articleMapper.getArticle(1L);

		System.out.println(article.getId());
		System.out.println(article.getAuthor());
		System.out.println(article.getTitle());
	}
}
