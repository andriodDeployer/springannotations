package configuration;/**
 * Created by lwb on 2020/1/30.
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * user is lwb
 **/

@Configuration
@Import(ImportBean.class)
public class BeanConfig {

    @Bean
    public JButton anotherButton(@Qualifier("icon2") Icon icon1) throws MalformedURLException {
        System.out.println("接受到的icon是   "+icon1.hashCode());
        Icon icon = icon2();
        System.out.println("icon is "+ icon.hashCode());
        return new JButton(icon);
    }

    @Bean(name = "icon5")
    @Primary //当使用autowired通过类型获取bean时候，如果容器中存在多个相同类型的bean时，可以通过@primary来表示某个bean的优先级最高。但是常用的方式是，在@bean指定一个name。Autowird时，从这里获取即可。
    public Icon icon1() throws MalformedURLException {
        URL url = new URL(
                "http://morevaadin.com/assets/images/learning_vaadin_cover.png");
        return new ImageIcon(url);
    }

    @Bean
    public Icon icon2() throws MalformedURLException {
        URL url = new URL(
                "http://morevaadin.com/assets/images/learning_vaadin_cover.png");
        return new ImageIcon(url);
    }

}
