/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import java.util.Date;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Biagi
 */
public class OrderProducer {
    public static void main(String args[]) throws NamingException{
        Float totalAmount = Float.valueOf(args[0]);
        OrderDTO order = new OrderDTO(12341, new Date(), "Betty Moreau", totalAmount);
        Context jndiContext = new InitialContext();
        ConnectionFactory connection = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");
        try (JMSContext jmsContext = connection.createContext()){
            jmsContext.createProducer().setProperty("orderAmount", totalAmount).send(topic, order);
        }
    }
}
