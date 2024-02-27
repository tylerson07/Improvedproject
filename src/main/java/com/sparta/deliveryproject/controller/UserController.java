package com.sparta.deliveryproject.controller;


import com.sparta.deliveryproject.dto.LoginRequestDto;
import com.sparta.deliveryproject.dto.SignupRequestDto;
import com.sparta.deliveryproject.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/signup")
    public String signup(@RequestBody SignupRequestDto requestdto) {

        userService.signup(requestdto);
        return "회원가입 완료";

    }

    @PostMapping("/user/login")
    public String login(@RequestBody LoginRequestDto requestDto, HttpServletResponse res) {
        try {
            userService.login(requestDto, res);
        } catch (Exception e) {
            return "로그인 실패";
        }

        return "로그인 완료";

    }

    @Secured("ENTRE")
    @GetMapping(path = "/entre")
    public String Hello() {
        return "hello";
    }


}
