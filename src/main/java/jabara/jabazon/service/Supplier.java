/**
 * 
 */
package jabara.jabazon.service;

import jabara.util.ArgUtil;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author jabaraster
 */
public class Supplier {

    private static final Injector _injector = createInjector();

    /**
     * @param pType
     * @return
     */
    public static <E> E getInstance(final Class<E> pType) {
        ArgUtil.checkNull(pType, "pType"); //$NON-NLS-1$
        return _injector.getInstance(pType);
    }

    private static Injector createInjector() {
        return Guice.createInjector();
    }

}
