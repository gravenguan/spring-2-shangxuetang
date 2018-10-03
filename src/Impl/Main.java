package Impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //1.创建Spring IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2，从IOC容器获取bean实例
        ArithmaticCalculator arithmaticCalculator = ctx.getBean(ArithmaticCalculator.class);

        //3.使用bean
        int result=arithmaticCalculator.add(3,6);

        System.out.println("result:" + result);
    }
}
