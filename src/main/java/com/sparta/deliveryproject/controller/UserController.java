package com.sparta.deliveryproject.controller;


import com.sparta.deliveryproject.dto.LoginRequestDto;
import com.sparta.deliveryproject.dto.SignupRequestDto;
import com.sparta.deliveryproject.entity.UserRoleEnum;
import com.sparta.deliveryproject.security.UserDetailsServiceImpl;
import com.sparta.deliveryproject.service.JwtUtil;
import com.sparta.deliveryproject.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/signup")
       public String signup(@RequestBody SignupRequestDto requestdto){

            userService.signup(requestdto);
            return "회원가입 완료";

        }


@Secured("ROLE_ENTRE")
    @GetMapping("/user/test")
    public String signups(){


        return "test";

    }





}
