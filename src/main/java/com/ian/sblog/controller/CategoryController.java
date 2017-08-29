package com.ian.sblog.controller;

import com.ian.sblog.domain.Category;
import com.ian.sblog.domain.Message;
import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {

    private List<Category> categories;

    @GetMapping
    public String showAllCategories(HttpSession httpSession, Model model){
        User user = (User)httpSession.getAttribute(SBlogConstants.USER_SESSION);
        categories = cats.getCategoriesByUser(user.getId());
        model.addAttribute("categories", categories);
        return "category/showcategories";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage(Model model, @PathVariable String id, @ModelAttribute Category category){
        if (id != null){
            return "category/showcategories";
        }
        category = cats.getCategoryById(id);
        model.addAttribute("category", category);
        return "category/editcategory";
    }

    @PostMapping("/new")
    @ResponseBody
    public Message addCategory(Category category, HttpSession httpSession){
        Message msg = new Message();
        if (category == null){
            msg.setErr("类别不能为空");
            return msg;
        }
        category.setCreateAt(new Date());
        category.setCreateBy((User)httpSession.getAttribute(SBlogConstants.USER_SESSION));
        cats.createCategory(category);
        msg.setMsg("添加成功！");
        return msg;
    }

    @PostMapping("/edit")
    @ResponseBody
    public String editCategory(Category category){
        if (category != null) {
            cats.updateCategory(category);
        }
        return "redirect:/category";
//        return new Message("编辑成功！", "");
    }

    @PostMapping("/del/{id}")
    @ResponseBody
    public Message deleteCategory(@PathVariable Integer id){
        if (id != null){
            cats.deleteCategory(id);
        }
        return new Message("删除成功！", "");
    }

}
