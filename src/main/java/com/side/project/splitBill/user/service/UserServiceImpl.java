package com.side.project.splitBill.user.service;

import com.side.project.splitBill.common.exception.UserAlreadyExistException;
import com.side.project.splitBill.email.service.EmailService;
import com.side.project.splitBill.user.dto.UserDTO;
import com.side.project.splitBill.user.entity.UserEntity;
import com.side.project.splitBill.user.repository.UserRepository;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations;

    @Override
    public void userRegister(UserDTO dto) {

        // 이메일 중복체크
        boolean emailValid = userRepository.existsByEmail(dto.getEmail());
        if(emailValid) throw new UserAlreadyExistException("해당 이메일은 이미 사용 중 입니다.");

        // DB에 회원정보 저장 및 메일로 인증링크 보내기
        UserEntity entity = UserDTO.toEntity(dto);
        userRepository.save(entity);
        emailService.sendAuthenticationEmail(dto.getEmail());

    }

    @Override
    public boolean emailAuth(String email) {

        if(valueOperations.get(email).equals("Y")) {
            valueOperations.getAndDelete(email);
            return true;
        }

        return false;
    }
}
