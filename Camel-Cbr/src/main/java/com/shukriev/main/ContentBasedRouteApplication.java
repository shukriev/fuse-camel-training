package com.shukriev.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Shukri Shukriev  on 15/01/18.
 */
public class ContentBasedRouteApplication {
    public static void main(String... args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("camel-context.xml");

        System.out.println("Camel Context Started");
        ctx.start();

        try {

            System.out.println("Thread Sleep 3k");
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Thread stopped");
        ctx.stop();

    }
}
