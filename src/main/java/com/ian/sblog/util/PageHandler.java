package com.ian.sblog.util;

public class PageHandler {

    public static PageModel setPageParameters(Integer totalRecords, Integer page){

        Integer totalPage = totalRecords / SBlogConstants.PAGE_DEFAULT_SIZE == 0 ? 1 :
                totalRecords / SBlogConstants.PAGE_DEFAULT_SIZE;
        PageModel pageModel = new PageModel(SBlogConstants.PAGE_DEFAULT_SIZE, page, totalPage, totalRecords);
        return pageModel;
    }
}
