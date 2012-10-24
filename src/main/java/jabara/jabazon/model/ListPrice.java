/**
 * 
 */
package jabara.jabazon.model;

import java.io.Serializable;

/**
 * @author jabaraster
 */
public class ListPrice implements Serializable {
    private static final long serialVersionUID = -1628433749988622664L;

    private double            amount;
    private String            currencyCode;

    /**
     * @return the amount
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * @return the currencyCode
     */
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    /**
     * @param pAmount the amount to set
     */
    public void setAmount(final double pAmount) {
        this.amount = pAmount;
    }

    /**
     * @param pCurrencyCode the currencyCode to set
     */
    public void setCurrencyCode(final String pCurrencyCode) {
        this.currencyCode = pCurrencyCode;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "ListPrice [amount=" + this.amount + ", currencyCode=" + this.currencyCode + "]";
    }

}
