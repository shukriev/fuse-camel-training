package com.shukriev.bean;

import org.apache.camel.Exchange;

/**
 * Created by Shukri Shukriev on 17/01/18.
 */
public class RecipientsSupport {

    public String recipientList(Exchange exchange) {
        String outputRecipients = String.format("file:///home/estafet/camelOutputFolder/EIP/%s?fileName=%s.xml, direct:filterRouteBuilder",
                exchange.getIn().getHeader("region"), exchange.getIn().getHeader("orderId"));
        return outputRecipients;
    }
}
