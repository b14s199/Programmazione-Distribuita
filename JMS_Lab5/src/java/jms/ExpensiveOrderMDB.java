/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Biagi
 */
@MessageDriven(
        mappedName="jms/javaee7/Topic",
        activationConfig={
            @ActivationConfigProperty(
                propertyName="acknowledgeMode",
                propertyValue="Auto-acknowledge"),
            @ActivationConfigProperty(
                propertyName="messageSelector",
                propertyValue="orderAmount > 1000"
            )
        })
public class ExpensiveOrderMDB implements MessageListener{
    @Override
    public void onMessage(Message message) {
        try {
            OrderDTO order = message.getBody(OrderDTO.class);
            System.out.println("Ordine costoso ricevuto: " + order);
        } catch (JMSException e){
            e.printStackTrace();
        }
    } 
}
