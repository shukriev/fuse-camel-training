package com.shukriev.routes;

import com.shukriev.constants.Routes;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 18/01/18.
 */
public class MainRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        //ActiveMq -> Que Example
        from(Routes.FILE_INPUT_PATH)
            .log("Process File")
        .to(Routes.ACTIVEMQ_QUE_PATH)
            .log("File send to Que");

        //ActiveMq -> Topic example
        from(Routes.FILE_INPUT_PATH_1)
            .log("Incoming file from TOPIC")
            .choice()
            .when(xpath(Routes.US_LABEL))
                .log(String.format("Sending order %s to US topic", header("fileName")))
                .to(Routes.ACTIVEMQ_US_PATH)
            .when(xpath(Routes.UK_LABEL))
                .log(String.format("Sending order %s to UK topic", header("fileName")))
                .to(Routes.ACTIVEMQ_UK_PATH)
            .otherwise()
                .log(String.format("Sending order %s to Other topic", header("fileName")))
                .to(Routes.ACTIVEMQ_COUNTRY_PATH);
    }
}
