/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;
import calculator.*;
/**
 *
 * @author Biagi
 */
public class mainClass {
    public static void main(String args[]) {
        System.out.println(hello("Bigi"));
    }
    private static String hello(java.lang.String name) {
        CalculatorWebService_Service service = new calculator.CalculatorWebService_Service();
        CalculatorWebService port = service.getCalculatorWebServicePort();
        return port.hello(name);
    }
    
}
