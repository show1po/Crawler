package com.tn.web.ctls;

import com.tn.web.po.User;
import com.tn.web.repository.UserRepository;
import com.tn.web.requests.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Show on 2016/10/24.
 */
@RestController
@RequestMapping(path = "/User")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PutMapping(path = "/Add")
    public String add(@RequestBody UserReq userReq){
        User user=userRepository.findByAccount(userReq.getAccount());
        if(user==null){
            User newUser=new User();
            newUser.setAccount(userReq.getAccount());
            newUser.setCreateDate(new Date());
            newUser.setPassword(userReq.getPassword());
            userRepository.save(newUser);
            return "{msg:success}";
        }else{
            return "{msg:failure,user exists.}";
        }
    }
}
