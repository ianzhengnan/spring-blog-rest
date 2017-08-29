package com.ian.sblog.validator;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ian.sblog.domain.Article;

@Repository("articleValidator")
public class ArticleValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Article.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "subject", null, "主题不能为空");
		if (errors.hasErrors()) {
			return;
		}
		ValidationUtils.rejectIfEmpty(errors, "content", null, "内容不能为空");
		if (errors.hasErrors()) {
			return;
		}
		Article article = (Article) target;
		if (article.getSubject().length() < 6) {
			errors.rejectValue("subject", null, "主题不能少于6个字符");
		}
	}
}
