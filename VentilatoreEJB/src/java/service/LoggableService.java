/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import ventilatore.Ventilatore;

/**
 *
 * @author Biagi
 */
public class LoggableService {
    private Logger logger;
    
    public void printNotifier(@Observes Ventilatore ventilatore) {
        logger = Logger.getLogger("global");
        logger.warning("Il numero di vendite e' cambiato");
    }
    
}
