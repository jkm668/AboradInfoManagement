package com.ustc.controller;

import com.ustc.entity.ResponseHttpStatus;
import com.ustc.entity.RetCode;
import com.ustc.entity.User;
import com.ustc.queryVo.UserVo;
import com.ustc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin   //允许跨域
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 实现用户注册
     * */
    @PostMapping("/register")
    public ResponseHttpStatus register(@RequestBody User user){
        ResponseHttpStatus responseHttpStatus;
        try{
            if (user != null){
                userService.saveUser(user);
                responseHttpStatus = new ResponseHttpStatus(RetCode.SUCCESS.getCode(),"注册成功");
            }else
                throw new RuntimeException("注册失败！");
        }catch (Exception e){
            e.printStackTrace();
            responseHttpStatus = new ResponseHttpStatus(RetCode.FAIL.getCode(), e.getMessage());
        }
        return responseHttpStatus;
    }

    /**
     * 实现用户登录
     * 先判断是否查询到用户，再判断密码是否正确，以及用户类型是否正确
    * */
    @PostMapping("/login")
    public ResponseHttpStatus login(@RequestBody UserVo userVo){
        ResponseHttpStatus responseHttpStatus;
        User user = userService.findUser(userVo);
        try{
            if (user != null)
                if (user.getPassword().equals(userVo.getPassword()))
                    if (user.getType().equals(userVo.getType()))
                        responseHttpStatus = new ResponseHttpStatus(RetCode.SUCCESS.getCode(), "登录成功",user);
                    else responseHttpStatus = new ResponseHttpStatus(RetCode.FAIL.getCode(), "用户类型错误");
                else responseHttpStatus = new ResponseHttpStatus(RetCode.FAIL.getCode(), "密码输入错误");
            else
                responseHttpStatus = new ResponseHttpStatus(RetCode.FAIL.getCode(), "用户名不存在");
        }catch (Exception e){
            e.printStackTrace();
            responseHttpStatus = new ResponseHttpStatus(RetCode.FALSE.getCode(), e.getMessage());
        }
        return responseHttpStatus;
    }
}
