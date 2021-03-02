package edu.yuwen.dp.behavior.chain.more.interceptor;

// 自定义的日志拦截器
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("拦截客户端发送来的请求.");
        // 继续后续的处理
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("拦截发送给客户端的响应.");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("这里总是被执行.");
    }
}

/**
// 在Spring MVC配置文件中配置interceptors
<mvc:interceptors><mvc:interceptor><mvc:mapping path="/*"/>
       <bean class="com.xzg.cd.LogInterceptor" />
   </mvc:interceptor>
</mvc:interceptors>
 */