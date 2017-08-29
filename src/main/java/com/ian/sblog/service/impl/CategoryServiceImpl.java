package com.ian.sblog.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ian.sblog.dao.CategoryDao;
import com.ian.sblog.domain.Category;
import com.ian.sblog.service.CategoryService;

@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
@Service
public class CategoryServiceImpl implements CategoryService {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void createCategory(Category category) {
		log.debug("CategoryServiceImpl >> create an category");
		categoryDao.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDao.updateCategory(category);
	}

	@Override
	public void deleteCategory(Integer id) {
		categoryDao.remove(id);
	}

	@Override
	public List<Category> getCategoriesByUser(Integer id) {
		List<Category> categories = categoryDao.getCategoriesByUserId(id);
		for (Category category : categories) {
			getContainArticleNumber(category);
		}
		return categories;
	}

	@Override
	public Category getCategoryById(String id) {
		return categoryDao.getCategoryById(Integer.parseInt(id));
	}

    @Override
    public void getContainArticleNumber(Category category) {
        Integer articleNumber = categoryDao.containArticleNumber(category.getId());
        category.setArticles(articleNumber);
    }

}
