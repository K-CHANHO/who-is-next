package com.side.project.splitBill.user.repository;

import com.side.project.splitBill.user.dto.UserDTO;
import com.side.project.splitBill.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String mail);
}
