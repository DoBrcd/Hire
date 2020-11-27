package com.hire.service;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Class which filters all request done on the application to set request (if not set) and response character encoding
 */
@WebFilter(urlPatterns = "/*")
public class CharacterSetFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig)
    {
    }

    /**
     * Filters all the request to add on request (if not already set) and response the character encoding to UTF-8
     * @param servletRequest The incoming request
     * @param servletResponse The response to be sent
     * @param filterChain The next filter to call
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        if(servletRequest.getCharacterEncoding() == null)
            servletRequest.setCharacterEncoding("UTF-8");

        servletResponse.setContentType("text/html; charset=UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy()
    {
    }
}
