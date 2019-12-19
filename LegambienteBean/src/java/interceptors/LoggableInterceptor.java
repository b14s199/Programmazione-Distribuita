package interceptors;


import java.util.HashMap;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;


/**
 *
 * @author Biagi
 */
@Loggable
@Interceptor
public class LoggableInterceptor {
    
    private static final HashMap<String, Integer> counters = new HashMap<String,Integer>(); /*
                                                                                              Utilizzo un HashMap che mi permette di mappare i nomi
                                                                                              delle funzione con il suo contatore.
                                                                                              Quando viene chiamto un metodo aggiorno il suo contatore.*/
    
    @AroundInvoke
    public Object contaIncazioni(InvocationContext ic){
       String nameClass = ic.getMethod().getDeclaringClass().getName();
       String nameMethod = ic.getMethod().getName();
        
        try{ //Verifico l'esistenza della chiave. Nel caso negativo creo la chiave e inserisco il valore del suo contatore a 1, aggiorno il suo contatore altrimenti. 
            if(!counters.containsKey(nameMethod))
                counters.put(nameMethod,1);
            else
                counters.put(nameMethod,counters.get(nameMethod)+1);
                
            System.out.println("Nella classe "+nameClass+" il metodo " +nameMethod+" è stato chiamato "+counters.get(nameMethod)+" volte"); //Loggo sullo Standard Output
            return ic.proceed();    
        }
        catch(Exception e){
            e.printStackTrace(); // stampo lo StackTrace nel caso di errore
        }
        return null;    
       
    }
    
}
