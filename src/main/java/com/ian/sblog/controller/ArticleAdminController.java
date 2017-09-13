package com.ian.sblog.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ian.sblog.util.messsage.Message;
import com.ian.sblog.util.PageHandler;
import com.ian.sblog.util.PageModel;
import com.ian.sblog.util.messsage.MsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ian.sblog.domain.Article;
import com.ian.sblog.domain.Category;
import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;
import com.ian.sblog.util.validator.ArticleValidator;

@RestController
public class ArticleAdminController extends BaseController {

    @Autowired
    @Qualifier("articleValidator") // what is useful?
    private ArticleValidator articleValidator;

    private List<Article> articles;

    @Autowired
    private Message msg;

    @GetMapping("/postlist")
    public List<Article> showPostList(HttpSession httpSession, String status, Integer page) {
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
        PageModel pageModel = PageHandler.setPageParameters(totalRecords, page);
        params.put("pageModel", pageModel);

        articles = arts.getArticles(params);
        return articles;
    }

    @PostMapping("/postedit")
    public Message postArticle(String isPub, @ModelAttribute Article article,
                               HttpSession httpSession, Errors errors) {

        User user = (User) httpSession.getAttribute(SBlogConstants.USER_SESSION);
        ModelAndView mv = new ModelAndView();
        List<Category> categories = cats.getCategoriesByUser(user.getId());
        mv.addObject("categories", categories);

        articleValidator.validate(article, errors);

        if (errors.hasErrors()) {
            msg.setType(MsgType.error);
            msg.setKey(null);
            msg.setMsg(errors.getAllErrors());
            return msg;
        }

        if (article.getId() == null) {
            article.setCreateBy(user);
            article.setCreateAt(new Date());
            arts.createArticle(article);
        }

        if (isPub != null && isPub.equals("1")) {
            article.setStatus("publish");
        } else {
            article.setStatus("draft");
        }
        article.setLastModifyAt(new Date());
        arts.updateArticle(article);
        msg.setType(MsgType.success);
        msg.setMsg("添加文章成功！");
        msg.setKey(article);
        return msg;
    }

    @GetMapping("/del")
    public Message deleteArticle(Integer id) {
        if (id != null && id != 0) {
            arts.removeArticle(id);
        }else{
            idIsEmpty();
            return msg;
        }
        msg.setType(MsgType.success);
        msg.setMsg("删除成功！");
        return msg;
    }

    @GetMapping("/top")
    public Message topArticle(Integer id, HttpSession httpSession) {
        if (id != null && id != 0) {
            setTop(id, "set");
        }else{
            idIsEmpty();
            return msg;
        }
        msg.setType(MsgType.success);
        msg.setMsg("置顶成功");
        return msg;
    }

    @GetMapping("/untop")
    public Message unTopArticle(Integer id, HttpSession httpSession) {
        if (id != null && id != 0) {
            setTop(id, "unset");
        }else{
            idIsEmpty();
            return msg;
        }
        msg.setType(MsgType.success);
        msg.setMsg("取消置顶成功");
        return msg;
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

    private void idIsEmpty(){
        msg.setMsg("id不能为空");
        msg.setType(MsgType.error);
    }

}
