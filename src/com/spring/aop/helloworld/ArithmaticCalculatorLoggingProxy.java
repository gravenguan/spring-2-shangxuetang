package com.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmaticCalculatorLoggingProxy {

//    要代理对象
    private ArithmaticCalculator target;

    public ArithmaticCalculatorLoggingProxy(ArithmaticCalculator target) {
        this.target = target;
    }

    public ArithmaticCalculator getLoggingProxy(){
        ArithmaticCalculator proxy = null;

//        代理对象由哪一个类加载器负责加载
        ClassLoader loader=target.getClass().getClassLoader();
//        代理对象类型，即其中有哪些方法
        Class [] interfaces = new Class[]{ArithmaticCalculator.class};
//         当调用代理对象其中方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            /*
            proxy: 正在返回到那个代理对象，一般情况在invoke放大都不使用该对象
            method：正在被调用的方法
            args：调用方法时，传入的参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //日志
                System.out.println("The method"+methodName+" begins with "+ Arrays.asList(args));
                //执行方法
                Object result = method.invoke(target,args);
                //日志
                System.out.println("The method "+methodName + "ends with" + result);
                return result;
            }
        };

        proxy= (ArithmaticCalculator) Proxy.newProxyInstance(loader,interfaces,h);

        return proxy;
    }

}
