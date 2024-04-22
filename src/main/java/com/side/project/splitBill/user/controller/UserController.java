package com.side.project.splitBill.user.controller;

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
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/regist")
    public ResponseEntity userRegist(UserDTO userDTO) {

        UserDTO dto = userService.userRegister(userDTO);

        return new ResponseEntity("인증코드를 발송하였습니다.", HttpStatus.OK);
    }


}
