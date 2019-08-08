package com.xiang.springboot.hello;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
 * @Date Created in 2019年02月28日 14:59
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;

    private String name;

    private String password;

    private List<String> roles;

}
