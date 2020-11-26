package com.hire.service;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class CharacterSetFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

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
