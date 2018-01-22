package com.shukriev.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 15/01/18.
 */
public class SplitterRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:splitterRouteBuilder")
                .log("File Split Begin")
                .split().tokenizeXML("order", "orders")
                .setHeader("orderId", method("orderIdSupport", "getOrderId"))
                .setHeader("region", method("regionSupport", "getRegion"))
                .beanRef("debugSupport", "handle")
                .log("File Split Done")
                .to("direct:recipientRouteBuilder");

    }
}
