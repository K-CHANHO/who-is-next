package com.side.project.splitBill.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
public class Utils {

    public static int createAuthenticationNumber() {
        Random random = new Random();
        return random.nextInt(100000, 1000000);
    }

}
