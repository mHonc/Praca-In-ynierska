package com.FitnessPlanApp.config;

import com.FitnessPlanApp.model.User;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        User userSession = (User) req.getSession().getAttribute("user");
        String requestUri = req.getRequestURI();

        if (
                (userSession != null) ||
                        
                        requestUri.startsWith("/resources/") ||
                        requestUri.endsWith(".css") ||
                        requestUri.endsWith(".png") ||
                        requestUri.endsWith(".jss") ||
                        requestUri.endsWith(".jpg") ||
                        requestUri.endsWith("register") ||
                        requestUri.endsWith("login")
        ) {
            filterChain.doFilter(req, resp);
        } else {
            resp.sendRedirect(resp.encodeRedirectURL("login"));
        }
    }

    @Override
    public void destroy() {

    }
}