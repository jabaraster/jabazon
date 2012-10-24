/**
 * 
 */
package jabara.jabazon.model;

import java.io.Serializable;

/**
 * @author jabaraster
 */
public class ImageLinks implements Serializable {
    private static final long serialVersionUID = -8485838846501238915L;

    private String            smallThumbnail;
    private String            thumbnail;

    /**
     * @return the smallThumbnail
     */
    public String getSmallThumbnail() {
        return this.smallThumbnail;
    }

    /**
     * @return the thumbnail
     */
    public String getThumbnail() {
        return this.thumbnail;
    }

    /**
     * @param pSmallThumbnail the smallThumbnail to set
     */
    public void setSmallThumbnail(final String pSmallThumbnail) {
        this.smallThumbnail = pSmallThumbnail;
    }

    /**
     * @param pThumbnail the thumbnail to set
     */
    public void setThumbnail(final String pThumbnail) {
        this.thumbnail = pThumbnail;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "ImageLinks [smallThumbnail=" + this.smallThumbnail + ", thumbnail=" + this.thumbnail + "]";
    }
}
