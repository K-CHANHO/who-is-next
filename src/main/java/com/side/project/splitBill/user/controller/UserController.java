package com.side.project.splitBill.user.controller;

import com.side.project.splitBill.email.dto.EmailAthenticationDTO;
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

    @PostMapping("/regist/v1")
    public ResponseEntity userRegistV1(UserDTO userDTO) {

        EmailAthenticationDTO dto = new EmailAthenticationDTO(userDTO.getEmail(), null);
        emailService.emailAuthenticationSendV1(dto);
        userService.userRegister(userDTO);

        return new ResponseEntity("인증코드를 발송하였습니다.", HttpStatus.OK);
    }

    @PostMapping("/regist/v2")
    public ResponseEntity userRegistV2(UserDTO userDTO) {

        emailService.emailAuthenticationSendV2(userDTO.getEmail());

        return new ResponseEntity(null);
    }

    @GetMapping("/regist/auth/{email}")
    public ResponseEntity userEmailAuth(@PathVariable String email){

        return new ResponseEntity("인증에 성공하였습니다.", HttpStatus.OK);
    }




}
