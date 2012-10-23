/**
 * 
 */
package jabara.jabazon;

import jabara.jabazon.model.Volumes;

import java.net.URLEncoder;

import net.arnx.jsonic.JSON;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

/**
 * @author jabaraster
 */
public class Sandbox {

    /**
     * @param pArgs 起動引数.
     */
    public static void main(final String[] pArgs) throws Exception {
        final String query = "すごいHaskell"; //$NON-NLS-1$
        final GetMethod get = new GetMethod("https://www.googleapis.com/books/v1/volumes?q=" + URLEncoder.encode(query, "UTF-8")); //$NON-NLS-1$ //$NON-NLS-2$
        final HttpClient client = new HttpClient();
        final int status = client.executeMethod(get);
        for (final Header header : get.getResponseHeaders()) {
            System.out.println(header.getName() + ": " + header.getValue()); //$NON-NLS-1$
        }
        System.out.println(status);
        final String json = get.getResponseBodyAsString();
        final Volumes volume = JSON.decode(json, Volumes.class);
        System.out.println(volume);
    }
}
