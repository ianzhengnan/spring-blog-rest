package com.ian.sblog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ian.sblog.util.PageHandler;
import com.ian.sblog.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ian.sblog.domain.Article;
import com.ian.sblog.domain.Category;
import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;
import com.ian.sblog.validator.ArticleValidator;

@Controller
public class ArticleAdminController extends BaseController {

    @Autowired
    @Qualifier("articleValidator") // what is useful?
    private ArticleValidator articleValidator;

    private List<Article> articles;

    @GetMapping("/postlist")
    public String showPostList(Model model, HttpSession httpSession, String status, Integer page) {
        Map<String, Object> params = new HashMap<>();
        Article article = new Article();
        // get user from session
        User user = (User) httpSession.getAttribute(SBlogConstants.USER_SESSION);
        article.setCreateBy(user);
        if (status != null && status.equals("draft")) {
            article.setStatus(status);
        } else {
            article.setStatus("publish");
        }
        params.put("article", article);

        Integer totalRecords = arts.getArticleNumber(params);
        PageModel pageModel = PageHandler.setPageParameters(totalRecords, params, page);
        model.addAttribute("pageModel", pageModel);

        articles = arts.getArticles(params);
        model.addAttribute("articles", articles);
        model.addAttribute("status", status);
        return "article/postlist";
    }

    @GetMapping("/postedit")
    public String showPostEdit(Model model, @ModelAttribute Article article, HttpSession httpSession, Integer id) {
        User user = (User) httpSession.getAttribute(SBlogConstants.USER_SESSION);
        List<Category> categories = cats.getCategoriesByUser(user.getId());
        model.addAttribute("categories", categories);
        if (id != null && id != 0) {
            article = arts.getArticleById(id);
            model.addAttribute("article", article);
        }
        return "article/posteditadd";
    }

    @PostMapping("/postedit")
    public ModelAndView postArticle(String isPub, @ModelAttribute Article article,
                                    HttpSession httpSession, Errors errors, Model model) {

        User user = (User) httpSession.getAttribute(SBlogConstants.USER_SESSION);
        ModelAndView mv = new ModelAndView();
        List<Category> categories = cats.getCategoriesByUser(user.getId());
        mv.addObject("categories", categories);

        articleValidator.validate(article, errors);

        if (errors.hasErrors()) {
            mv.setViewName("article/posteditadd");
            return mv;
        }

        if (article.getId() == null) {
            article.setCreateBy(user);
            article.setCreateAt(new Date());
            arts.createArticle(article);
        }

        if (isPub != null && isPub.equals("1")) {
            article.setStatus("publish");
            mv.setViewName("redirect:/" + user.getUsername() + "/article/" + article.getId());
        } else {
            article.setStatus("draft");
            mv.setViewName("article/posteditadd");
        }
        article.setLastModifyAt(new Date());
        arts.updateArticle(article);
        return mv;
    }

    @GetMapping("/del")
    public String deleteArticle(Integer id, HttpSession httpSession) {
        if (id != null && id != 0) {
            arts.removeArticle(id);
        }
        User user = (User) httpSession.getAttribute(SBlogConstants.USER_SESSION);
        return "redirect:/" + user.getUsername() + "/article";
    }

    @GetMapping("/top")
    public String topArticle(Integer id, HttpSession httpSession) {
        if (id != null && id != 0) {
            setTop(id, "set");
        }
        User user = (User) httpSession.getAttribute(SBlogConstants.USER_SESSION);
        return "redirect:/postlist";
    }

    @GetMapping("/untop")
    public String unTopArticle(Integer id, HttpSession httpSession) {
        if (id != null && id != 0) {
            setTop(id, "unset");
        }
        User user = (User) httpSession.getAttribute(SBlogConstants.USER_SESSION);
        return "redirect:/postlist";
    }

    private void setTop(Integer id, String opt) {
        Article article = new Article();
        article.setId(id);
        if (opt == "set") {
            article.setTop("1");
        } else {
            article.setTop("");
        }
        article.setLastModifyAt(new Date());
        arts.updateArticle(article);
    }



}
