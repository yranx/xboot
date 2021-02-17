package com.ranx.controller.interceptor;

import com.ranx.utils.JSONResult;
import com.ranx.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author ranx
 * @create 2018-05-07 23:36
 **/
public class TwoInterceptor implements HandlerInterceptor {
    final static Logger log = LoggerFactory.getLogger(TwoInterceptor.class);
    /**
     * 请求处理之前进行调用（Controller方法调用之前）
     * @param request
     * @param object
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object object) throws Exception {
        if (true) {
            returnErrorResponse(response, JSONResult.errorMsg("被two拦截..."));
        }
        System.out.println("被Two拦截...");
        return false;
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     * @param request
     * @param response
     * @param object
     * @param mv
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object object, ModelAndView mv) throws Exception{

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet渲染了对应的视图之后执行
     * （主要用于资源清理工作）
     * @param request
     * @param response
     * @param object
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object object, Exception ex) throws Exception {

    }

    public void returnErrorResponse(HttpServletResponse response, JSONResult result)
            throws IOException, UnsupportedOperationException {
        OutputStream out = null;
        try{
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            out = response.getOutputStream();
            out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
        } finally {
            if (out!=null) {
                out.close();
            }
        }
    }
}
