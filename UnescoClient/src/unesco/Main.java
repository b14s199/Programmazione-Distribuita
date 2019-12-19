/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unesco;

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
    public static void main(String args[]) throws NamingException{
        Context ctx = new InitialContext();
        SitoUnescoEJBRemote ejb = (SitoUnescoEJBRemote) ctx.lookup("java:global/UnescoBean/SitoUnescoEJB!unesco.SitoUnescoEJBRemote");
        List<SitoUnesco> all = ejb.retrieveAllSiti();
        for (SitoUnesco s : all) {
            System.out.println(s);
        }
        System.out.println("Inserire il nome della tipologia da cercare: ");
        String tipology = (new Scanner(System.in)).next();
        SitoUnesco.Tipologia tipo = Enum.valueOf(SitoUnesco.Tipologia.class, tipology);
        List<SitoUnesco> tipologiaScelta = ejb.retrieveByTipology(tipo);
        for (SitoUnesco scelto : tipologiaScelta) {
            System.out.println(scelto);
        }
    }
    
}
