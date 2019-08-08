package com.xiang.springboot.hello;

import org.springframework.stereotype.Component;

/**
 * <p>需实现对用户表的增删改查，此处可采用任意数据库，具体实现自行编写。</p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author xiangb
 * @version 1.0
 * @Date Created in 2019年02月28日 15:02
 * @since 1.0
 */
@Component
public interface IUserRepository {

    /**
     * 通过用户名查找用户
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
