package importbean.registry;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import utils.LogUtils;

/**
 * user is lwb
 **/


public class ImportBeanDefinationRegisterBean implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {

        //importingClassMetadata是ImportApp的AnnotationMetadata。
        //register是一个接口他的实现类是一个applicationContext，可以向applicatonContxt中添加bean定义。
        //LogUtils.info(importingClassMetadata.toString());
        //LogUtils.info(registry.toString());

        BeanDefinition beanDefinition = new RootBeanDefinition(Rainball.class);
        //beanDefinition.setScope("prototype");//如果不设置的话，那么在容器启动后，会将容器中所有的definition对应的bean创建出来，如果设置了scope为prototype的话，调用的时候创建。
        beanDefinition.setLazyInit(true);//是否懒加载
        registry.registerBeanDefinition("rainball",beanDefinition);
        LogUtils.info("register beandefination {} ","rainball");
    }
}
