package factoryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * user is
 **/

@Configuration
public class FactoryBeanConfig {

    //容器中会有一个MoneyFactoryBean类型的Bean和MoneyFactoryBean的BeanDefinition.
    //至于这个bean是否立即创建，就要取决于是否懒加载，以及作用域了
    @Bean(value = "moneyFactoryBean")
   // @Lazy
   // @Scope("prototype")
    public MoneyFactoryBean getFactoryBean(){
        return new MoneyFactoryBean();
    }
}
