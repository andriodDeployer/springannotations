package lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import utils.LogUtils;

/**
 * user is lwb
 **/

public class CatBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof Cat){
            LogUtils.info("postProcessBeforeInitialization Cat  ..............");
        }
        return bean;
    }
}
