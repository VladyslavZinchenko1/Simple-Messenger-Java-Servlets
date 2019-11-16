package filter;

import utility.Constans;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (Objects.nonNull(((HttpServletRequest) servletRequest).getSession().getAttribute("user"))) {
            servletRequest.getRequestDispatcher(Constans.FindUser).forward(servletRequest, servletResponse);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
