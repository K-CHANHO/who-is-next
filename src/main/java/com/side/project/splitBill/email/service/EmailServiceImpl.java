package com.side.project.splitBill.email.service;

import com.side.project.splitBill.email.dto.EmailAthenticationDTO;
import com.side.project.splitBill.utils.Utils;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
    public boolean emailAuthenticationSendV1(EmailAthenticationDTO dto) {

        // 인증번호 생성
        Integer authenticationNumber = Utils.createAuthenticationNumber();
        dto.setAthenticationNumber(authenticationNumber);

        // 이메일 데이터 생성
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("cksgh1565@naver.com");
        message.setTo(dto.getUserEmail());
        message.setSubject("[SplitBill] 이메일 인증을 완료해주세요");
        message.setText("테스트 인증번호 : " + authenticationNumber);

        // 3분 내에 인증하도록 Redis 만료시간 설정.
        valueOperations.set(dto.getUserEmail(), authenticationNumber.toString(), 3, TimeUnit.MINUTES);

        // 이메일 발송
        sender.send(message);

        return true;
    }

    @Override
    public boolean emailAuthenticationSendV2(String email){
        try {

            MimeMessage mimeMessage = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            helper.setFrom("cksgh1565@naver.com");
            helper.setTo(email);
            helper.setSubject("[SplitBill] 회원가입 이메일 인증");

            String content = "<a href=\"localhost:8080/user/regist/auth/"
                + email
                + "\" target=\"_blank\">이메일 인증하기</a>";

            mimeMessage.setText(content, "utf-8", "html");
            sender.send(mimeMessage);

            valueOperations.set(email, "Y", 3, TimeUnit.MINUTES);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public boolean emailAuthentication(EmailAthenticationDTO dto) {
        return dto.getAthenticationNumber().equals(valueOperations.get(dto.getUserEmail()));
    }
}
