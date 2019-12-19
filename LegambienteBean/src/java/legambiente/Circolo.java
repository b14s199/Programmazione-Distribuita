/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legambiente;

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
    @NamedQuery(name = Circolo.searchById, query = "SELECT c FROM Circolo c WHERE c.id = :id"),
    @NamedQuery(name = Circolo.searchByRegione, query = "SELECT c FROM Circolo c WHERE c.regione = :regione"),
    @NamedQuery(name = Circolo.getAllCircols, query = "SELECT c FROM Circolo c")
})
public class Circolo implements Serializable {
    private static final long serialVersionUID = 48L;
    public static final String searchById = "Circolo.searchById";
    public static final String searchByRegione = "Circolo.searchByRegione";
    public static final String getAllCircols = "Circolo.getAllCircols";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomeCircolo;
    private String responsabile;
    private String email;
    private String citta;
    private String provincia;
    private String regione;

    public String getNomeCircolo() {
        return nomeCircolo;
    }

    public void setNomeCircolo(String nomeCircolo) {
        this.nomeCircolo = nomeCircolo;
    }

    public String getResponsabile() {
        return responsabile;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
            
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Circolo{" + "id=" + id + ", nomeCircolo=" + nomeCircolo + ", responsabile=" + responsabile + ", email=" + email + ", citta=" + citta + ", provincia=" + provincia + ", regione=" + regione + '}';
    }

    public Circolo(String nomeCircolo, String responsabile, String email, String citta, String provincia, String regione) {
        this.nomeCircolo = nomeCircolo;
        this.responsabile = responsabile;
        this.email = email;
        this.citta = citta;
        this.provincia = provincia;
        this.regione = regione;
    }
    
    public Circolo(){
    
    }

    
    
}
