package com.shukriev.routes;

import com.shukriev.constants.Routes;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 24/01/18.
 */
public class OtherCountriesRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from(Routes.ACTIVEMQ_COUNTRY_PATH)
                .log(String.format("Get order %s from Other topic", header("fileName")))
                .to(Routes.FILE_OUTPUT_PATH_OTHER);
    }
}
