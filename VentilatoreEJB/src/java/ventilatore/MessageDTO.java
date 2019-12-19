/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

import java.io.Serializable;

/**
 *
 * @author Biagi
 */
public class MessageDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private int vendite;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVendite() {
        return vendite;
    }

    public void setVendite(int vendite) {
        this.vendite = vendite;
    }

    public MessageDTO(String id, int vendite) {
        this.id = id;
        this.vendite = vendite;
    }
    
}
