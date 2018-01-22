package com.shukriev.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 17/01/18.
 */
public class MainRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:///home/estafet/camelInputFolder")
                .log("Received file: ${header[CamelFileName]}")
//                .idempotentConsumer(header("CamelFileName"), new MemoryIdempotentRepository()).skipDuplicate(true)
                .wireTap("direct:wiretapRouteBuilder")
                .log("Process File")
                .to("direct:splitterRouteBuilder");
    }
}
