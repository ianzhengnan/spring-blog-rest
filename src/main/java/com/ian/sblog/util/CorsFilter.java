package com.ian.sblog.util;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CorsFilter implements Filter{

    private String allowOrigin;
    private String allowMethods;
    private String allowCredentials;
    private String allowHeaders;
    private String exposeHeaders;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        allowOrigin = filterConfig.getInitParameter("allowOrigin");
        allowMethods = filterConfig.getInitParameter("allowMethods");
        allowCredentials = filterConfig.getInitParameter("allowCredentials");
        allowHeaders = filterConfig.getInitParameter("allowHeaders");
        exposeHeaders = filterConfig.getInitParameter("exposeHeaders");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (StringUtils.isNotEmpty(allowOrigin)){
            List<String> allowOriginList = Arrays.asList(allowOrigin.split(","));
            if (CollectionUtils.isNotEmpty(allowOriginList)) {
                String currectOrigin = httpServletRequest.getHeader("Origin");
                if(allowOriginList.contains(currectOrigin)){
                    httpServletResponse.setHeader("Access-Control-Allow-Origin", currectOrigin);
                }
            }
        }
        if (StringUtils.isNotEmpty(allowMethods)){
            httpServletResponse.setHeader("Access-Control-Allow-Methods", allowMethods);
        }
        if (StringUtils.isNotEmpty(allowCredentials)){
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", allowCredentials);
        }
        if (StringUtils.isNotEmpty(allowHeaders)){
            httpServletResponse.setHeader("Access-Control-Allow-Headers", allowHeaders);
        }
        if (StringUtils.isNotEmpty(exposeHeaders)){
            httpServletResponse.setHeader("Access-Control-Expose-Headers", exposeHeaders);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
