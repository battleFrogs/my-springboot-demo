package com.gjc.config.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {


    //拦截的url
    private String processUrl;

    public CodeAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
        this.processUrl = defaultFilterProcessesUrl;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse)response;
        if(processUrl.equals(req.getServletPath()) && "POST".equalsIgnoreCase(req.getMethod())){
            //获取表单的学校id参数
            Integer code = Integer.valueOf(req.getParameter("code"));
            //将学校id存入session
            req.getSession().setAttribute("code",code);
        }
        chain.doFilter(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {
        return null;
    }

}
