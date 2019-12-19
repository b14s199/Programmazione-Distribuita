/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unesco;

import java.util.Date;
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
    className ="org.apache.derby.jdbc.ClientDataSource",
    name ="java:global/jdbc/EsameDS",
    user ="APP",
    password ="APP",
    databaseName ="EsameDB",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    private SitoUnescoEJB unescoEJB;
    private SitoUnesco eolie, amalfitana, medicei, cilento;
    
    @PostConstruct
    private void inizializza() {
        eolie = new SitoUnesco("Isole Eolie", "2000", SitoUnesco.Tipologia.Naturale, "Sicilia");
        amalfitana = new SitoUnesco("Costiera Amalfitana", "1997", SitoUnesco.Tipologia.Culturale, "Campania");
        medicei = new SitoUnesco("Ville e giardini medicei in Toscana", "2013", SitoUnesco.Tipologia.Misto, "Toscana");
        cilento = new SitoUnesco("Parco Nazionale del Cilento e Vallo di Diano", "1998", SitoUnesco.Tipologia.Culturale, "Campania");
        unescoEJB.createSito(eolie);
        unescoEJB.createSito(amalfitana);
        unescoEJB.createSito(medicei);
        unescoEJB.createSito(cilento);
    }
    
    @PreDestroy
    private void destroy() {
        unescoEJB.deleteSito(eolie);
        unescoEJB.deleteSito(amalfitana);
        unescoEJB.deleteSito(medicei);
        unescoEJB.deleteSito(cilento);
    }
}
