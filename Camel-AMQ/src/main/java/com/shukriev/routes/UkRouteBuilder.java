package com.shukriev.routes;

import com.shukriev.constants.Routes;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 24/01/18.
 */
public class UkRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from(Routes.ACTIVEMQ_UK_PATH)
            .log(String.format("Get order %s from UK topic", header("fileName")))
            .to(Routes.FILE_OUTPUT_PATH_UK);
    }
}
