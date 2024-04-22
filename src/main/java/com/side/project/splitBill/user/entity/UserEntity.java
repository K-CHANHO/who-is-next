package com.side.project.splitBill.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.naming.factory.SendMailFactory;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "sb_user", indexes = @Index(name = "idx_user", columnList = "email, password"))
@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    public String userId;

    @Column(nullable = false)
    public String email;

    @Column(nullable = false)
    public String password;

    @Column(nullable = false)
    public String name;

}
