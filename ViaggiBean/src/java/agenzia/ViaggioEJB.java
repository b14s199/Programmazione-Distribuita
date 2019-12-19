/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenzia;

import intercept.LoggableImpl;
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
@Interceptors(LoggableImpl.class)
public class ViaggioEJB implements ViaggioEJBRemote {
    @Inject
    private EntityManager em;
    
    
    @Override
    public Viaggio addViaggio(Viaggio v) {
        em.persist(v);
        return v;
    }

    @Override
    public Viaggio updateViaggio(Viaggio v) {
        return em.merge(v);
    }

    @Override
    public void deleteViaggio(Viaggio v) {
        em.remove(em.merge(v));
    }

    @Override
    public List<Viaggio> retrieveAll() {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.retrieveAll, Viaggio.class);
        return query.getResultList();
    }

    @Override
    public List<Viaggio> retrieveByPrezzoLessThan(int prezzo) {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.retrieveByPrezzoLessThan, Viaggio.class);
        query.setParameter("prezzo", prezzo);
        return query.getResultList();
    }

    @Override
    public Viaggio retrieveById(Long id) {
        TypedQuery<Viaggio> query = em.createNamedQuery(Viaggio.retrieveById, Viaggio.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
    
    

}
