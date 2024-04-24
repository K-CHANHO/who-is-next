package com.side.project.splitBill.common.controller;

import com.side.project.splitBill.common.exception.CustomEmailException;
import com.side.project.splitBill.common.exception.UserAlreadyExistException;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler({UserAlreadyExistException.class})
    public ResponseEntity userAlreadyExistException(final UserAlreadyExistException exception) {
        log.error("error : {}", exception);
        return new ResponseEntity("해당 이메일은 이미 사용 중입니다.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MailException.class})
    public ResponseEntity mailException(final MailException exception) {
        log.error("error : {}", exception);
        return new ResponseEntity("이메일 발송에 실패하였습니다.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CustomEmailException.class})
    public ResponseEntity customEmailException(final MessagingException exception) {
        log.error("error : {}", exception);
        return new ResponseEntity("이메일 발송에 실패하였습니다.", HttpStatus.BAD_REQUEST);
    }
}
