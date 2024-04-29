package com.side.project.splitBill.pair.service;

import com.side.project.splitBill.pair.dto.PairDTO;
import com.side.project.splitBill.pair.repository.PairRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class PairServiceImpl implements PairService{

    private final PairRepository pairRepository;

    @Override
    public String makePairCode() {

        StringBuilder sb = new StringBuilder();
        Random rd = new Random();

        for(int i=0;i<8;i++){
            if(rd.nextBoolean()){
                sb.append((char)(rd.nextInt(26)+65));
            } else {
                sb.append(rd.nextInt(10));
            }

        }

        String pairCode = sb.toString();
        if(pairRepository.existsById(pairCode)){
            return makePairCode();
        }

        return sb.toString();

    }

    @Override
    public boolean validCheck(String pairCode) {
        return false;
    }

    @Override
    public String connectPair(PairDTO dto) {
        return null;
    }
}
