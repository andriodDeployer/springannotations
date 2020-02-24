package importbean;

import importbean.beans.Color;
import importbean.registry.ImportBeanDefinationRegisterBean;
import importbean.select.ImportSelectorBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * user is lwb
 **/

@Configuration
@Import({Color.class, ImportSelectorBean.class, ImportBeanDefinationRegisterBean.class,
ImportBeanDefinationRegisterBean.class})
public class ConfigurationBean {


}
