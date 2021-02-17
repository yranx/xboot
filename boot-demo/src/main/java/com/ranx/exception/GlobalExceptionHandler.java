package com.ranx.exception;

import com.ranx.utils.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ranx
 * @create 2018-04-10 23:17
 **/
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String ERROR_VIEW = "error";

//    @ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest request,
//                               HttpServletResponse response, Exception e) throws Exception {
//        e.printStackTrace();
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);  //放入错误信息
//        mav.addObject("url", request.getRequestURL()); //放入错误地址
//        mav.setViewName(ERROR_VIEW); //放入错误页面
//        return mav;
//    }

    /**
     * 异常处理，判断是web请求还是ajax请求，并进行处理
     * @param request
     * @param response
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request,
                               HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();

        if(isAjax(request)) {
            return JSONResult.errorException(e.getMessage()); //返回前台可做页面美化显示错误信息
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception", e);
            modelAndView.addObject("url", request.getRequestURL());
            modelAndView.setViewName(ERROR_VIEW);
            return modelAndView;
        }
    }

    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                    && "XMLHttpRequest".equals( httpRequest.getHeader("X-Requested-With").toString()));
    }
}
