package org.springDemo.v1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("BeansV1.xml");

        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");

        System.out.println(objA.getMessage());
    }
}
