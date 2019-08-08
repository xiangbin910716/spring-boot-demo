package com.xiang.springboot.hello;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
 * @Date Created in 2019年03月01日 10:39
 * @since 1.0
 */
@Service("userRepository")
public class IUserRepositoryImpl implements IUserRepository {

    @Override
    public User findByUserName(String userName) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return new User("1","xiang", bCryptPasswordEncoder.encode("1234"), Arrays.asList("1","2") );
    }
}
