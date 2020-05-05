package com.spring.proxy;

public class Test {

	public static void main(String[] args) {
//		MathI mathi = new MathImpl();
//		int result = mathi.add(1, 3);
//		System.out.println(result);
		
		ProxyUtil proxy = new ProxyUtil(new MathImpl());
		MathI math =(MathI)proxy.getProxy();
		int i = math.add(1,1);
		System.out.println(i);
	}

}
