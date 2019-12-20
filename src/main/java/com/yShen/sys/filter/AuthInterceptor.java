package com.yShen.sys.filter;


import com.yShen.sys.model.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String methodName = handlerMethod.getMethod().getName();

        String contextPath = request.getContextPath();
        String url = request.getServletPath().toString();
        StringBuffer realUrl = request.getRequestURL();
        System.out.println("-------------");
        System.out.println(contextPath);
        System.out.println(url);
        System.out.println(realUrl);
        System.out.println("-------------");


            if (!"login".equals(methodName)&&!"getCode".equals(methodName)&&!"toLogin".equals(methodName)){
            /*未完成*/
            HttpSession session = request.getSession(true);
            User loginUser = (User) session.getAttribute("user");
            if (loginUser == null) {
                response.sendRedirect(request.getContextPath()+"/");
                request.setAttribute("","页面不存在");
            }
        }





        return super.preHandle(request, response, handler);
    }

    //
//    String contextPath=request.getContextPath();
//    String  url=request.getServletPath().toString();
//    StringBuffer realUrl = request.getRequestURL();
//        System.out.println("-------------");
//        System.out.println(contextPath);
//        System.out.println(url);
//        System.out.println(realUrl);
//        System.out.println("-------------");


//    if (!"login".equals(methodName)&&!"getCode".equals(methodName)&&!"toLogin".equals(methodName)){
//            /*未完成*/
//            HttpSession session = request.getSession(true);
//            User loginUser = (User) session.getAttribute("user");
//            if (loginUser == null) {
//                response.sendRedirect(request.getContextPath()+"/");
//                request.setAttribute("","页面不存在");
//            }
//        }


}
