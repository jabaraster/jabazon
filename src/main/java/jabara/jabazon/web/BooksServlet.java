/**
 * 
 */
package jabara.jabazon.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jabaraster
 */
@WebServlet(urlPatterns = { "/books/index" })
public class BooksServlet extends HttpServlet {
    private static final long serialVersionUID = 6902154629952354239L;

    /**
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(final HttpServletRequest pReq, final HttpServletResponse pResp) throws ServletException, IOException {
        pReq.getRequestDispatcher(WebUtil.getJspPath("/bookSearch.jsp")).forward(pReq, pResp); //$NON-NLS-1$
    }
}
