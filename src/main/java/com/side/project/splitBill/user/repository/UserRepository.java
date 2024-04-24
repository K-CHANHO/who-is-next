package com.side.project.splitBill.user.repository;

import com.side.project.splitBill.user.dto.UserDTO;
import com.side.project.splitBill.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String mail);

    @Modifying
    @Query(value = "update UserEntity " +
            "set isAuthenticated = 'Y' " +
            "where email = :email")
    void updateAuth(@Param("email") String email);
}
