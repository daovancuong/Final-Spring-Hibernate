package org.cuong.interceptor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author CSE
 * @version 1.0 Aug 14, 2016
 */
public class DayOfWeekAcessInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        int dayOfWeek = Calendar.getInstance().get(Calendar.getInstance().DAY_OF_WEEK);
//        if (dayOfWeek == 1) {
//            
//            response.getWriter().write("the website is close on sunday");
//            return false;
//        }
        return true;
    }@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("post-handle intercepter");
        super.postHandle(request, response, handler, modelAndView);
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("complete intercpter");
        super.afterCompletion(request, response, handler, ex);
    }
    
}
