package com.tck.imservertrain.controller;

import com.tck.imservertrain.service.UserService;
import com.tck.imservertrain.utils.MyJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:</br>
 * created on: 2019/8/30 9:51</br>
 *
 * @author tck
 * @version 1.0
 */
@RestController
@RequestMapping("u")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public MyJSONResult hello() {
        return MyJSONResult.ok();
    }
}
