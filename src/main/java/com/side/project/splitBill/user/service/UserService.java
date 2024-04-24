package com.side.project.splitBill.user.service;

import com.side.project.splitBill.user.dto.UserDTO;

public interface UserService {

    void userRegister(UserDTO dto);

    void emailAuth(String email);
}
