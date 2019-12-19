/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Biagi
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book libro = new Book();
        EntityManagerFactory emg = Persistence.createEntityManagerFactory("LibreriaPU");
        EntityManager em = emg.createEntityManager();
        EntityTransaction tx = (EntityTransaction) em.getTransaction();
        tx.begin();
        em.persist(libro);
        em.close();
        emg.close();
        
    }
    
}
