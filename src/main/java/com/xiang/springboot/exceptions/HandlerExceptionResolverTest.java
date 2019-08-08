package com.xiang.springboot.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>实现 HandlerExceptionResolver 接口</p>
 * <p> 这种方式可以进行全局的异常控制
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author xiangb
 * @version 1.0
 * @Date Created in 2019年03月04日 11:46
 * @since 1.0
 */
@Component
public class HandlerExceptionResolverTest implements HandlerExceptionResolver{


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println("This is exceptions method.....");
        return null;
    }
}
