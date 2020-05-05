package com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyUtil {
	private MathImpl mathImpl;
	
	public ProxyUtil(MathImpl mathImpl) {
		super();
		this.mathImpl = mathImpl;
	}
	public Object getProxy(){
		ClassLoader loader=this.getClass().getClassLoader();
		Class[] interfaces = mathImpl.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader,interfaces ,new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				MyLogger.before(method.getName(),Arrays.toString(args));
				Object result = method.invoke(mathImpl, args);
				MyLogger.after(method.getName(),result);
				return result;
			}
		});
	} 
}
