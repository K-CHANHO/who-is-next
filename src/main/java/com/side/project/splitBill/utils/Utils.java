package com.side.project.splitBill.utils;

import java.util.Random;

public class Utils {

    public static int createAuthenticationNumber() {
        Random random = new Random();
        return random.nextInt(100000, 1000000);
    }

}
