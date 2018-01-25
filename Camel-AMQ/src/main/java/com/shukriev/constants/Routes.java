package com.shukriev.constants;

/**
 * Created by Shukri Shukriev on 24/01/18.
 */
public class Routes {
    public static final String FILE_INPUT_PATH = "file:///home/estafet/camelInputFolder";
    public static final String FILE_INPUT_PATH_1 = "file:///home/estafet/camelTopicInputFolder";

    public static final String FILE_OUTPUT_PATH_US = "file:///home/estafet/camelOutputFolder/US";
    public static final String FILE_OUTPUT_PATH_UK = "file:///home/estafet/camelOutputFolder/UK";
    public static final String FILE_OUTPUT_PATH_OTHER = "file:///home/estafet/camelOutputFolder/camelOther";


    public static final String US_LABEL = "/order/customer/country = 'US'";
    public static final String UK_LABEL = "/order/customer/country = 'UK'";

    public static final String ACTIVEMQ_COUNTRY_PATH = "activemq:topic:Country";
    public static final String ACTIVEMQ_US_PATH = "activemq:topic:US";
    public static final String ACTIVEMQ_UK_PATH = "activemq:topic:UK";

    public static final String ACTIVEMQ_QUE_PATH = "activemq:incomingOrders";
}
