package com.shukriev.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 18/01/18.
 */
public class MainRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        onException(com.shukriev.exceptions.OrderValidationException.class)
                .handled(true)
                .log("OrderValidationException.class handled")
                .to("file:///home/estafet/camelOutputFolder/exceptionValidated");

        errorHandler(deadLetterChannel("direct:deadLetterChannel")
                .log("Setup deadLetterChannel")
                .maximumRedeliveries(2)
                .useExponentialBackOff()
                .useOriginalMessage()
        );

        from("file:///home/estafet/camelInputFolder")
                .log("Process File")
                    .beanRef("orderService", "validateOrderDate")
                    .beanRef("orderService", "randomlyThrowRuntimeException")
                .to("file:///home/estafet/camelOutputFolder");
    }
}
