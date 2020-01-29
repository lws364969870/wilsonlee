package com.lws.system.controller;

public class Test {

    public static void main(String[] args) {
        try {
            throw new RuntimeException("ggg213");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
