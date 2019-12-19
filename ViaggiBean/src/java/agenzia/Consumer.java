/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenzia;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
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
                    propertyValue = "Auto-acknowledge"
            )
        }
)
public class Consumer implements MessageListener{
    @Inject
    ViaggioEJB ejb;
    
    @Override
    public void onMessage(Message message) {
        try {
            MessageDTO mex = message.getBody(MessageDTO.class);
            Viaggio v = ejb.retrieveById(Long.parseLong(mex.getId()));
            v.setPrezzo(mex.getNewPrice());
            ejb.updateViaggio(v);
            System.out.println("Aggiornamento del viaggio a " + v.getDestinazione() + " riuscito.");
        } catch (Exception e) {
            System.out.println("Non è stato compiuto alcun aggiornamento.");
        }
    }
    
}
