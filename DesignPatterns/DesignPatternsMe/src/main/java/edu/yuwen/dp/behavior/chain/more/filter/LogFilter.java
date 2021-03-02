package edu.yuwen.dp.behavior.chain.more.filter;

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 在创建Filter时自动调用，
        // 其中filterConfig包含这个Filter的配置参数，比如name之类的（从配置文件中读取的）
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        System.out.println("拦截客户端发送来的请求.");
        chain.doFilter(request, response);
        System.out.println("拦截发送给客户端的响应.");
    }

    @Override
    public void destroy() {
        // 在销毁Filter时自动调用
    }
}

/**
// 在web.xml配置文件中如下配置：
<filter>
  <filter-name>logFilter</filter-name>
  <filter-class>com.xzg.cd.LogFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>logFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
 */