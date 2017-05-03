package andrii.spring;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringWebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        return new Filter[]{characterEncodingFilter};
    }

/*    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerFilter(servletContext, "springSecurityFilterChain");
    }

    private void registerFilter(ServletContext servletContext, String name) {
        DelegatingFilterProxy filter = new DelegatingFilterProxy(name);
        filter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
        servletContext.addFilter(name, filter).addMappingForUrlPatterns(null, false, "*//*");
    }*/
}
