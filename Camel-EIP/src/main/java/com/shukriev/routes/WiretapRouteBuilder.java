package com.shukriev.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 17/01/18.
 */
public class WiretapRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:mainRouteBuilder").to("direct:wiretapRouteBuilder");
        from("direct:wiretapRouteBuilder")
                .log("File WireTap: Done")
                .to("file:///home/estafet/camelOutputFolder/EIP/wiretapOutput");
    }
}
