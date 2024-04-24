package com.side.project.splitBill.email.service;

import com.side.project.splitBill.email.dto.EmailAthenticationDTO;
import jakarta.mail.MessagingException;

public interface EmailService {

    boolean emailAuthenticationSendV1(EmailAthenticationDTO dto);
    boolean emailAuthenticationSendV2(String email);

    boolean emailAuthentication(EmailAthenticationDTO dto);
}
