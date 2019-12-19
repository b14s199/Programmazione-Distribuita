package library;
import java.util. *;
import javax.naming. *;
public class Main {
    public static void main(String[] args) throws NamingException {
        Context ctx;
        ctx = new InitialContext();
        BookEJBRemote bookEJB = (BookEJBRemote) ctx.lookup("java:global/LibraryBean/BookEJB!library.BookEJBRemote");
        Book book1 = new Book("Statistics", 12.5f, "Book on Statistics and Maths", "1-24561-799-0", 200, false);
        book1 = bookEJB.createBook(book1);
        System.out.println("###Book 1 creato: " + book1);
        Book book2 = new Book("Computer Networks", 12.5f, "Networks", "1-24561-799-0", 400, false);
        book2 = bookEJB.createBook(book2);
        System.out.println("###Book 2 creato: " + book2);
        
        
        System.out.println("Lista di tutti i libri");
        
        
        List<Book> books = bookEJB.findBooks();
        for (Book aBook : books) {
            System.out.println("---"+ aBook);
        }
        
        System.out.println("Aggiorniamo Book2("+book2.getTitle()+")");
        book2.setTitle("Computer Netowrks II");
        book2 = bookEJB.updateBook(book2);
        System.out.println("###Book2 aggiornato: "+ book2);
        
        System.out.println("Cancelliamo Book2("+book2.getTitle()+")");
        bookEJB.deleteBook(book2);
        System.out.println("###Book2 cancellato");
        
        System.out.println("Lista di tutti i libri dopo la cancellazione di Book2");
        
        
        books = bookEJB.findBooks();
        for (Book aBook : books) {
            System.out.println("---"+ aBook);
        }
        
    }
}