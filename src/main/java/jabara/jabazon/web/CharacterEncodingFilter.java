/**
 * 
 */
package jabara.jabazon.web;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author jabaraster
 */
@WebFilter(urlPatterns = { "/*" }, dispatcherTypes = { DispatcherType.REQUEST })
public class CharacterEncodingFilter implements Filter {

    private static final String ENC = "UTF-8"; //$NON-NLS-1$

    /**
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
        // 処理なし
    }

    /**
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(final ServletRequest pRequest, final ServletResponse pResponse, final FilterChain pChain) throws IOException,
            ServletException {
        pRequest.setCharacterEncoding(ENC);
        pChain.doFilter(pRequest, pResponse);
    }

    /**
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(@SuppressWarnings("unused") final FilterConfig pFilterConfig) {
        // 処理なし
    }

}
