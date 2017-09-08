package com.ian.sblog.controller;

import com.ian.sblog.domain.Article;
import com.ian.sblog.domain.Comment;
import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;
import com.ian.sblog.util.messsage.Message;
import com.ian.sblog.util.messsage.MsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/{username}/article/{articleId}")
public class CommentController extends BaseController {

    @Autowired
    private Message msg;

    @GetMapping("/comments")
    public List<Comment> showComments(@PathVariable Integer articleId, @PathVariable String username){
        Comment comment = new Comment();
        Article article = arts.getArticleById(articleId);
        comment.setArticle(article);
        Map<String, Object> params = new HashMap<>();
        params.put("comment", comment);
        List<Comment> comments = cs.getComments(params);
        return comments;
    }

    @PostMapping("/comments")
    public Message createComment(HttpSession httpSession, @ModelAttribute Comment comment,
                                 @PathVariable Integer articleId){

        // to-do: validation check

        Article article = arts.getArticleById(articleId);
        article.setCommentCount(article.getCommentCount() + 1);
        comment.setArticle(article);
        comment.setCreateAt(new Date());
        comment.setLastModifyAt(new Date());
        comment.setCreateBy((User)httpSession.getAttribute(SBlogConstants.USER_SESSION));

        // update article and add comment
        arts.updateArticle(article);
        cs.createComment(comment);

        msg.setType(MsgType.success);
        msg.setMsg("添加评论成功！");
        return msg;
    }
}
