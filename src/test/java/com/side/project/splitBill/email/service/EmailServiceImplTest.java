package com.side.project.splitBill.email.service;

import com.side.project.splitBill.email.dto.EmailAthenticationDTO;
import com.side.project.splitBill.redis.RedisConfiguration;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.javamail.JavaMailSender;

import static org.assertj.core.api.Assertions.*;

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
    void emailAuthenticationSend() {

        EmailAthenticationDTO dto = new EmailAthenticationDTO().builder()
                .userEmail("cksgh1565@naver.com")
                .build();

        assertThat(emailService.emailAuthenticationSend(dto)).isTrue();

        String code = valueOperations.get(dto.getUserEmail());
        assertThat(code).isEqualTo(dto.getAthenticationNumber().toString());


    }
}