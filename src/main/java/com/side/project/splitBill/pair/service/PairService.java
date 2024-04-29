package com.side.project.splitBill.pair.service;

import com.side.project.splitBill.pair.dto.PairDTO;

public interface PairService {

    String makePairCode(); // 랜덤 연결코드 생성(대문자+숫자 6자리 조합)
    boolean validCheck(String pairCode); // 1. 연결코드가 존재하는지, 2. 리시버의 이메일이 동일한지
    String connectPair(PairDTO dto); // 연결

}
