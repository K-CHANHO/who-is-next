package com.side.project.splitBill.pair.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PairEntity {

    @Id
    public String pairCode;

    @Column(nullable = false)
    String codeSender; // 보낸사람

    @Column
    String codeReceiver; // 받는사람

    @Column
    @ColumnDefault("'N'")
    String checkReceiver; // 받는사람 확인용
}
