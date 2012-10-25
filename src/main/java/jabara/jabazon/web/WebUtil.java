/**
 * 
 */
package jabara.jabazon.web;

/**
 * @author jabaraster
 */
public final class WebUtil {

    private WebUtil() {
        //
    }

    /**
     * @param pRelativePathFromBase -
     * @return -
     */
    public static String getJspPath(final String pRelativePathFromBase) {
        return "/WEB-INF/jsp/" + pRelativePathFromBase; //$NON-NLS-1$
    }
}
