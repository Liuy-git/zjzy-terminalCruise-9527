package com.zoomlgd.zjzygc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @Author: lindw
 * @Date: 2019/8/14 9:03
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class MyAspect {

    /**
     * 定义切入点表达式
     */
    @Pointcut("execution(* com.zoomlgd.zjzygc.controller.*.*(..))")
    private void myPointcut(){}


    /**
     * 前置通知
       */
    @Before("myPointcut()")
    public void myBefore(JoinPoint joinPoint){
        log.info("前置通知--目标类是："+joinPoint.getTarget());
        log.info("前置通知--被植入增强处理的目标方法为："+joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();
        StringBuffer stringBuffer =  new StringBuffer();
        for(int i=0;i<parameterNames.length;i++){
            stringBuffer.append(parameterNames[i]+":"+args[i]+"  ");
        }
        log.info("前置通知--传入参数："+stringBuffer);
    }



//    /**
//     * 后置通知
//     */
//    @AfterReturning("myPointcut()")
//    public void myAfterReturning(JoinPoint joinPoint) {
//        System.out.println("后置通知：模拟记录日志...");
//        System.out.println("被植入增强处理的目标方法为："+joinPoint.getSignature().getName());
//    }
//
//    /**
//     * 环绕通知
//     * proceedingJoinPoint 是JoinPoint子接口，标示可以执行目标方法
//     * 1.必须是Object类型的返回值
//     * 2.必须接受一个参数，类型为proceedingJoinPoint
//     * 3.必须thorws Thorwable
//     * @param proceedingJoinPoint
//     * @return
//     * @throws Throwable
//     */
//    @Around("myPointcut()")
//    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("环绕开始：执行目标方法之前，模拟关闭事务...");
//        Object object = proceedingJoinPoint.proceed();
//        System.out.println("环绕结束：执行目标方法之后，模拟关闭事务...");
//        return object;
//    }
//    /**
//     * 异常通知
//     */
//    @AfterThrowing(value = "myPointcut()",throwing = "throwable")
//    public void myAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
//        System.out.println("异常通知："+"出错了"+throwable.getMessage());
//    }
//    /**
//     * 最终通知
//     */
//    @After("myPointcut()")
//    public void myAfter(){
//        System.out.println("最终通知：模拟方法结束后释放资源...");
//    }

}

