package lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * user is lwb
 **/

@Configuration
public class LifeCycleConfig {

    @Lazy
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Cat cat(){
        return new Cat();
    }

    @Bean
    public Dog dog(){
        return new Dog();
    }

    @Bean
    public CatBeanPostProcessor getprocessor(){
        return new CatBeanPostProcessor();
    }
}
