package com.shukriev.bean;

import org.apache.camel.language.NamespacePrefix;
import org.apache.camel.language.XPath;

/**
 * Created by Shukri Shukriev on 16/01/18.
 */
public class OrderIdSupport {

    public String getOrderId(@XPath(value = "/order:order/@id",
            namespaces = @NamespacePrefix(prefix = "order",
                    uri = "http://fabric8.com/examples/order/v7")) String orderId) {
        return orderId;
    }
}
