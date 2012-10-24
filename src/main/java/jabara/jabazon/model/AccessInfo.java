/**
 * 
 */
package jabara.jabazon.model;

import java.io.Serializable;

/**
 * @author jabaraster
 */
public class AccessInfo implements Serializable {
    private static final long serialVersionUID = 2777437866890584235L;

    private String            country;

    /**
     * @return the country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * @param pCountry the country to set
     */
    public void setCountry(final String pCountry) {
        this.country = pCountry;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "AccessInfo [country=" + this.country + "]";
    }

}
