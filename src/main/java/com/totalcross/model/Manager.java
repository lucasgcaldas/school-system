package com.totalcross.model;

import java.util.Random;

public class Manager {

    private String name;
    private String code;

    public Manager(String name) {
        this.name = name;
        this.code = generateCode();
    }

    private String generateCode() {
        Random random = new Random();
        String charNumber = "0123456789";
        String charAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] codeNumber = new char[4];
        for (int i = 0; i < 4; i++) {
            codeNumber[i] = charNumber.charAt(random.nextInt(charNumber.length()));
        }

        char[] codeAlpha = new char[1];
        codeAlpha[0] = charAlpha.charAt(random.nextInt(charAlpha.length()));

        return new String(codeNumber) + new String(codeAlpha);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Manager name = " + name + " , code = " + code;
    }
}
