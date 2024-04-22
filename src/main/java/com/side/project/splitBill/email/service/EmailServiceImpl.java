package com.side.project.splitBill.email.service;

import com.side.project.splitBill.email.dto.EmailAthenticationDTO;
import com.side.project.splitBill.utils.Utils;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender sender;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Override
    public boolean emailAuthenticationSend(EmailAthenticationDTO dto) {

        Integer authenticationNumber = Utils.createAuthenticationNumber();
        dto.setAthenticationNumber(authenticationNumber);

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("cksgh1565@naver.com");
            message.setTo(dto.getUserEmail());
            message.setSubject("[SplitBill] 이메일 인증을 완료해주세요");
            message.setText("테스트 인증번호 : " + authenticationNumber);

            // 3분 내에 인증하도록 Redis 만료시간 설정.
            valueOperations.set(dto.getUserEmail(), authenticationNumber.toString(), 3, TimeUnit.MINUTES);

            sender.send(message);
        } catch (MailException e){
            log.error(e.getMessage(), e);
            return false;
        }

        return true;
    }

    @Override
    public boolean emailAuthentication(EmailAthenticationDTO dto) {
        return dto.getAthenticationNumber().equals(valueOperations.get(dto.getUserEmail()));
    }
}
