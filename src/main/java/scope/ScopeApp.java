package scope;

import org.springframework.context.annotation.*;
import utils.LogUtils;

/**
 * user is
 **/

@Configuration
public class ScopeApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext aca =
                new AnnotationConfigApplicationContext("scope");

//        Dog dog = (Dog) aca.getBean("dog");
//        Dog dog1 = (Dog) aca.getBean("dog");
//
//        System.out.println(dog == dog1);
        String[] names = aca.getBeanDefinitionNames();
        for (String name: names) {
            LogUtils.info(name);
        }
    }

    //prototype
    @Bean
    @Scope(value = "prototype")
    public Dog dog(){
        LogUtils.info("创建一个dog");
        return new Dog();
    }

    @Bean(value = "dog1")
    @Lazy
    public Dog getDog(){
        LogUtils.info("创建第二个dog");
        return new Dog();
    }



}
