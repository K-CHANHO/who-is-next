package com.side.project.splitBill.pair.dto;

import com.side.project.splitBill.pair.entity.PairEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PairDTO {

    String pairCode; // 연결코드
    String codeSender; // 보낸사람
    String codeReceiver; // 받는사람
    String checkReceiver; // 받는사람 확인용

    public static PairDTO toDTO(PairEntity entity) {

        PairDTO dto = PairDTO.builder()
                .pairCode(entity.getPairCode())
                .codeSender(entity.getCodeSender())
                .codeReceiver(entity.getCodeReceiver())
                .checkReceiver(entity.getCheckReceiver())
                .build();

        return dto;
    }

    public static PairEntity toEntity(PairDTO dto){

        PairEntity entity = PairEntity.builder()
                .pairCode(dto.getPairCode())
                .codeSender(dto.getCodeSender())
                .codeReceiver(dto.getCodeReceiver())
                .checkReceiver(dto.getCheckReceiver())
                .build();

        return entity;
    }

}
