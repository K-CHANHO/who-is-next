package com.side.project.splitBill.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "sb_user", indexes = @Index(name = "idx_user", columnList = "email, password"))
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
public class UserEntity {

    @Id
    public String email;

    @Column
    public String password;

    @Column
    public String name;

    @Column
    @ColumnDefault("'N'")
    public String isConnected;

    @Column
    @ColumnDefault("'N'")
    public String isAuthenticated;

    @Column
    public String pairedEmail;

}
