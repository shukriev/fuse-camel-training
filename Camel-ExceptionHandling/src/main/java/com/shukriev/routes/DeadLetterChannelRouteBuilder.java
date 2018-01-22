package com.shukriev.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 18/01/18.
 */
public class DeadLetterChannelRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:deadLetterChannel").to("file:///home/estafet/camelOutputFolder/deadLetterChanel");
    }
}
