package com.shukriev.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 19/01/18.
 */
public class FilterRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        String orderId = header("orderId");

        from("direct:filterRouteBuilder")
            .filter(method("filterSupport", "filter"))
            .log("[filter] Order ${header.orderId} is an order for more than 100 animals")
        .to("file:///home/estafet/camelOutputFolder/EIP/filterOut?fileName=%s.xml" +
                header("orderId"));
    }
}
