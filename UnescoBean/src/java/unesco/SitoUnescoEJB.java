/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unesco;

import intercept.LoggableImplementation;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Biagi
 */
@Stateless
@LocalBean
public class SitoUnescoEJB implements SitoUnescoEJBRemote {
    @Inject
    EntityManager em;
    
    
    @Override
    public SitoUnesco createSito(SitoUnesco s) {
        em.persist(s);
        return s;
    }

    @Override
    public SitoUnesco updateSito(SitoUnesco s) {
        return em.merge(s);
    }

    @Override
    public void deleteSito(SitoUnesco s) {
        em.remove(em.merge(s));
    }

    @Override
    public SitoUnesco retrieveSitoById(Long id) {
        TypedQuery<SitoUnesco> query = em.createNamedQuery(SitoUnesco.RetrieveById, SitoUnesco.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<SitoUnesco> retrieveSitiByRegione(String regione) {
        TypedQuery<SitoUnesco> query = em.createNamedQuery(SitoUnesco.RetrieveByRegione, SitoUnesco.class);
        query.setParameter("regione", regione);
        return query.getResultList();
    }

    @Override
    public List<SitoUnesco> retrieveAllSiti() {
        TypedQuery<SitoUnesco> query = em.createNamedQuery(SitoUnesco.RetrieveAll, SitoUnesco.class);
        return query.getResultList();
    }
    
    @Interceptors(LoggableImplementation.class)
    @Override
    public List<SitoUnesco> retrieveByTipology(SitoUnesco.Tipologia tipo) {
        TypedQuery<SitoUnesco> query = em.createNamedQuery(SitoUnesco.RetrieveByTipology, SitoUnesco.class);
        query.setParameter("tipologia", tipo);
        return query.getResultList();
    }
}
