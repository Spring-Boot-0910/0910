package com.newer.automobile.controller;

import com.newer.automobile.security.domain.JwtAuthenticationResponse;
import com.newer.automobile.security.domain.JwtAuthenticationResquest;
import com.newer.automobile.service.UserService;
import com.newer.automobile.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
public class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder encoder;
    @RequestMapping(value = "${jwt.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationResquest authenticationRequest) throws AuthenticationException {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(),
                authenticationRequest.getPassword()
        );
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(upToken);
        //Security的上下文中设置认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        //根据userDetail的对象信息生成token令牌
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }
    @PostMapping("/regUser")
    public int regUser(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("pwd") String pwd){
        System.out.println("CCC"+name+"---"+email+"---"+pwd);
        String password = encoder.encode(pwd);
        return userService.regUser(name,email,password);
    }

}
