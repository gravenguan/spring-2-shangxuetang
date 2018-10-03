package Impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把这个类声明为一个aspect：需要把该类放到IOC容器中，再声明为一个aspect
@Aspect
@Component
public class LoggingAspect {

    //声明该方法是一个前置通知：在目标开始之前执行
    @Before("execution(public int Impl.ArithmaticCalculator.add(int, int))")
    public void beforeMethod(){
        System.out.println("The method begins");
    }

}
