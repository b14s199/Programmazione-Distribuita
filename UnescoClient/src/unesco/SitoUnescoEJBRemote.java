/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unesco;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Biagi
 */
@Remote
public interface SitoUnescoEJBRemote {
    
    public SitoUnesco createSito(SitoUnesco s);
    public SitoUnesco updateSito(SitoUnesco s);
    public void deleteSito(SitoUnesco s);
    public SitoUnesco retrieveSitoById(Long id);
    public List<SitoUnesco> retrieveSitiByRegione(String regione);
    public List<SitoUnesco> retrieveAllSiti();
    public List<SitoUnesco> retrieveByTipology(SitoUnesco.Tipologia tipo);
}
