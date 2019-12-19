/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenzia;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Biagi
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Viaggio.retrieveById, query = "SELECT v FROM Viaggio v WHERE v.id= :id"),
        @NamedQuery(name = Viaggio.retrieveByDestinazione, query = "SELECT v FROM Viaggio v WHERE v.destinazione = :destinazione"),
        @NamedQuery(name = Viaggio.retrieveAll, query = "SELECT v FROM Viaggio v"),
        @NamedQuery(name = Viaggio.retrieveByPrezzoLessThan, query = "SELECT v FROM Viaggio v WHERE v.prezzo < :prezzo")
})

public class Viaggio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoria;
    private String destinazione;
    private int prezzo;
    private int sconto;
    private int disponibilita;

    public final static String retrieveById = "Viaggio.retrieveById";
    public final static String retrieveByDestinazione = "Viaggio.retrieveByDestinazione";
    public final static String retrieveAll = "Viaggio.retrieveAll";
    public final static String retrieveByPrezzoLessThan = "Viaggio.retrieveByPrezzo";
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    public Viaggio(String categoria, String destinazione, int prezzo, int sconto, int disponibilita) {
        this.categoria = categoria;
        this.destinazione = destinazione;
        this.prezzo = prezzo;
        this.sconto = sconto;
        this.disponibilita = disponibilita;
    }
    
    public Viaggio() {
        
    }

    @Override
    public String toString() {
        return "Viaggio{" + "id=" + id + ", categoria=" + categoria + ", destinazione=" + destinazione + ", prezzo=" + prezzo + ", sconto=" + sconto + ", disponibilita=" + disponibilita + '}';
    }
    
    
    
}
