/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenzia;

import java.io.Serializable;

/**
 *
 * @author Biagi
 */
public class MessageDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private int newPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public MessageDTO(String id, int newPrice) {
        this.id = id;
        this.newPrice = newPrice;
    }
    
}
