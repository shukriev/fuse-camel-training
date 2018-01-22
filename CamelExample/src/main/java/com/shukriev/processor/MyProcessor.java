package com.shukriev.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by Shukri Shukriev on 11/01/18.
 */
public class MyProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        System.out.println("Hello");
    }
}
