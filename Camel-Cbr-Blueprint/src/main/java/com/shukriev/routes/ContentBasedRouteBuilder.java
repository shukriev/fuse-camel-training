package com.shukriev.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 15/01/18.
 */
public class ContentBasedRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("file:///home/estafet/camelInputFolder")
            .choice()
                .when(xpath("/order/country = 'UK'"))
                    .log(xpath("/order/country = 'UK'").toString())
                        .to("file:///home/estafet/camelOutputFolder/UK")
                .when(xpath("/order/country = 'US'"))
                    .log(xpath("/order/country = 'US'").toString())
                        .to("file:///home/estafet/camelOutputFolder/US")
                .when(xpath("/order/customer/country = 'UK'"))
                    .log(xpath("/order/customer/country = 'UK'").toString())
                        .to("file:///home/estafet/camelOutputFolder/UK")
                .when(xpath("/order/customer/country = 'US'"))
                    .log(xpath("/order/customer/country = 'US'").toString())
                        .to("file:///home/estafet/camelOutputFolder/US")
                .when(xpath("/order/customer/country = 'UK'"))
                    .log(xpath("/order/customer/country = 'UK'").toString())
                        .to("file:///home/estafet/camelOutputFolder/UK")
                .otherwise().to("file:///home/estafet/camelOutputFolder/camelOther");
    }
}
