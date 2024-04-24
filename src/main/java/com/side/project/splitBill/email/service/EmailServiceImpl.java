package com.side.project.splitBill.email.service;

import com.side.project.splitBill.common.exception.CustomEmailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender sender;

    /**
     * 이메일 인증을 위한 메일 발송
     * @param email
     */
    @Override
    public void sendAuthenticationEmail(String email) {
        try {

            MimeMessage mimeMessage = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

            helper.setFrom("cksgh1565@naver.com");
            helper.setTo(email);
            helper.setSubject("[SplitBill] 회원가입 이메일 인증");

            String content = "<a href=\"http://localhost:8080/user/regist/auth/"
                    + email
                    + "\" target=\"_blank\">이메일 인증하기</a>";

            mimeMessage.setText(content, "utf-8", "html");
            sender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new CustomEmailException(e.getMessage());
        }
    }
}
