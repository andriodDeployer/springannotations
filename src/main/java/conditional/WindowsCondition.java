package conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * user is lwb
 **/


public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //获取beandefineRegistry
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        int beanDefinitionCount = registry.getBeanDefinitionCount();
        Environment env = conditionContext.getEnvironment();
        String property = env.getProperty("os.name");
        System.out.println(property);
        return property.contains("Windows");
    }
}
