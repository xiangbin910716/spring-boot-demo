package com.xiang.springboot.hello;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
 * @Date Created in 2019年02月28日 15:31
 * @since 1.0
 */
@Component
public class JwtTokenUtil implements Serializable {
    /**
     * 密钥
     */
    private String secret = "aaaaaa";
    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String,Object> claims){
        Date expirationDate = new Date(System.currentTimeMillis()+2592000L*1000);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token){
        Claims claims ;
        try{
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        }catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     * @return
     */
    public String getUsernameFromToken(String token) {

        String userName;
        try {
            Claims claims = getClaimsFromToken(token);
            userName = claims.getSubject();
        } catch (Exception e) {
            userName = null;
        }
        return userName;

    }

    /**
     * 验证令牌是否过期
     * @param token
     * @return
     */
    public Boolean isTokenExpired(String token) {

        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        String refreshToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshToken = generateToken(claims);
        } catch (Exception e) {
            refreshToken = null;
        }
        return refreshToken;

    }

    /**
     * 验证令牌
     * @param token
     * @param userDetails
     * @return
     */
    public Boolean validateToken(String token,UserDetails userDetails){
        JwtUser user = (JwtUser) userDetails;
        String userName = getUsernameFromToken(token);
        return (userName.equals(user.getUsername()) && !isTokenExpired(token));

    }



}
