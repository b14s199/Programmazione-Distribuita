/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoiBiagioXXX;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Biagi
 */
public class StampaMetodo {
    @AroundInvoke
    public Object modifyGreeting(InvocationContext ctx) throws Exception {
        System.out.println("cdscsdc");
        return ctx.proceed();
    }
}
