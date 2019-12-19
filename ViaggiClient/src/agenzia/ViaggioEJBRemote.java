/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenzia;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Biagi
 */
@Remote
public interface ViaggioEJBRemote {
    public Viaggio addViaggio(Viaggio v);
    public Viaggio updateViaggio(Viaggio v);
    public void deleteViaggio(Viaggio v);
    public List<Viaggio> retrieveAll();
    public List<Viaggio> retrieveByPrezzoLessThan(int prezzo);
    public Viaggio retrieveById(Long id);
}
