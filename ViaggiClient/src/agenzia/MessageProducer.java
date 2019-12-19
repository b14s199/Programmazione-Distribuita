/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenzia;

import java.util.Scanner;
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
public class MessageProducer {
     public static void main(String args[]) throws NamingException {
         System.out.println("ID del viaggio a cui cambiare il prezzo: ");
         String id = (new Scanner(System.in)).next();
         System.out.println("Nuovo prezzo: ");
         int price = (new Scanner(System.in)).nextInt();
         MessageDTO mex = new MessageDTO(id, price);
         Context jndiContext = new InitialContext();
         ConnectionFactory connection = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
         Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");
         try (JMSContext jmsContext = connection.createContext()){
             jmsContext.createProducer().send(topic, mex);
         }
    }
    
}
