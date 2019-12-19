package legambiente;

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
        CircoloEJBRemote circoloEJB = (CircoloEJBRemote) ctx.lookup("java:global/LegambienteBean/CircoloEJB!legambiente.CircoloEJBRemote");
        List<Circolo> allCircols = circoloEJB.getAllCircols();
        
        System.out.println("Stampo tutti i circoli: ");
        for (Circolo c : allCircols) {
            System.out.println("###" + c);
        }
        System.out.println("Inserisci il nome della regione: ");
        String nomeRegione = (new Scanner(System.in)).next();
        List<Circolo> circoliRegionali = circoloEJB.searchByRegione(nomeRegione);
        System.out.println("Stampo tutti i circoli della " + nomeRegione + ": ");
        for (Circolo c : circoliRegionali) {
            System.out.println("###" + c);
        }
    }
}
