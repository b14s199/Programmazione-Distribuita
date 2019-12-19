/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenzia;

import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Biagi
 */
public class Main {
    public static void main(String args[]) throws NamingException {
        Context ct = new InitialContext();
        ViaggioEJBRemote ejb = (ViaggioEJBRemote) ct.lookup("java:global/ViaggiBean/ViaggioEJB!agenzia.ViaggioEJBRemote");
        List<Viaggio> all = ejb.retrieveAll();
        System.out.println("##Stampa di tutti i viaggi");
        for (Viaggio v : all) {
            System.out.println(v);
        }
        System.out.println("##Prezzo di cui si vogliono ottenere i viaggi inferiori: ");
        int price = (new Scanner(System.in)).nextInt();
        System.out.println("##Stampa di tutti i viaggi con prezzo minore di " + price + "€");
        List<Viaggio> less = ejb.retrieveByPrezzoLessThan(price);
        for (Viaggio v : less) {
            System.out.println(v);
        }
        
    }
}
