package me.ixk.exception.handler;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 全局异常处理
public class GlobalNotFoundException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.getWriter().write(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView();
    }
}
