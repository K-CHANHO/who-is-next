package com.side.project.splitBill.user.service;

import com.side.project.splitBill.user.dto.UserDTO;
import com.side.project.splitBill.user.entity.UserEntity;
import com.side.project.splitBill.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void userRegister() {

        UserDTO dto = UserDTO.builder()
                .email("cksgh1565@naver.com")
                .password("test")
                .name("차노쓰")
                .build();

        userService.userRegister(dto);

    }
}