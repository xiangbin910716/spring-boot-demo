package com.xiang.springboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p> @see https://blog.csdn.net/xcc_2269861428/article/details/80429781 </p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author xiangb
 * @version 1.0
 * @Date Created in 2019年02月28日 11:44
 * @since 1.0
 */
//@RestController
@Controller
public class HelloController {

    @RequestMapping( value = "/hello", method = RequestMethod.GET )
    public String helloWorld(){
        System.out.println("go to index jsp");
        return "index";
    }

    @RequestMapping(value="/home")
    public ModelAndView goHome(){
        ModelAndView mode = new ModelAndView();
        mode.addObject("name", "zhangsan");
        mode.setViewName("index");
        return mode;
    }
}
