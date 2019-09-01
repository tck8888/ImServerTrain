package com.tck.imservertrain.controller;

import com.tck.imservertrain.pojo.Users;
import com.tck.imservertrain.pojo.vo.UsersVO;
import com.tck.imservertrain.service.UserService;
import com.tck.imservertrain.utils.MD5Utils;
import com.tck.imservertrain.utils.TCKJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/registerOrLogin")
    public TCKJSONResult registerOrLogin(@RequestBody Users users) throws Exception {

        if (StringUtils.isBlank(users.getUsername()) || StringUtils.isBlank(users.getPassword())) {
            return TCKJSONResult.errorMsg("用户名或者密码不能为空...");
        }
        boolean isExist = userService.queryUsernameIsExist(users.getUsername());
        Users userResult = null;
        if (isExist) {
            //登录
            userResult = userService.queryUserForLogin(users.getUsername(),
                    MD5Utils.getMD5Str(users.getPassword()));
            if (userResult == null) {
                return TCKJSONResult.errorMsg("用户名或者密码不正确");
            }
        } else {
            //注册
            users.setNickname(users.getUsername());
            users.setFaceImage("");
            users.setFaceImageBig("");
            users.setPassword(MD5Utils.getMD5Str(users.getPassword()));
            userResult = userService.saveUser(users);
        }
        UsersVO usersVO = new UsersVO();

        BeanUtils.copyProperties(userResult,usersVO);
        return TCKJSONResult.ok(usersVO);
    }
}
