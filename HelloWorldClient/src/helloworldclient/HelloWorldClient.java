package helloworldclient;
import javax.naming.Context;
import javax.naming.InitialContext;
import hello.*;
import javax.naming.NamingException;

public class HelloWorldClient {
    public static void main(String[] args) throws NamingException {
        
        //istanziamo la variabile del contesto di esecuzione
        Context ctx = new InitialContext();
        
        //andiamo a recuperare il Bean su cui eseguire le operazioni -- il lookup ci permette di trovare il Bean java:global/[NomeProgettoDelBean]/[NomeDelBean]![pacchettoCheContieneL'Interfaccia.Interfaccia]
        HelloBeanRemote helloBean = (HelloBeanRemote) ctx.lookup("java:global/HelloWorldBean/HelloBean!hello.HelloBeanRemote");
        
        System.out.println("Ora invoco...");
        
        //invochiamo il metodo remoto
        System.out.println(helloBean.sayHello("Biagio"));
    }
}