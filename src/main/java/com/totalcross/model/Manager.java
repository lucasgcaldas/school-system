package com.totalcross.model;

import java.util.Random;

/**
 * Class responsible for instantiate
 * a Manager
 * @author Lucas Gomes
 */
public class Manager {

    private String name;
    private String code;

    public Manager(String name) {
        this.name = name;
        this.code = generateCode();
    }

    public String getName() {
        return name;
    }

    /**
     * method responsible for generate
     * a unique registration code.
     * 4 numbers and 1 letter, ex: 1234A.
     */
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


    @Override
    public String toString() {
        return "Manager name = " + name + " , code = " + code;
    }
}
