package componentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * user is lwb
 **/

@Configuration
@ComponentScan(value = "componentscan")
public class ComponentScanApp {

    public static void main(String[] args) {

        ApplicationContext ioc =
                new AnnotationConfigApplicationContext(ComponentScanApp.class);

        String[] definitionNames = ioc.getBeanDefinitionNames();
        for(String name : definitionNames){
            System.out.println(name);
        }
    }


    @Bean(name = "dept")
    public Dept getDept(){
        return new Dept();
    }

    @Bean
    public Dept getDept1(){
        return new Dept();
    }
}
