package factoryBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import utils.LogUtils;

/**
 * user is lwb
 **/


public class FactoryBeanApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext aca =
                new AnnotationConfigApplicationContext("factoryBean");
        String[] names = aca.getBeanDefinitionNames();
        for (String name: names) {
            LogUtils.info(name);
        }

        Object money = aca.getBean("moneyFactoryBean");
        Object money1 = aca.getBean("moneyFactoryBean");
        LogUtils.info("moneyFactory的类型：{}",money.getClass().toString());
        LogUtils.info("是否是单例：{}",(money == money1)+"");

        Object factory = aca.getBean("&moneyFactoryBean");
        Object factory1 = aca.getBean("&moneyFactoryBean");
        System.out.println(factory == factory1);

    }
}
