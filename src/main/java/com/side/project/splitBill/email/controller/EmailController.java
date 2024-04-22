package com.side.project.splitBill.email.controller;

import com.side.project.splitBill.email.dto.EmailAthenticationDTO;
import com.side.project.splitBill.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/test/mailsend")
    public ResponseEntity mailTest(EmailAthenticationDTO dto) {

        boolean c = emailService.emailAuthenticationSendV1(dto);

        return new ResponseEntity(c, HttpStatus.OK);
    }
}
