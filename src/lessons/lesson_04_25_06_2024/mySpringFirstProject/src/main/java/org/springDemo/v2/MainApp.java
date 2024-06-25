package org.springDemo.v2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("BeansV2.xml");
        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        objA.workingMethod();
        context.close();
    }
}
