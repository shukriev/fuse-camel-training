package com.shukriev.services;

import com.shukriev.exceptions.OrderValidationException;
import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.camel.language.NamespacePrefix;
import org.apache.camel.language.XPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by Shukri Shukriev on 18/01/18.
 */
public class OrderService {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
    private static final Random RANDOM = new Random();

    public void validateOrderDate(@XPath(value = "/order:order/order:date",
            namespaces = @NamespacePrefix(prefix = "order", uri = "http://fabric8.com/examples/order/v7")) String date) throws OrderValidationException {
        final Calendar calendar = new GregorianCalendar();

        try {
            calendar.setTime(DATE_FORMAT.parse(date));

            if(calendar.get(calendar.DAY_OF_WEEK) == 7){
                LOGGER.warn("Order validation failure: order date: " + date + " should not be a Sunday");

                throw new OrderValidationException("Order date should not be a Sunday: " + date);
            }
        }catch (ParseException  ex) {
            throw new OrderValidationException("Invalid order date: " + date);
        }
    }

    public void randomlyThrowRuntimeException(@Header(Exchange.FILE_NAME) String name) {
        if (RANDOM.nextInt(3) > 0) {
            LOGGER.warn("An unexpected runtime exception occurred while processing " + name);
            throw new RuntimeException("Something else went wrong while handling this message");
        }
    }

}
