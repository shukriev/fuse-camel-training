package com.shukriev.bean;

import org.apache.camel.language.NamespacePrefix;
import org.apache.camel.language.XPath;

/**
 * Created by Shukri Shukriev on 16/01/18.
 */
public class RegionSupport {
    public static final String AMER = "AMER";
    public static final String APAC = "APAC";
    public static final String EMEA = "EMEA";

    public String getRegion(@XPath(value = "/order:order/order:customer/order:country",
            namespaces = @NamespacePrefix(prefix = "order",
                uri = "http://fabric8.com/examples/order/v7")) String country) {

        if (country.equals("AU")) {
            return APAC;
        } else if (country.equals("US")) {
            return AMER;
        } else {
            return EMEA;
        }
    }
}
