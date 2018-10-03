package com.spring.aop.helloworld;

public class Main {
    public static void main(String[] args) {
//        ArithmaticCalculator arithmaticCalculator = null;
//        arithmaticCalculator = new ArithmaticCalculatorLoggingImpl();

        ArithmaticCalculator target =new ArithmaticCalculatorImpl();
        ArithmaticCalculator proxy =new ArithmaticCalculatorLoggingProxy(target).getLoggingProxy();

        System.out.println(proxy.getClass().getName());

        int result=proxy.add(1,2);
        System.out.println("-->"+ result);

        result=proxy.div(4,2);
        System.out.println("-->"+ result);
    }
}
