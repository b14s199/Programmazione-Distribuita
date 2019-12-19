/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unesco;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
      @NamedQuery(name = SitoUnesco.RetrieveById, query = "SELECT s FROM SitoUnesco s WHERE s.id = :id"),
        @NamedQuery(name = SitoUnesco.RetrieveByRegione, query = "SELECT s FROM SitoUnesco s WHERE s.regione = :regione"),
        @NamedQuery(name = SitoUnesco.RetrieveAll, query = "SELECT s FROM SitoUnesco s"),
        @NamedQuery(name = SitoUnesco.RetrieveByTipology, query = "SELECT s FROM SitoUnesco s WHERE s.tipo = :tipologia")
})
public class SitoUnesco implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public enum Tipologia {
        Culturale,
        Naturale,
        Misto
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String dataRiconoscimento;
    private Tipologia tipo;
    private String regione;
    
    public final static String RetrieveById = "SitoUnesco.RetrieveById";
    public final static String RetrieveByRegione = "SitoUnesco.RetrieveByRegione";
    public final static String RetrieveAll = "SitoUnesco.RetrieveAll";
    public final static String RetrieveByTipology = "SitoUnesco.RetrieveByTipologia";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataRiconoscimento() {
        return dataRiconoscimento;
    }

    public void setDataRiconoscimento(String dataRiconoscimento) {
        this.dataRiconoscimento = dataRiconoscimento;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public Tipologia getTipo() {
        return tipo;
    }

    public void setTipo(Tipologia tipo) {
        this.tipo = tipo;
    }

    public SitoUnesco(String nome, String dataRiconoscimento, Tipologia tipo, String regione) {
        this.nome = nome;
        this.dataRiconoscimento = dataRiconoscimento;
        this.tipo = tipo;
        this.regione = regione;
    }
   
    public SitoUnesco() {
        
    }

    @Override
    public String toString() {
        return "SitoUnesco{" + "id=" + id + ", nome=" + nome + ", dataRiconoscimento=" + dataRiconoscimento + ", tipo=" + tipo + ", regione=" + regione + '}';
    }
    
}
