package com.side.project.splitBill.email.service;

import com.side.project.splitBill.email.dto.EmailAthenticationDTO;

public interface EmailService {

    boolean emailAuthenticationSendV1(EmailAthenticationDTO dto);
    boolean emailAuthenticationSendV2(EmailAthenticationDTO dto);

    boolean emailAuthentication(EmailAthenticationDTO dto);
}
