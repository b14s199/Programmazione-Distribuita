
package calculator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per sum complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="sum">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="a" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="b" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sum", propOrder = {
    "a",
    "b"
})
public class Sum {

    protected int a;
    protected int b;

    /**
     * Recupera il valore della proprietà a.
     * 
     */
    public int getA() {
        return a;
    }

    /**
     * Imposta il valore della proprietà a.
     * 
     */
    public void setA(int value) {
        this.a = value;
    }

    /**
     * Recupera il valore della proprietà b.
     * 
     */
    public int getB() {
        return b;
    }

    /**
     * Imposta il valore della proprietà b.
     * 
     */
    public void setB(int value) {
        this.b = value;
    }

}
