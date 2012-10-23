/**
 * 
 */
package jabara.jabazon.model;

import java.io.Serializable;

/**
 * @author jabaraster
 */
public class Industry implements Serializable {
    private static final long serialVersionUID = -4503752997088986300L;

    private String            type;
    private String            identifier;

    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return this.identifier;
    }

    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @param pIdentifier the identifier to set
     */
    public void setIdentifier(final String pIdentifier) {
        this.identifier = pIdentifier;
    }

    /**
     * @param pType the type to set
     */
    public void setType(final String pType) {
        this.type = pType;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "Industry [type=" + this.type + ", identifier=" + this.identifier + "]";
    }
}
