package com.side.project.splitBill.email.service;

import com.side.project.splitBill.email.dto.EmailAthenticationDTO;

public interface EmailService {

    boolean emailAuthenticationSend(EmailAthenticationDTO dto);
}
