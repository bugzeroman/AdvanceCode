package edu.yuwen.dp.behavior.chain.more.interceptor;

import java.util.List;

/**
 * 4.职责链模式（行为型）
 * 
 * 1.用数组存储处理器
 *
 * Demo:Spring中的拦截器，能够分别在两个方法中拦截请求和响应。
 */
public class HandlerExecutionChain {
    private Object handler;
    private List<HandlerInterceptor> interceptors;

    public void addInterceptor(HandlerInterceptor interceptor) {
        interceptors.add(interceptor);
    }

    boolean applyPreHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (interceptors != null && interceptors.size() != 0) {
            for (int i = 0; i < interceptors.size(); i++) {
                HandlerInterceptor interceptor = interceptors.get(i);
                if (!interceptor.preHandle(request, response, this.handler)) {
                    triggerAfterCompletion(request, response, null);
                    return false;
                }
            }
        }
        return true;
    }

    void applyPostHandle(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws Exception {
        if (interceptors != null && interceptors.size() != 0) {
            for (int i = interceptors.size() - 1; i >= 0; i--) {
                HandlerInterceptor interceptor = interceptors.get(i);
                interceptor.postHandle(request, response, this.handler, mv);
            }
        }
    }

    void triggerAfterCompletion(HttpServletRequest request, HttpServletResponse response, Exception ex)
            throws Exception {
        if ((interceptors != null && interceptors.size() != 0)) {
            for (int i = interceptors.size(); i >= 0; i--) {
                HandlerInterceptor interceptor = interceptors.get(i);
                try {
                    interceptor.afterCompletion(request, response, this.handler, ex);
                } catch (Throwable ex2) {
                    System.out.println("HandlerInterceptor.afterCompletion threw exception" + ex2);
                }
            }
        }
    }
}