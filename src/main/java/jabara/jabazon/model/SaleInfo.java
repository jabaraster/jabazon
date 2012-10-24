/**
 * 
 */
package jabara.jabazon.model;

import java.io.Serializable;

/**
 * @author jabaraster
 */
public class SaleInfo implements Serializable {
    private static final long serialVersionUID = -8948967077836548124L;

    private String            country;
    private ListPrice         listPrice;

    /**
     * @return the listPrice
     */
    public ListPrice getListPrice() {
        return this.listPrice;
    }

    /**
     * @param pListPrice the listPrice to set
     */
    public void setListPrice(final ListPrice pListPrice) {
        this.listPrice = pListPrice;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "SaleInfo [country=" + this.country + ", listPrice=" + this.listPrice + "]";
    }
}
