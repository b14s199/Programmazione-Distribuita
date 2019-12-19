/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unesco;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Biagi
 */
@MessageDriven(
        mappedName = "jms/javaee7/Topic",
        activationConfig = {
            @ActivationConfigProperty(
                propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge")
        }
)
public class Consumer implements MessageListener {
    @Inject
    SitoUnescoEJB ejb;

    @Override
    public void onMessage(Message message) {
          try {
            SitoUnesco sito = message.getBody(SitoUnesco.class);
            ejb.createSito(sito);
            System.out.println("Il sito " + sito.getNome() +" e' stato creato.");
            
        } catch (JMSException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
