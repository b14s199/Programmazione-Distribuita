/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Biagi
 */
@Remote
public interface VentilatoreEJBRemote {
    public Ventilatore create(Ventilatore ventilatore);
    public Ventilatore update(Ventilatore ventilatore);
    public void remove(Ventilatore ventilatore);
    public Ventilatore retrieveById(Long id);
    public List<Ventilatore> retrieveByNazione(String nazione);
    public List<Ventilatore> retrieveAll();
    public List<Ventilatore> retrieveByVelocitaMoreThan(int velocita);
}
