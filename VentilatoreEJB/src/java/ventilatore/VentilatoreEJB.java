/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventilatore;

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
public class VentilatoreEJB implements VentilatoreEJBRemote {
    @Inject
    EntityManager em;
    
    @Override
    public Ventilatore create(Ventilatore ventilatore) {
        em.persist(ventilatore);
        return ventilatore;
    }

    @Override
    public Ventilatore update(Ventilatore ventilatore) {
        return em.merge(ventilatore);
    }

    @Override
    public void remove(Ventilatore ventilatore) {
        em.remove(em.merge(ventilatore));
    }

    @Override
    public Ventilatore retrieveById(Long id) {
        TypedQuery query = em.createNamedQuery(Ventilatore.retrieveById, Ventilatore.class);
        query.setParameter("id", id);
        return (Ventilatore) query.getSingleResult();
    }

    @Override
    @Interceptors(LoggableImpl.class)
    public List<Ventilatore> retrieveByNazione(String nazione) {
        TypedQuery query = em.createNamedQuery(Ventilatore.retrieveByNazione, Ventilatore.class);
        query.setParameter("nazione", nazione);
        return query.getResultList();
    }

    @Override
    public List<Ventilatore> retrieveAll() {
        TypedQuery query = em.createNamedQuery(Ventilatore.retrieveAll, Ventilatore.class);
        return query.getResultList();
    }

    @Override
    public List<Ventilatore> retrieveByVelocitaMoreThan(int velocita) {
        TypedQuery query = em.createNamedQuery(Ventilatore.retrieveByVelocitaMoreThan, Ventilatore.class);
        query.setParameter("giriMinuto", velocita);
        return query.getResultList();
    }
    
}
