package com.example.springexample;

import com.example.springexample.components.BeanOne;
import com.example.springexample.components.BeanTwo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringExampleApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringExampleApplication.class, args);

        String[] beanNames = context.getBeanDefinitionNames();

        System.out.println("Количество бинов =" + beanNames.length);

        for (int i = 0; i < 3; i++) {
            System.out.println(beanNames[i]);
        }

        BeanOne beanOne = context.getBean(BeanOne.class);
        BeanTwo beanTwo = context.getBean(BeanTwo.class);

        beanOne.sayBeanOne();
        beanTwo.sayBeanTwo();
    }
}


