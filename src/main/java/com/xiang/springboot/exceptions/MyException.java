package com.xiang.springboot.exceptions;

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
 * @Date Created in 2019年03月04日 11:37
 * @since 1.0
 */
public class MyException extends RuntimeException {

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
