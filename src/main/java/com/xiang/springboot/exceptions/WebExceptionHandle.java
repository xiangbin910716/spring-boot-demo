package com.xiang.springboot.exceptions;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author xiangb
 * @version 1.0
 * @Date Created in 2019年03月04日 18:00
 * @since 1.0
 */
@RestController
@ControllerAdvice
public class WebExceptionHandle {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(WebExceptionHandle.class);

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ModelAndView handleException(MyException e){
        System.out.println("========globale exceptions=========");
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }



}
