package com.side.project.splitBill.user.controller;

import com.side.project.splitBill.email.dto.EmailAthenticationDTO;
import com.side.project.splitBill.email.service.EmailService;
import com.side.project.splitBill.user.dto.UserDTO;
import com.side.project.splitBill.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final EmailService emailService;

    @PostMapping("/v1/regist")
    public ResponseEntity userRegist(UserDTO userDTO) {

        EmailAthenticationDTO dto = new EmailAthenticationDTO(userDTO.getEmail(), null);
        emailService.emailAuthenticationSendV1(dto);
        userService.userRegister(userDTO);

        return new ResponseEntity("인증코드를 발송하였습니다.", HttpStatus.OK);
    }




}
