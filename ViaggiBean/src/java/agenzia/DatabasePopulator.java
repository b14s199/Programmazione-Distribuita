/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenzia;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Biagi
 */
@Singleton
@Startup
@DataSourceDefinition(
        user = "APP",
        password = "APP",
        databaseName = "EsameDB",
        className = "org.apache.derby.jdbc.ClientDataSource",
        name = "java:gloabl/jdbc/EsameDS",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    private Viaggio seychelles, corfu, cortina;
    @Inject
    private ViaggioEJB ejb;
    
    @PostConstruct
    private void inizializza() {
        seychelles = new Viaggio("Mare", "Seychelles", 500, 10, 10);
        corfu = new Viaggio("Mare", "Corfù", 200, 0, 20);
        cortina = new Viaggio("Montagna", "Cortina", 700, 20, 30);
        ejb.addViaggio(seychelles);
        ejb.addViaggio(corfu);
        ejb.addViaggio(cortina);
    }
    
    @PreDestroy
    private void distruggi() {
        ejb.deleteViaggio(seychelles);
        ejb.deleteViaggio(corfu);
        ejb.deleteViaggio(cortina);
    }
    
}
