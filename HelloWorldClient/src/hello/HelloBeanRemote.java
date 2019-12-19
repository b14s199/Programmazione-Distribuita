/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import javax.ejb.Remote;

/**
 *
 * @author Biagi
 */
@Remote
public interface HelloBeanRemote {
    
    //Qui si dichiarano tutti i metodi che vengono implementati dal Bean
    String sayHello(String name);
}
