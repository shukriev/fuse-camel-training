package com.shukriev.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 15/01/18.
 */
public class RecipientRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:recipientRouteBuilder")
                .setHeader("recipients", method("recipientsSupport", "recipientList"))
                .recipientList(header("recipients")).ignoreInvalidEndpoints();
    }
}
