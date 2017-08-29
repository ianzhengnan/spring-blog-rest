package com.ian.sblog.util;

import java.util.Map;

public class PageHandler {

    public static PageModel setPageParameters(Integer totalRecords, Map<String, Object> params, Integer page){

        Integer totalPage = totalRecords / SBlogConstants.PAGE_DEFAULT_SIZE == 0 ? 1 :
                totalRecords / SBlogConstants.PAGE_DEFAULT_SIZE;
        PageModel pageModel = new PageModel(SBlogConstants.PAGE_DEFAULT_SIZE, page, totalPage, totalRecords);
        params.put("pageModel", pageModel);
        return pageModel;
    }
}
