package com.side.project.splitBill.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.apache.naming.factory.SendMailFactory;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
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
    public String email;

    @Column(nullable = false)
    public String password;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    @ColumnDefault("N")
    public String isConnected;

    @Column(nullable = false)
    @ColumnDefault("N")
    public String isAuthenticated;

    @Column
    public String pairedEmail;

}
