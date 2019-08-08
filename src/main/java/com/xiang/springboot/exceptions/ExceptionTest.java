package com.xiang.springboot.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>Spring MVC 异常统一处理的三种方式</p>
 * <p>https://www.cnblogs.com/junzi2099/p/7840294.html
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author xiangb
 * @version 1.0
 * @Date Created in 2019年03月04日 11:35
 * @since 1.0
 */
@Controller
public class ExceptionTest {
    /**
     * 使用 @ ExceptionHandler 注解
     * 使用该注解有一个不好的地方就是：进行异常处理的方法必须与出错的方法在同一个Controller里面。使用如下：
     * 可以看到，这种方式最大的缺陷就是不能全局控制异常。每个类都要写一遍。
     */
//    @ExceptionHandler(MyException.class)
    public String exception(MyException e) {
        System.out.println("ExceptionHandler" + e.getMessage());
        return "exceptions";
    }


    @RequestMapping( value = "/test", method = RequestMethod.GET )
    public void test() {
        throw new MyException("test");
    }
}
