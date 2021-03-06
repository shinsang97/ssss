
package com.aparta.homework3.controller;


import com.aparta.homework3.dto.SignupRequestDto;
import com.aparta.homework3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class IndexController {

    private final UserService userService;

    @Autowired
    public IndexController(UserService userService) {

        this.userService = userService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String userLogin() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }
    //게시글 페이지로 이동
    @GetMapping("/posting/{id}")
    public String posting() {
        return "posting";
    }
}