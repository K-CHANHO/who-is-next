package com.side.project.splitBill.user.controller;

import com.side.project.splitBill.email.service.EmailService;
import com.side.project.splitBill.user.dto.UserDTO;
import com.side.project.splitBill.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final EmailService emailService;

    @PostMapping("/regist")
    public ResponseEntity userRegistV1(UserDTO userDTO) {

        userService.userRegister(userDTO);

        return new ResponseEntity("메일인증을 완료해주세요.", HttpStatus.OK);
    }

    @GetMapping("/regist/auth/{email}")
    public ResponseEntity userEmailAuth(@PathVariable("email") String email){

        userService.emailAuth(email);
        return new ResponseEntity("인증에 성공하였습니다.", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity userLogin(UserDTO dto) {
        boolean isUser = userService.userLogin(dto);

        return new ResponseEntity(isUser, HttpStatus.OK);
    }




}
