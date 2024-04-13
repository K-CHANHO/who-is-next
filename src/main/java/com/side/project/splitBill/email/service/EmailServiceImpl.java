package com.side.project.splitBill.email.service;

import com.side.project.splitBill.email.dto.EmailAthenticationDTO;
import com.side.project.splitBill.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Log4j2
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender sender;

    @Override
    public boolean emailAuthenticationSend(EmailAthenticationDTO dto) {

        int authenticationNumber = Utils.createAuthenticationNumber();
        dto.setAthenticationNumber(authenticationNumber);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("no-rely@splitBill.com");
        message.setTo(dto.getUserEmail());
        message.setSubject("[SplitBill] 이메일 인증을 완료해주세요");
        message.setText("테스트 인증번호 : " + authenticationNumber);

        try{
            // TODO : db에 인증번호 저장 로직 추가 필요
            sender.send(message);
        } catch (MailException e){
            log.error(e);
            return false;
        }

        return true;
    }
}
