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
public class OrderConsumer {
    public static void main(String args[]) throws NamingException{
        Context jndiContext = new InitialContext();
        ConnectionFactory connection = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");
        try (JMSContext jmsContext = connection.createContext()){
            while (true) {
                OrderDTO order = jmsContext.createConsumer(topic).receiveBody(OrderDTO.class);
                System.out.println("Ordine ricevuto" + order);
            }
        }
    }
}
