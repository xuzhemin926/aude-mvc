package com.aude.mvc.aop.Interceptor;

import com.aude.mvc.aop.proxy.Proxy;
import com.aude.mvc.aop.proxy.ProxyChain;
import com.aude.mvc.aop.proxy.ProxyMethodFilter;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: audestick@gmail.com
 * Date: 2016/10/11 0011
 * To change this template use File | Settings | File Templates.
 * 代理方法拦截器
 */
public class ProxyMethodInterceptor implements MethodInterceptor {

    private Class superclass;

    private List<Proxy> proxys;

    private List<ProxyMethodFilter> proxyMethodFilters;

    private Set<String> allAop;

    public ProxyMethodInterceptor(Class superclass, List<Proxy> proxys, List<ProxyMethodFilter> proxyMethodFilters, Set<String> allAop) {
        this.superclass = superclass;
        this.proxys = proxys;
        this.proxyMethodFilters = proxyMethodFilters;
        this.allAop = allAop;
    }

    /**
     * obj 代理对象实例
     * method 源对象的方法名
     * args 传递给方法的实际入参
     * proxyMethod 与源对象中的method相对应的代理对象中的方法
     */
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        return new ProxyChain(superclass, obj, method, proxy, args, proxys, proxyMethodFilters, allAop).doProxyChain();
    }
}
