/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

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
    databaseName = "EsameDB",
    user = "APP",
    password = "APP",
    className = "org.apache.derby.jdbc.ClientDataSource",
    name = "java:global/jdbc/EsameDS",
    properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {
    @Inject
    private VentilatoreEJB ejb;
    private Ventilatore soffiaFresco, wind, brezzaLeggera;
    
    @PostConstruct
    private void inizializza() {
        soffiaFresco = new Ventilatore("SoffiaFresco", "VentilatorePerTutti", 1500, 4, 10, "Italia");
        wind = new Ventilatore("Wind 3000", "Sturm", 2200, 6, 12, "Germania");
        brezzaLeggera = new Ventilatore("BrezzaLeggera", "Frescura", 1000, 5, 11, "Francia");
        ejb.create(soffiaFresco);
        ejb.create(wind);
        ejb.create(brezzaLeggera);
    }
    
    @PreDestroy
    private void distruggi(){
        ejb.remove(soffiaFresco);
        ejb.remove(wind);
        ejb.remove(brezzaLeggera);
    }
}
