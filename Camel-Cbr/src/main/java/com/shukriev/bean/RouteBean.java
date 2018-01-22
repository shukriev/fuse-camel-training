package com.shukriev.bean;

import org.apache.camel.Exchange;

/**
 * Created by Shukri Shukriev on 16/01/18.
 */
public class RouteBean {

    public void handle(Exchange exchange) {
        System.out.println("RouteBean.Class");
    }
}
