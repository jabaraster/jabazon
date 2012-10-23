/**
 * 
 */
package jabara.jabazon.model;

import java.io.Serializable;

/**
 * @author jabaraster
 */
public class Item implements Serializable {
    private static final long serialVersionUID = 6477604247343161195L;

    private String            kind;
    private String            id;
    private String            etag;
    private String            selfLink;
    private VolumeInfo        volumeInfo;

    /**
     * @return the etag
     */
    public String getEtag() {
        return this.etag;
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return the kind
     */
    public String getKind() {
        return this.kind;
    }

    /**
     * @return the selfLink
     */
    public String getSelfLink() {
        return this.selfLink;
    }

    /**
     * @return the volumnInfo
     */
    public VolumeInfo getVolumeInfo() {
        return this.volumeInfo;
    }

    /**
     * @param pEtag the etag to set
     */
    public void setEtag(final String pEtag) {
        this.etag = pEtag;
    }

    /**
     * @param pId the id to set
     */
    public void setId(final String pId) {
        this.id = pId;
    }

    /**
     * @param pKind the kind to set
     */
    public void setKind(final String pKind) {
        this.kind = pKind;
    }

    /**
     * @param pSelfLink the selfLink to set
     */
    public void setSelfLink(final String pSelfLink) {
        this.selfLink = pSelfLink;
    }

    /**
     * @param pVolumnInfo the volumnInfo to set
     */
    public void setVolumeInfo(final VolumeInfo pVolumnInfo) {
        this.volumeInfo = pVolumnInfo;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "Item [kind=" + this.kind + ", id=" + this.id + ", etag=" + this.etag + ", selfLink=" + this.selfLink + ", volumnInfo="
                + this.volumeInfo + "]";
    }
}
