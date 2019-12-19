/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unesco;

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
        SitoUnesco sito = new SitoUnesco("Castel del Monte", "2005", SitoUnesco.Tipologia.Culturale, "Puglia");
        Context jndiContext = new InitialContext();
        ConnectionFactory connection = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");
        try (JMSContext jmsContext = connection.createContext()){
            jmsContext.createProducer().send(topic, sito);
        }
    }
    
}
