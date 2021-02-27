package com.example.keanchin.domain.user;

import com.example.keanchin.domain.user.object.UserDto;
import com.example.keanchin.domain.user.object.req.AddUserReq;
import com.example.keanchin.domain.user.object.req.LoginReq;
import com.example.keanchin.domain.user.object.req.UpdatePasswordReq;
import com.example.keanchin.domain.user.object.resp.UserReqResp;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Register User")
    @PostMapping("/register")
    public UserReqResp register(
            @RequestBody AddUserReq userReq
    )throws Exception{
        return userService.registerUser(userReq);
    }

    @ApiOperation(value = "Login User")
    @PostMapping("/login")
    public UserReqResp login(
            @RequestBody LoginReq loginReq
    )throws Exception{
        return userService.loginUser(loginReq);
    }

    @ApiOperation(value = "Logout User")
    @PostMapping("/logout")
    public String logout(
            @RequestParam Long userId
    )throws Exception{
        userService.logoutUser(userId);
        return "Logout Successfully";
    }

    @ApiOperation(value = "Edit Password")
    @PutMapping("/updatePassword")
    public UserReqResp updatePassword(
            @RequestBody UpdatePasswordReq updatePasswordReq
    )throws Exception{
        return userService.updatePassword(updatePasswordReq);
    }
}