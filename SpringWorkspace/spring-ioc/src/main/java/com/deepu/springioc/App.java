package com.deepu.springioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication springApplication = new SpringApplication(App.class);
    	ApplicationContext container = springApplication.run();
    	Computer computer = container.getBean(Computer.class);
        computer.start();
    }
}
