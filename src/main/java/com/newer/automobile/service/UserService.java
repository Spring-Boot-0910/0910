package com.newer.automobile.service;

import com.newer.automobile.domain.Email;
import com.newer.automobile.domain.Users;
import com.newer.automobile.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private JavaMailSender javaMailSender;

    public int regUser(String name,String email,String pwd){
        return usersMapper.regUser(name,email,pwd);
    }

    public Users queryLogin(String email,String pwd){
        return usersMapper.queryLogin(email,pwd);
    }

    public Users queryPwd(String uemail){
        return usersMapper.queryPwd(uemail);
    }

    public void email(Email email){
        SimpleMailMessage ssm = new SimpleMailMessage();
        ssm.setFrom(email.getSender()); //发件人
        ssm.setTo(email.getShouJian());    //收件人
        ssm.setSubject("买车验证码");
        ssm.setText(email.getMsg());
        javaMailSender.send(ssm);
    }
}
