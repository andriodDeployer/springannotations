package configuration;/**
 * Created by lwb on 2020/1/30.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;

/**
 * user is lwb
 **/


public class Application {

    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
//        Icon icon = (Icon) context.getBean("icon");
//        JButton button = (JButton) context.getBean("anotherButton");
//
//        System.out.println("开始");
//        System.out.println(icon.hashCode());
//        System.out.println(button.getIcon().hashCode());
//        System.out.println("结束");


        ApplicationContext context1 = new AnnotationConfigApplicationContext("configuration");
        Icon icon1 = (Icon) context1.getBean("icon5");
        Icon icon2 = (Icon) context1.getBean("icon2");
        JButton button1 = (JButton) context1.getBean("anotherButton");

        System.out.println("开始1111");
        System.out.println("111  "+icon1.hashCode());
        System.out.println("222  "+icon2.hashCode());
        System.out.println("结束1111");

    }
}
