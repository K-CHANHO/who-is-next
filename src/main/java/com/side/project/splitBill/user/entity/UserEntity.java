package com.side.project.splitBill.user.entity;

import jakarta.persistence.*;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;
import org.apache.naming.factory.SendMailFactory;
import org.hibernate.annotations.*;

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
