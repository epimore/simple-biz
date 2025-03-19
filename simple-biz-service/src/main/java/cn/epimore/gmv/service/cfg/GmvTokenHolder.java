package cn.epimore.gmv.service.cfg;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class GmvTokenHolder {
    private static final ThreadLocal<String> tokenThreadLocal = new ThreadLocal<>();

    public static final String SECRET_KEY = "GMV TOKEN KEY";

    public static void setToken(String token) {
        tokenThreadLocal.set(token);
    }

    public static String getToken() {
        return tokenThreadLocal.get();
    }

    public static void clear() {
        tokenThreadLocal.remove();
    }

    public static String buildToken(String username) {
        String token = Jwts.builder()
                .setSubject(String.valueOf(username)) // 存入 username
                .setIssuedAt(new Date()) // 签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 1小时有效期
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 使用 HMAC-SHA256 加密
                .compact();
        GmvTokenHolder.setToken(token);
        return token;
    }

    public static String getUserNameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public static String getUserName() {
        return getUserNameFromToken(GmvTokenHolder.getToken());
    }

    public static boolean checkToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
