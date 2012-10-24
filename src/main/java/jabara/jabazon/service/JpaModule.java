/**
 * 
 */
package jabara.jabazon.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.postgresql.Driver;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;

/**
 * @author jabaraster
 */
public class JpaModule extends AbstractModule {

    private final EntityManagerFactory _emf = Persistence.createEntityManagerFactory("pu", createDbProperties()); //$NON-NLS-1$

    @Override
    protected void configure() {
        final Matcher<? super Class<?>> classMatcher = Matchers.subclassesOf(DaoBase.class);
        final Matcher<? super Method> methodMatcher = new AbstractMatcher<Method>() {
            @Override
            public boolean matches(final Method pT) {
                return Modifier.isPublic(pT.getModifiers());
            }
        };
        final TransactionInterceptor ti = new TransactionInterceptor();
        this.bindInterceptor(classMatcher, methodMatcher, ti);
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

    @SuppressWarnings("nls")
    private static Map<String, String> createLocalDbProperties() {
        final Map<String, String> ret = new HashMap<String, String>();

        ret.put("javax.persistence.driver", Driver.class.getName());
        ret.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/postgres");
        ret.put("javax.persistence.jdbc.user", "postgres");
        ret.put("javax.persistence.jdbc.password", "postgres");

        return ret;
    }

    private static class ThreadLocalEntityManagerFactoryHandler implements InvocationHandler {

        private final ThreadLocal<EntityManager> em = new ThreadLocal<EntityManager>();
        private final EntityManagerFactory       emf;

        /**
         * @param pEmf
         */
        public ThreadLocalEntityManagerFactoryHandler(final EntityManagerFactory pEmf) {
            this.emf = pEmf;
        }

        @Override
        public Object invoke(final Object pProxy, final Method pMethod, final Object[] pArgs) throws Throwable {
            if ("createEntityManager".equals(pMethod.getName())) {

            }
        }

    }

    private class TransactionInterceptor implements MethodInterceptor {

        private final EntityManagerFactory emf;

        /**
         * @param pEmf
         */
        public TransactionInterceptor(final EntityManagerFactory pEmf) {
            this.emf = pEmf;
        }

        @Override
        public Object invoke(final MethodInvocation pInvocation) throws Throwable {
        }

    }
}
