package com.side.project.splitBill.user.dto;

import com.side.project.splitBill.user.entity.UserEntity;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    String email;
    String password;
    String name;

    String isAuthenticated;

    String isConnected;
    String pairedEmail;

    public static UserEntity toEntity(UserDTO dto){
        UserEntity entity = UserEntity.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .name(dto.getName())
                .isConnected(dto.getIsConnected())
                .isAuthenticated(dto.getIsAuthenticated())
                .pairedEmail(dto.getPairedEmail())
                .build();

        return entity;
    }

    public static UserDTO toDTO(UserEntity entity) {
        UserDTO dto = UserDTO.builder()
                .email(entity.getEmail())
                .password(entity.getPassword())
                .name(entity.getName())
                .isConnected(entity.getIsConnected())
                .isAuthenticated(entity.getIsAuthenticated())
                .pairedEmail(entity.getPairedEmail())
                .build();

        return dto;
    }

}
