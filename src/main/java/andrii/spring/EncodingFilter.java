package andrii.spring;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        System.out.println("requestEncoding: " + filterConfig.getInitParameter("requestEncoding"));

        request.setCharacterEncoding(filterConfig.getInitParameter("requestEncoding"));
        response.setCharacterEncoding(filterConfig.getInitParameter("requestEncoding"));

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
