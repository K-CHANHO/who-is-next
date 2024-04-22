package com.side.project.splitBill.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "sb_user")
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    public String userId;

    @Column(nullable = false)
    public String email;

    @Column(nullable = false)
    public String password;

    @Column(nullable = false)
    public String name;

}
