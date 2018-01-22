package com.shukriev.bean;

import org.apache.camel.language.NamespacePrefix;
import org.apache.camel.language.XPath;
import org.apache.xerces.dom.DeferredTextImpl;

import java.util.List;

/**
 * Created by Shukri Shukriev on 19/01/18.
 */
public class FilterSupport {
    public boolean filter(@XPath(value = "//order:quantity/text()",
            namespaces = @NamespacePrefix(prefix = "order",
                    uri = "http://fabric8.com/examples/order/v7")) List<Object> quantities) {
        int parsedQty = 0;

        for(Object quantity : quantities) {
            int qty = Integer.parseInt(((DeferredTextImpl) quantity).getData());
            parsedQty += qty;
        }

        return parsedQty > 100;
    }

}
