package com.ian.sblog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ian.sblog.util.PageHandler;
import com.ian.sblog.util.PageModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ian.sblog.domain.Article;
import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;

@Controller
@RequestMapping("/{username}/article")
public class ArticleController extends BaseController{

	private List<Article> articles;
	
	@GetMapping
	public String showArticles(@PathVariable String username, Model model, HttpSession httpSession, Integer page) {
		
		Map<String, Object> params = new HashMap<>();
		Article article = new Article();
		// get user from session
		User user = (User)httpSession.getAttribute(SBlogConstants.USER_SESSION);
		article.setCreateBy(user);
		article.setStatus("publish");
		params.put("article", article);

		Integer totalRecords = arts.getArticleNumber(params);
		PageModel pageModel = PageHandler.setPageParameters(totalRecords, params, page);
		model.addAttribute("pageModel", pageModel);

		articles = arts.getArticles(params);
		
		model.addAttribute("articles", articles);
		model.addAttribute("username", username);
		
		return "article/index";
	}
	
	@GetMapping("/{articleId}")
	public String showArticle(@PathVariable Integer articleId, Model model, HttpSession httpSession) {
		
		Article article = arts.getArticleById(articleId);
		if (article != null) {
			model.addAttribute("article", article);
			// set visit count
			article.setVisitCount((article.getVisitCount() == null ? 0 : article.getVisitCount()) + 1);
			arts.updateArticle(article);
		}
		return "article/detail";
	}
}
