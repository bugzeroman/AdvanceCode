package edu.yuwen.dp.behavior.chain.more.filter;

/**
 * 4.职责链模式（行为型）
 * 
 * 1.用数组存储处理器
 *
 * Demo:容器中的Servlet过滤器，通过递归调用实现双向拦截，既能拦截客户端发送来的请求，也能拦截发送给客户端的响应。
 */
public final class ApplicationFilterChain implements FilterChain {
    private static final int INCREMENT = 10;
    private int pos = 0; // 当前执行到了哪个filter
    private int n; // filter的个数
    private ApplicationFilterConfig[] filters;
    private Servlet servlet;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) {
        if (pos < n) {
            ApplicationFilterConfig filterConfig = filters[pos++];
            Filter filter = filterConfig.getFilter();
            filter.doFilter(request, response, this);
        } else {
            // filter都处理完毕后，执行servlet
            servlet.service(request, response);
        }
    }

    public void addFilter(ApplicationFilterConfig filterConfig) {
        for (ApplicationFilterConfig filter : filters)
            if (filter == filterConfig)
                return;

        if (n == filters.length) {// 扩容
            ApplicationFilterConfig[] newFilters = new ApplicationFilterConfig[n + INCREMENT];
            System.arraycopy(filters, 0, newFilters, 0, n);
            filters = newFilters;
        }
        filters[n++] = filterConfig;
    }
}