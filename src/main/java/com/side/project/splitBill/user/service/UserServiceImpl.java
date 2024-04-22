package com.side.project.splitBill.user.service;

import com.side.project.splitBill.common.exception.UserAlreadyExistException;
import com.side.project.splitBill.user.dto.UserDTO;
import com.side.project.splitBill.user.entity.UserEntity;
import com.side.project.splitBill.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO userRegister(UserDTO dto) {

        boolean emailValid = userRepository.existsByEmail(dto.getEmail());
        if(emailValid) throw new UserAlreadyExistException("해당 이메일이 이미 사용 중 입니다.");

        UserEntity saved = userRepository.save(UserDTO.toEntity(dto));
        return UserDTO.toDTO(saved);
    }

}
