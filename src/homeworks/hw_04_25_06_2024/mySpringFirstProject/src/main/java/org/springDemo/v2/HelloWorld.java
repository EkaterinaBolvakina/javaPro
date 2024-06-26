package org.springDemo.v2;

public class HelloWorld {

    public void initMethod() throws Exception{
        System.out.println("Ich bin init-methode " + this.getClass().getSimpleName());
    }

    public void destroyMethod() throws Exception{
        System.out.println("Ich bin destroy-methode " + this.getClass().getSimpleName());
    }

    public void workingMethod() throws Exception{
        System.out.println("Working");
    }
}
