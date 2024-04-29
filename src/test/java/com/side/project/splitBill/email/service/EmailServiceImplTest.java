package com.side.project.splitBill.email.service;

import com.side.project.splitBill.redis.RedisConfiguration;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.javamail.JavaMailSender;

import static org.assertj.core.api.Assertions.assertThat;

@Import(RedisConfiguration.class)
@SpringBootTest
class EmailServiceImplTest {

    @Autowired
    private JavaMailSender sender;

    @Autowired
    private EmailServiceImpl emailService;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;


    @Test
    void emailAuthentication() {

        assertThat("163993").isEqualTo(valueOperations.get("cksgh1565@naver.com"));

    }
}