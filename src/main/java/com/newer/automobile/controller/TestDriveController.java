package com.newer.automobile.controller;

import com.newer.automobile.domain.Param;
import com.newer.automobile.domain.TestDrive;
import com.newer.automobile.security.domain.JwtUser;
import com.newer.automobile.service.TestDriveService;
import com.newer.automobile.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/testDrive")
public class TestDriveController {
    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private TestDriveService testDriveService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/add")
    public int addTestDrive(TestDrive testDrive, HttpServletRequest request){
        String token = request.getHeader(tokenHeader).substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        testDrive.setUid(user.getId());
        return testDriveService.addTestDrive(testDrive);
    }


    @PostMapping("/queryAll")
    public ResponseEntity<?> queryAll(HttpServletRequest request){
        int startIndex = Integer.parseInt(request.getParameter("iDisplayStart"));
        int pageSize = Integer.parseInt(request.getParameter("iDisplayLength"));
        int countTid=testDriveService.countTid();
        List<TestDrive> testDriveList=testDriveService.queryAll(startIndex,pageSize);
        Param parameter=new Param(testDriveList,countTid,countTid);
        return new ResponseEntity<>(parameter,HttpStatus.OK);
    }

}
