/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

import java.util.List;
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
public class Main {
    public static void main(String args[]) throws NamingException {
        Context ctx = new InitialContext();
        VentilatoreEJBRemote ejb = (VentilatoreEJBRemote) ctx.lookup("java:global/VentilatoreBean/VentilatoreEJB!ventilatore.VentilatoreEJBRemote");
        List<Ventilatore> allByNazione = ejb.retrieveByNazione(args[0]);
        System.out.println("Cerco ventilatori con provenienza \"" + args[0] + "\":");
        for (Ventilatore ven : allByNazione) {
            System.out.println(ven);
        }
        List<Ventilatore> allByVelocita = ejb.retrieveByVelocitaMoreThan(2000);
        System.out.println("Cerco ventilatori con velocita' maggiore di 2000:");
        for (Ventilatore ven : allByVelocita) {
            System.out.println(ven);
        }
        MessageDTO mess = new MessageDTO("1", 50);
        Context jndiContext = new InitialContext();
        ConnectionFactory connection = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");
        try (JMSContext jmsContext = connection.createContext()){
            jmsContext.createProducer().send(topic, mess);
        }
        
    }
}
