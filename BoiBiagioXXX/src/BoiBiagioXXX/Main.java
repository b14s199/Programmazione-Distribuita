/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoiBiagioXXX;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EsamePU");
    EntityManager em = emf.createEntityManager();
    Query all = em.createNamedQuery("getAllTask", Task.class);
    List<Task> results = all.getResultList();
    System.out.println("\nQuery per tutti i task");
    for(Task t : results){
        System.out.println(t.getNome());
    }
    Query nominativo = em.createNamedQuery("retrieveByAssegnatario", Task.class);
    nominativo.setParameter("assegnatario", "nessuno");
    results = nominativo.getResultList();
    System.out.println("\nQuery per tutti i task che non hanno assegnatario");
    for (Task t : results) {
        System.out.println(t.getNome());
    }
    em.close();
    emf.close();
}
}