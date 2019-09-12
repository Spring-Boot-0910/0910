package com.newer.automobile.security.config;

import com.newer.automobile.utils.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义过滤器
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    //获取日志对象
    private Logger logger=LoggerFactory.getLogger(getClass());
    @Value("${jwt.header}")
    private String header;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            final String token=request.getHeader(header);
        String username=null;//用户名
        String authToken=null;//截取后的token值
        if (token!=null && token.startsWith(tokenHead)){
                authToken=token.substring(tokenHead.length());
                try {
                //根据令牌token
                username=jwtTokenUtil.getUsernameFromToken(authToken);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
                logger.info("token解析错误，无法解析出用户信息");
            }catch (ExpiredJwtException e){
                e.printStackTrace();
                logger.info("token已过期");
            }
        }
        logger.info("获取到的username的值为："+username);
        //判断用户名不为空，并且用户没有认证
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            //根据用户名获取用户信息
            UserDetails userDetails =userDetailsService.loadUserByUsername(username);
            //判断token是否有效
            if (jwtTokenUtil.validateToken(authToken,userDetails)){
                //封装用户信息以及角色信息到改对象中
                UsernamePasswordAuthenticationToken authentication=new UsernamePasswordAuthenticationToken
                        (userDetails,null,userDetails.getAuthorities());
                //设置该对象的详细信息
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //设置认证信息到security的上下文中
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request,response);//允许请求继续访问
}
}
