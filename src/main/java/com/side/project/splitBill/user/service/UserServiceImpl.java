package com.side.project.splitBill.user.service;

import com.side.project.splitBill.common.exception.NeedAuthenticationException;
import com.side.project.splitBill.common.exception.UserAlreadyExistException;
import com.side.project.splitBill.email.service.EmailService;
import com.side.project.splitBill.user.dto.UserDTO;
import com.side.project.splitBill.user.entity.UserEntity;
import com.side.project.splitBill.user.repository.UserRepository;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    /**
     * 회원가입
     * @param dto
     */
    @Override
    public void userRegister(UserDTO dto) {

        // 이메일 중복체크
        boolean emailValid = userRepository.existsById(dto.getEmail());
        if(emailValid) throw new UserAlreadyExistException("해당 이메일은 이미 사용 중 입니다.");

        // DB에 회원정보 저장 및 메일로 인증링크 보내기
        UserEntity entity = UserDTO.toEntity(dto);
        userRepository.save(entity);
        emailService.sendAuthenticationEmail(dto.getEmail());

    }

    /**
     * 이메일 링크인증
     * @param email
     */
    @Override
    public void emailAuth(String email) {
        userRepository.updateAuth(email);
    }

    /**
     * 로그인
     * 이메일 인증 전일 경우 예외처리
     * @param dto
     */
    @Override
    public boolean userLogin(UserDTO dto) {

        UserEntity userEntity = userRepository.findById(dto.getEmail()).get();

        if("N".equals(userEntity.getIsAuthenticated())){
            throw new NeedAuthenticationException("이메일 인증을 완료해주세요.");
        } else if(userEntity.getPassword() == dto.getPassword()){
            return false;
        }

        return true;

    }
}
