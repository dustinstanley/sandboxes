package org.example.katharsis;

import io.katharsis.invoker.KatharsisInvokerBuilder;
import io.katharsis.locator.JsonServiceLocator;
import io.katharsis.locator.SampleJsonServiceLocator;
import io.katharsis.servlet.AbstractKatharsisServlet;
import io.katharsis.servlet.KatharsisProperties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class SampleKatharsisServlet extends AbstractKatharsisServlet {

    private String resourceSearchPackage;
    private String resourceDefaultDomain;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        resourceSearchPackage = servletConfig
                .getInitParameter(KatharsisProperties.RESOURCE_SEARCH_PACKAGE);
        resourceDefaultDomain = servletConfig
                .getInitParameter(KatharsisProperties.RESOURCE_DEFAULT_DOMAIN);
    }

    /**
     * NOTE: A class extending this must provide a platform specific {@link JsonServiceLocator}
     *       instead of the (testing-purpose) {@link SampleJsonServiceLocator} below
     *       in order to provide advanced dependency injections for the repositories.
     */
    @Override
    protected KatharsisInvokerBuilder createKatharsisInvokerBuilder() {
        return new KatharsisInvokerBuilder()
                .resourceSearchPackage(resourceSearchPackage)
                .resourceDefaultDomain(resourceDefaultDomain)
                .jsonServiceLocator(new SampleJsonServiceLocator());
    }

}
