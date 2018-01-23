package com.shukriev.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 18/01/18.
 */
public class MainRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {


        from("file:///home/estafet/camelInputFolder")
            .log("Process File")
            .to("activemq:incomingOrders")
            .log("File send to Que");

        from("activemq:incomingOrders")
                .log("Incoming file from Que")
                .choice()
//                .when(xpath("/order/country = 'UK'"))
//                    .to("file:///home/estafet/camelOutputFolder/UK")

                .when(xpath("/order/customer/country = 'US'"))
                    .log(String.format("Sending order %s to the US", header("fileName")))
                    .to("file:///home/estafet/camelOutputFolder/US")

                .when(xpath("/order/customer/country = 'UK'"))
                    .log(String.format("Sending order %s to the UK", header("fileName")))
                    .to("file:///home/estafet/camelOutputFolder/UK")

                .otherwise().to("file:///home/estafet/camelOutputFolder/camelOther")
  ;
    }
}
