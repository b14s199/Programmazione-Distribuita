/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercept;

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
public class LoggableImpl {
    private static final HashMap<String, Integer> counters = new HashMap<String,Integer>(); 
    
    @AroundInvoke
    public Object contaIncazioni(InvocationContext ic){
       String nameClass = ic.getMethod().getDeclaringClass().getName();
       String nameMethod = ic.getMethod().getName();
        try{ 
            if(!counters.containsKey(nameMethod))
                counters.put(nameMethod,1);
            else
                counters.put(nameMethod,counters.get(nameMethod)+1);
                
            System.out.println("Nella classe "+nameClass+" il metodo " +nameMethod+" è stato chiamato "+counters.get(nameMethod)+" volte"); //Loggo sullo Standard Output
            return ic.proceed();    
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;    
       
    }
    
}
