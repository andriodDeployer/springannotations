package factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * user is lwb
 **/


public class MoneyFactoryBean implements FactoryBean<MoneyFactoryBean.Money> {

    public MoneyFactoryBean() {
        System.out.println("创建Factory");
    }

    public Money getObject() throws Exception {
        return new Money();
    }

    public Class<?> getObjectType() {
        return Money.class;//返回bean的类型
    }

    public boolean isSingleton() {
        return true;//创建的bean是否是单例的。
    }


    protected class Money{
        public Money() {
            System.out.println("创建money");
        }
    }

}
