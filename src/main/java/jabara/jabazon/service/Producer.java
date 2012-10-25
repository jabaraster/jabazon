/**
 * 
 */
package jabara.jabazon.service;

import jabara.general.ArgUtil;
import jabara.general.IProducer;
import jabara.guice.module.PostConstructModule;
import jabara.jpa_guice.JpaModule;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.postgresql.Driver;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author jabaraster
 */
public class Producer {

    private static final Injector _injector = createInjector();

    /**
     * @param pType -
     * @return -
     */
    public static <E> E getInstance(final Class<E> pType) {
        ArgUtil.checkNull(pType, "pType"); //$NON-NLS-1$
        return _injector.getInstance(pType);
    }

    @SuppressWarnings("nls")
    private static Map<String, String> createDbProperties() {
        try {
            final String u = System.getenv("DATABASE_URL");
            if (u == null) {
                return createLocalDbProperties();
            }
            final URI dbUri = new URI(u);

            final String username = dbUri.getUserInfo().split(":")[0];
            final String password = dbUri.getUserInfo().split(":")[1];
            final String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath() + ":" + dbUri.getPort();

            final Map<String, String> ret = new HashMap<String, String>();
            ret.put("javax.persistence.driver", "org.postgres.Driver");
            ret.put("javax.persistence.jdbc.url", dbUrl);
            ret.put("javax.persistence.jdbc.user", username);
            ret.put("javax.persistence.jdbc.password", password);

            return ret;

        } catch (final URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    private static Injector createInjector() {
        return Guice.createInjector( //
                new PostConstructModule() //
                , new JpaModule("jabazon", new IProducer<Map<String, String>>() { //$NON-NLS-1$
                            @SuppressWarnings("synthetic-access")
                            @Override
                            public Map<String, String> produce() {
                                return createDbProperties();
                            }
                        }));
    }

    @SuppressWarnings("nls")
    private static Map<String, String> createLocalDbProperties() {
        final Map<String, String> ret = new HashMap<String, String>();

        ret.put("javax.persistence.driver", Driver.class.getName());
        ret.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/postgres");
        ret.put("javax.persistence.jdbc.user", "postgres");
        ret.put("javax.persistence.jdbc.password", "postgres");

        return ret;
    }

}
