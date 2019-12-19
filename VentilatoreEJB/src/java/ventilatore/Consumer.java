/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
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
    private VentilatoreEJB ejb;
    @Inject
    private Event<Ventilatore> ventilatoreUpdated;
    
    @Override
    public void onMessage(Message message) {
        try {
            MessageDTO mex = message.getBody(MessageDTO.class);
            Ventilatore v = ejb.retrieveById(Long.parseLong(mex.getId()));
            int old = v.getElVenduti();
            v.setElVenduti(old + mex.getVendite());
            ejb.update(v);
            ventilatoreUpdated.fire(v);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
