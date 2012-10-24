/**
 * 
 */
package jabara.jabazon.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author jabaraster
 */
public class VolumeInfo implements Serializable {
    private static final long serialVersionUID    = -7881677513251608336L;

    private String            title;
    private String            publisher;
    private String            description;
    private Date              publishedDate;
    private int               pageCount;
    private List<Industry>    industryIdentifiers = Collections.emptyList();
    private ImageLinks        imageLinks;
    private String            previewLink;
    private String            infoLink;
    private AccessInfo        accessInfo;

    /**
     * @return the accessInfo
     */
    public AccessInfo getAccessInfo() {
        return this.accessInfo;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return the imageLinks
     */
    public ImageLinks getImageLinks() {
        return this.imageLinks;
    }

    /**
     * @return the industoryIdentifiers
     */
    public List<Industry> getIndustryIdentifiers() {
        return this.industryIdentifiers;
    }

    /**
     * @return the infoLink
     */
    public String getInfoLink() {
        return this.infoLink;
    }

    /**
     * @return -
     */
    public String getIsbn13() {
        for (final Industry industry : this.industryIdentifiers) {
            if ("ISBN_13".equals(industry.getType())) { //$NON-NLS-1$
                return industry.getIdentifier();
            }
        }
        return null;
    }

    /**
     * @return the pageCount
     */
    public int getPageCount() {
        return this.pageCount;
    }

    /**
     * @return the previewLink
     */
    public String getPreviewLink() {
        return this.previewLink;
    }

    /**
     * @return the publishedDate
     */
    public Date getPublishedDate() {
        return this.publishedDate;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return this.publisher;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @param pAccessInfo the accessInfo to set
     */
    public void setAccessInfo(final AccessInfo pAccessInfo) {
        this.accessInfo = pAccessInfo;
    }

    /**
     * @param pDescription the description to set
     */
    public void setDescription(final String pDescription) {
        this.description = pDescription;
    }

    /**
     * @param pImageLinks the imageLinks to set
     */
    public void setImageLinks(final ImageLinks pImageLinks) {
        this.imageLinks = pImageLinks;
    }

    /**
     * @param pIndustoryIdentifiers the industoryIdentifiers to set
     */
    public void setIndustryIdentifiers(final List<Industry> pIndustoryIdentifiers) {
        this.industryIdentifiers = pIndustoryIdentifiers;
    }

    /**
     * @param pInfoLink the infoLink to set
     */
    public void setInfoLink(final String pInfoLink) {
        this.infoLink = pInfoLink;
    }

    /**
     * @param pPageCount the pageCount to set
     */
    public void setPageCount(final int pPageCount) {
        this.pageCount = pPageCount;
    }

    /**
     * @param pPreviewLink the previewLink to set
     */
    public void setPreviewLink(final String pPreviewLink) {
        this.previewLink = pPreviewLink;
    }

    /**
     * @param pPublishedDate the publishedDate to set
     */
    public void setPublishedDate(final Date pPublishedDate) {
        this.publishedDate = pPublishedDate;
    }

    /**
     * @param pPublisher the publisher to set
     */
    public void setPublisher(final String pPublisher) {
        this.publisher = pPublisher;
    }

    /**
     * @param pTitle the title to set
     */
    public void setTitle(final String pTitle) {
        this.title = pTitle;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        return "VolumeInfo [title=" + this.title + ", publisher=" + this.publisher + ", description=" + this.description + ", publishedDate="
                + this.publishedDate + ", pageCount=" + this.pageCount + ", industryIdentifiers=" + this.industryIdentifiers + ", imageLinks="
                + this.imageLinks + ", previewLink=" + this.previewLink + ", infoLink=" + this.infoLink + ", accessInfo=" + this.accessInfo + "]";
    }

}