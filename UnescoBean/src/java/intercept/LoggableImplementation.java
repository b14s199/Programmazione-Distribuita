/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercept;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Biagi
 */
@Loggable
@Interceptor
public class LoggableImplementation {
    private int cont;
    
    @AroundInvoke
    public Object contatore(InvocationContext ic) throws Exception {
        cont++;
        System.out.println("Numero di invocazioni totali: " + cont);
        return ic.proceed();
    }
}
