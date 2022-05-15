package com.expava.gpp.contentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.expava.gpp.contentmanagement.model.Article;
import com.expava.gpp.contentmanagement.service.ArticleService;
import com.expava.gpp.contentmanagement.service.UserService;
import com.google.common.base.Preconditions;

import io.swagger.annotations.Api;

@RestController
@Api("This is The Hello Swagger API Documentation")
@RequestMapping("/rest")
public class ControllerRest {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/article-management/article")
    public List<Article> findAllArticles() {
        return articleService.getAllArticles();
    }
 
    @GetMapping("/article-management/article/{id}")
    public Article findArticleById(@PathVariable("id") Long id) {
        return articleService.findById(id);
    }
    
    @PostMapping("/article-management/article")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createArticle(@RequestBody Article resource) {
        Preconditions.checkNotNull(resource);
        return articleService.create(resource);
    }
 
    @PutMapping("/article-management/article/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateArticle(@PathVariable( "id" ) Long id, 
	             @RequestBody Article resource) {
    	Preconditions.checkNotNull(resource);
    	Preconditions.checkNotNull(articleService.findById(resource.getId()));
        articleService.update(resource);
    }
 
    @DeleteMapping("/article-management/article/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteById(id);
    }

}
