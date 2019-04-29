package AopCase.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @ProjectName: aop2
 * @Package: AopCase.Service.utils
 * @ClassName: Logger
 * @Description:打印日志 计划让其在切入点（业务层方法）方法执行前执行
 * @Author: zengyanbo
 * @CreateDate: 2019-04-27 15:32
 * @UpdateDate: 2019-04-27 15:32
 * @Version: 1.0
 */

public class Logger {

    public void printLog(){
        System.out.println("打印日志...");
    }

    /**
     * 环绕通知 实现接口ProceedingjoinPoint方法proceed() 此方法相当于明确调用切入点方法
     * 该接口作为环绕通知方法的参数，程序执行时，spring提供该接口的实现类供我们使用
     * 可以在代码中手动控制增强方法何时执行
     */
    public void aroundLog(ProceedingJoinPoint pjp){
        try {
            Object[] args = pjp.getArgs();
            System.out.println("执行aroundlog...前置");
            pjp.proceed(args);
            System.out.println("执行aroundlog...后置");
        } catch (Throwable throwable) {
            System.out.println("异常打印...");
            throwable.printStackTrace();
        } finally {
            System.out.println("结束day ...最终");
        }
    }
}
