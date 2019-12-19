/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author Biagi
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Ventilatore.retrieveById, query = "SELECT v FROM Ventilatore v WHERE v.id = :id"),
        @NamedQuery(name = Ventilatore.retrieveByNazione, query = "SELECT v FROM Ventilatore v WHERE v.nazione = :nazione"),
        @NamedQuery(name = Ventilatore.retrieveAll, query = "SELECT v FROM Ventilatore v"),
        @NamedQuery(name = Ventilatore.retrieveByVelocitaMoreThan, query = "SELECT v FROM Ventilatore v WHERE v.giriMinuto > :giriMinuto")
})
public class Ventilatore implements Serializable {
    public static final String retrieveById = "Ventilatore.retrieveById";
    public static final String retrieveByNazione = "Ventilatore.retrieveByNazione";
    public static final String retrieveAll = "Ventilatore.retrieveAll";
    public static final String retrieveByVelocitaMoreThan = "Ventilatore.retrieveVelocitaMoreThan";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String modello;
    private String marca;
    private int giriMinuto;
    @Min(0)
    @Max(10)
    private int rumore;
    private int elVenduti;
    private String nazione;

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getGiriMinuto() {
        return giriMinuto;
    }

    public void setGiriMinuto(int giriMinuto) {
        this.giriMinuto = giriMinuto;
    }

    public int getRumore() {
        return rumore;
    }

    public void setRumore(int rumore) {
        this.rumore = rumore;
    }

    public int getElVenduti() {
        return elVenduti;
    }

    public void setElVenduti(int elVenduti) {
        this.elVenduti = elVenduti;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ventilatore(String modello, String marca, int giriMinuto, int rumore, int elVenduti, String nazione) {
        this.modello = modello;
        this.marca = marca;
        this.giriMinuto = giriMinuto;
        this.rumore = rumore;
        this.elVenduti = elVenduti;
        this.nazione = nazione;
    }
    
    public Ventilatore() {
        
    }

    @Override
    public String toString() {
        return "Ventilatore{" + "id=" + id + ", modello=" + modello + ", marca=" + marca + ", giriMinuto=" + giriMinuto + ", rumore=" + rumore + ", elVenduti=" + elVenduti + ", nazione=" + nazione + '}';
    }

    
    
}
