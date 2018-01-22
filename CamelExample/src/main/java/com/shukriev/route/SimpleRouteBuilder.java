package com.shukriev.route;

import com.shukriev.processor.MyProcessor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Shukri Shukriev on 11/01/18.
 */
public class SimpleRouteBuilder extends RouteBuilder {

    public void configure() throws Exception {
//        from("file..url").process(new MyProcessor()).to("...output..file.url");
        from("file:///home/estafet/camelInputFolder?noop=true").process(new MyProcessor()).to("file:///home/estafet/camelOutputFolder");
    }
}
