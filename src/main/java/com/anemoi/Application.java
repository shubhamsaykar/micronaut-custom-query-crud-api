package com.anemoi;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
		System.out.println("connection istablish");

    }
}