package com.ian.sblog.controller;

import com.ian.sblog.domain.Article;
import com.ian.sblog.domain.Comment;
import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/{username}/article/{articleId}")
public class CommentController extends BaseController {

    @GetMapping("/comments")
    public String showComments(Model model, @PathVariable Integer articleId, @PathVariable String username){

        Comment comment = new Comment();
        Article article = arts.getArticleById(articleId);
        comment.setArticle(article);
        Map<String, Object> params = new HashMap<>();
        params.put("comment", comment);
        List<Comment> comments = cs.getComments(params);
        model.addAttribute("comments", comments);
        model.addAttribute("article", article);
        return "comment/comment";
    }

    @PostMapping("/comments")
    public String createComment(Model model, HttpSession httpSession, @PathVariable Integer articleId, String content){
        Comment comment = new Comment();
        comment.setContent(content);
        Article article = arts.getArticleById(articleId);
        article.setCommentCount(article.getCommentCount() + 1);
        comment.setArticle(article);
        comment.setCreateAt(new Date());
        comment.setLastModifyAt(new Date());
        comment.setCreateBy((User)httpSession.getAttribute(SBlogConstants.USER_SESSION));

        arts.updateArticle(article);
        cs.createComment(comment);

        Map<String, Object> params = new HashMap<>();
        params.put("comment", comment);
        List<Comment> comments = cs.getComments(params);

        model.addAttribute("article", article);
        model.addAttribute("comments", comments);
        return "comment/comment";
    }
}
