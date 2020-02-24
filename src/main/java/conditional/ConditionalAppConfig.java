package conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import utils.LogUtils;

/**
 * user is
 **/

@Configuration
public class ConditionalAppConfig {


    @Bean(name = "linus")
    @Conditional(LinuxCondition.class)
    public Person linuxPerson(){
        LogUtils.info("创建linus");
        return new Person("linus",50);
    }


    @Bean(name = "bili")
    @Conditional(WindowsCondition.class)
    public Person windowPerson(){
        LogUtils.info("创建bili");
        return new Person("bile gates",60);
    }
}
