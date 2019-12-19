package intercept;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Biagi
 */
@Interceptor
public class LoggableImpl {
    private int cont;
    
    @AroundInvoke
    private Object conta(InvocationContext ic) throws Exception {
        cont++;
        System.out.println("Numero di invocazioni totali del metodo " + ic.getMethod().getName() + ": " + cont);
        return ic.proceed();
    }
    
}
