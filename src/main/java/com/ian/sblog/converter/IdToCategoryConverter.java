package com.ian.sblog.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.ian.sblog.domain.Category;
import com.ian.sblog.service.CategoryService;

public class IdToCategoryConverter implements Converter<String, Category>{

	@Autowired
	private CategoryService cs;
	
	@Override
	public Category convert(String id) {
		Category category = cs.getCategoryById(id);
		return category;
	}

}
