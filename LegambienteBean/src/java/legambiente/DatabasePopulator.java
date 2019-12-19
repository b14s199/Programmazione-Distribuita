/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legambiente;

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
    private CircoloEJB circoloEJB;
    private Circolo benevento, irno, ada;
    @PostConstruct
    private void populateDB() {
        benevento = new Circolo("Legambiente Benevento", "Antonio Basile", "legambiente.benevento@gmail.com", "Benevento", "Benevento", "Campania");
        irno = new Circolo("LEGAMBIENTE Valle dell'Irno", "Francesco Sanguedolce", "info@legambienteirno.it", "Baronissi", "Salerno", "Campania");
        ada = new Circolo("Esther Ada", "Francesco Sanguedolce", "rancosangi@gmai.com", "Lampedusa", "Agrigento", "Sicilia");
        circoloEJB.createCircolo(benevento);
        circoloEJB.createCircolo(irno);
        circoloEJB.createCircolo(ada);
        
    }
    @PreDestroy
    private void clearDB() {
        circoloEJB.deleteCircolo(benevento);
        circoloEJB.deleteCircolo(irno);
        circoloEJB.deleteCircolo(ada);
        
    }
}