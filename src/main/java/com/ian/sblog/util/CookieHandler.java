package com.ian.sblog.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHandler {

    public static Cookie getCookie(HttpServletRequest request, String name){

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie :
                cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }

    public static boolean delCookie(HttpServletRequest request, HttpServletResponse response, String name){

        Cookie cookie = getCookie(request, name);
        if (cookie != null){
            cookie.setValue(null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            return true;
        }
        return false;
    }

    public static void addCookie(HttpServletResponse response, String name, String value){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
    }

    public static void updateCookie(HttpServletRequest request, HttpServletResponse response,
                                    String name, String value){
        Cookie cookie = getCookie(request, name);
        if (cookie != null){
            cookie.setValue(value);
            cookie.setMaxAge(30 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }
}
