package com.shukriev.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Shukri Shukriev on 11/01/18.
 */
public class MainApp {
    public static void main(String... args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("camel-context.xml");

        ctx.start();

        System.out.println("Camel context started!");

        try {
            Thread.sleep(5 * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Camel context stopped!");

        ctx.stop();
        ctx.close();
    }
}
