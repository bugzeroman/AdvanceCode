package edu.yuwen.dp.behavior.chain.more.filter;

public interface Filter {

    void init(FilterConfig filterConfig) throws ServletException;

    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain);

    void destroy();

}
