package com.ideas2it.filter;

import sun.awt.geom.AreaOp;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class MyFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context= filterConfig.getServletContext();
        this.context.log("Filter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

            chain.doFilter(request, response);
            System.out.println("1");
    }

    @Override
    public void destroy() {

    }
}
