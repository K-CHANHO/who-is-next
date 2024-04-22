package com.side.project.splitBill.user.dto;

import com.side.project.splitBill.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    String userId;
    String email;
    String password;
    String name;

    public static UserEntity toEntity(UserDTO dto){
        UserEntity entity = UserEntity.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .name(dto.getName())
                .build();

        return entity;
    }

    public static UserDTO toDTO(UserEntity entity) {
        UserDTO dto = UserDTO.builder()
                .userId(entity.getUserId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .name(entity.getName())
                .build();

        return dto;
    }

}
