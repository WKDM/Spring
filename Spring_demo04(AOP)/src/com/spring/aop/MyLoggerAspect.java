package com.spring.aop;

import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect//标注当前类为切面
public class MyLoggerAspect{
	
	@Pointcut(value="execution(* com.spring.aop.*.*(..))")
	public void test(){}
	
	
	
	/**
	 * @before:将方法指定为前置通知
	 * 必须设置value，其值为切入点表达式
	 * 前置通知：作用于方法执行之前
	 * 第一个*代表任意的访问修饰符
	 * 第二个*代表任意类
	 * 第三个*代表类中的任意方法
	 * ..代表任意的参数列表
	 * */
//	@Before(value="execution(public int com.spring.aop.MathImpl.add(int,int))")
	@Before(value="test()")
	public void before(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();//获取方法的参数
		String methodName = joinPoint.getSignature().getName();//获取方法名
		System.out.println("方法名："+methodName+"数据"+Arrays.toString(args));
	}
	/**
	 * @After:将方法标注为后置通知
	 * 后置通知作用于方法的finally语句块，即不管有没有异常都会执行
	 * */
	@After(value="execution(* com.spring.aop.*.*(..))")
	public void after(){
		System.out.println("后置通知");
	}
	/**
	 * @AfterReturning:将方法标注为通知
	 * 返回通知：作用于方法执行之后
	 * 可通过returning设置接受方法返回值的变量名
	 * 要想在方法中使用，必须在方法的形参中设置和变量名相同的参数
	 * */
	@AfterReturning(value="execution(* com.spring.aop.*.*(..))",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("method:"+methodName+",result="+result);
	}
	/**
	 * @AfterThrows:将方法标注为异常通知（例外通知）
	 * 异常通知：作用于方法报出异常时
	 * 可通过throwing设置接受方法返回的信息
	 * 可通过具体的异常类型来对指定的异常进行操作。
	 * */
	@AfterThrowing(value="execution(* com.spring.aop.*.*(..))",throwing="ex")
	public void afterThrows(Exception ex){
		System.out.println("有异常啦，message："+ex);
	}
	
	
	/**
	 * @AfterThrows:将方法标注为异常通知（例外通知）
	 * 异常通知：作用于方法报出异常时
	 * 可通过throwing设置接受方法返回的信息
	 * 可通过具体的异常类型来对指定的异常进行操作。
	 * */
	@Around(value="execution(* com.spring.aop.*.*(..))")
	public Object afterThrows(ProceedingJoinPoint proceedingJoinPoint){
		Object result=null;
		try {
			//前置通知
			System.out.println("前置通知");
			result = proceedingJoinPoint.proceed();
			return result;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//异常通知
		}finally {
			//后置通知
			System.out.println("后置通知");
		}
		return -1;
	}
}
