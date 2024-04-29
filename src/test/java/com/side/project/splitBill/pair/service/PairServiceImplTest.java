package com.side.project.splitBill.pair.service;

import com.side.project.splitBill.pair.dto.PairDTO;
import com.side.project.splitBill.pair.entity.PairEntity;
import com.side.project.splitBill.pair.repository.PairRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


@Slf4j
@SpringBootTest
class PairServiceImplTest {

    @Autowired
    private PairService pairService;
    @Autowired
    private PairRepository pairRepository;

    @Test
    void makePairCode() {
        log.info("testCode = {}", pairService.makePairCode());
    }

    @Test
    void saveSender() {


        PairDTO dto = new PairDTO();
        assertThatThrownBy (() -> pairService.saveSender(dto))
                .isInstanceOf(RuntimeException.class);

        dto.setPairCode(" ");
        assertThatThrownBy(() -> pairService.saveSender(dto))
                .isInstanceOf(RuntimeException.class);

        dto.setPairCode("ABCDEFGH");
        assertThatThrownBy(() -> pairService.saveSender(dto))
                .isInstanceOf(RuntimeException.class);

        dto.setCodeSender(" ");
        assertThatThrownBy(() -> pairService.saveSender(dto))
                .isInstanceOf(RuntimeException.class);

        dto.setCodeSender("test@test.com");
        pairService.saveSender(dto);
        Optional<PairEntity> entity = pairRepository.findById(dto.getPairCode());
        PairEntity entity1 = entity.orElse(new PairEntity());
        assertThat(entity1.getPairCode()).isEqualTo(dto.getPairCode());
        assertThat(entity1.getCodeSender()).isEqualTo(dto.getCodeSender());

    }
}