/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legambiente;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Biagi
 */
@Remote
public interface CircoloEJBRemote {
    public Circolo searchById(Long id);
    public List<Circolo> searchByRegione(String regione);
    public List<Circolo> getAllCircols();
    public Circolo createCircolo(Circolo circolo);
    public Circolo updateCircolo(Circolo circolo);
    public void deleteCircolo(Circolo circolo);
}
