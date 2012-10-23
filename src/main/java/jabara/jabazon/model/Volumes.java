/**
 * 
 */
package jabara.jabazon.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author jabaraster
 */
public class Volumes implements Serializable {
    private static final long serialVersionUID = 2959837603869310286L;

    private String            kind;
    private int               totalItems;
    private List<Item>        items;

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * @return the kind
     */
    public String getKind() {
        return this.kind;
    }

    /**
     * @return the totalItems
     */
    public int getTotalItems() {
        return this.totalItems;
    }

    /**
     * @param pItems the items to set
     */
    public void setItems(final List<Item> pItems) {
        this.items = pItems;
    }

    /**
     * @param pKind the kind to set
     */
    public void setKind(final String pKind) {
        this.kind = pKind;
    }

    /**
     * @param pTotalItems the totalItems to set
     */
    public void setTotalItems(final int pTotalItems) {
        this.totalItems = pTotalItems;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "Volumes [kind=" + this.kind + ", totalItems=" + this.totalItems + ", items=" + this.items + "]";
    }
}
