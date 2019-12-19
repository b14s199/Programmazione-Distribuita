/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legambiente;

import interceptors.LoggableInterceptor;
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
@Interceptors(LoggableInterceptor.class)
public class CircoloEJB implements CircoloEJBRemote {
    @Inject
    private EntityManager em;
    
    @Override
    public Circolo searchById(Long id) {
        TypedQuery<Circolo> query = em.createNamedQuery(Circolo.searchById, Circolo.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Circolo> searchByRegione(String regione) {
        TypedQuery<Circolo> query = em.createNamedQuery(Circolo.searchByRegione, Circolo.class);
        query.setParameter("regione", regione);
        return query.getResultList();
    }

    @Override
    public List<Circolo> getAllCircols() {
       TypedQuery<Circolo> query = em.createNamedQuery(Circolo.getAllCircols, Circolo.class);
       return query.getResultList();
    }

    @Override
    public Circolo createCircolo(Circolo circolo) {
        em.persist(circolo);
        return circolo;
    }

    @Override
    public Circolo updateCircolo(Circolo circolo) {
        return em.merge(circolo);
    }

    @Override
    public void deleteCircolo(Circolo circolo) {
        em.remove(em.merge(circolo));
    }

    
}
