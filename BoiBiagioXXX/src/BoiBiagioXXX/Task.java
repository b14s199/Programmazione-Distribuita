/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoiBiagioXXX;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;


/**
 *
 * @author Biagi
 */
@Entity
@NamedQueries({
    @NamedQuery(name="getAllTask", query="SELECT t FROM Task t"),
    @NamedQuery(name="retrieveById", query="SELECT t FROM Task t WHERE t.id = :id"),
    @NamedQuery(name="retrieveByNumOre", query="SELECT t FROM Task t WHERE t.ore = :ore"),
    @NamedQuery(name="retrieveByAssegnatario", query="SELECT t FROM Task t WHERE t.assegnatario = :assegnatario"),
    @NamedQuery(name="retrieveByNumOreMinusThan", query="SELECT t FROM Task t WHERE t.ore < :ore"),
    @NamedQuery(name="retrieveByCompletedTask", query="SELECT t FROM Task t WHERE t.completamento = 100"),
    @NamedQuery(name="retrieveByUncompletedTask", query="SELECT t FROM Task t WHERE t.completamento != 100")
})
public class Task{
    public Task() {}
    public Task(String nome, tipo tipo, int ore, String assegnatario, int completamento) {
        this.nome = nome;
        this.tipo = tipo;
        this.ore = ore;
        this.assegnatario = assegnatario;
        this.completamento = completamento;
    }

    public enum tipo {
        comunicazione,
        innovazione,
        amministrazione
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    
    @Enumerated(EnumType.STRING)
    private tipo tipo;
    
    @Min(1) 
    @Max(8)
    private int ore;
    
    private String assegnatario;
    
    @Min(0) 
    @Max(100)
    private int completamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public tipo getTipo() {
        return tipo;
    }

    public void setTipo(tipo tipo) {
        this.tipo = tipo;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public String getAssegnatario() {
        return assegnatario;
    }

    public void setAssegnatario(String assegnatario) {
        this.assegnatario = assegnatario;
    }

    public int getCompletamento() {
        return completamento;
    }

    public void setCompletamento(int completamento) {
        this.completamento = completamento;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    
}
