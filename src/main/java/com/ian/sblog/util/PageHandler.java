package com.ian.sblog.util;

public class PageHandler {

    public static PageModel setPageParameters(Integer totalRecords){

        Integer totalPage = ( totalRecords + SBlogConstants.PAGE_DEFAULT_SIZE - 1 ) / SBlogConstants.PAGE_DEFAULT_SIZE;
        PageModel pageModel = new PageModel(SBlogConstants.PAGE_DEFAULT_SIZE, null, totalPage, totalRecords);
        return pageModel;
    }

}
