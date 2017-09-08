package com.ian.sblog.controller;

import com.ian.sblog.domain.Category;
import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;
import com.ian.sblog.util.messsage.Message;
import com.ian.sblog.util.messsage.MsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {

    private List<Category> categories;

    @Autowired
    private Message msg;

    @GetMapping
    public List<Category> showAllCategories(HttpSession httpSession, Model model){
        User user = (User)httpSession.getAttribute(SBlogConstants.USER_SESSION);
        categories = cats.getCategoriesByUser(user.getId());
        model.addAttribute("categories", categories);
        return categories;
    }

    @GetMapping("/edit/{id}")
    public Object showEditPage(@PathVariable String id){
        if (id != null){
            msg.setType(MsgType.error);
            msg.setMsg("id不能为空");
            return msg;
        }
        Category category = cats.getCategoryById(id);
        return category;
    }

    @PostMapping("/new")
    public Message addCategory(Category category, HttpSession httpSession){
        if (category == null){
            msg.setType(MsgType.error);
            msg.setMsg("类别不能为空");
            return msg;
        }
        category.setCreateAt(new Date());
        category.setCreateBy((User)httpSession.getAttribute(SBlogConstants.USER_SESSION));
        cats.createCategory(category);
        msg.setType(MsgType.success);
        msg.setMsg("添加成功！");
        return msg;
    }

    @PostMapping("/edit")
    public Message editCategory(Category category){
        if (category != null) {
            cats.updateCategory(category);
        }
        msg.setType(MsgType.success);
        msg.setMsg("category更新成功");
        return msg;
    }

    @PostMapping("/del/{id}")
    public Message deleteCategory(@PathVariable Integer id){
        if (id != null){
            cats.deleteCategory(id);
        }else{
            msg.setMsg("id不能为空");
            msg.setType(MsgType.error);
            return msg;
        }
        msg.setMsg("category删除成功");
        msg.setType(MsgType.success);
        return msg;
    }

}
