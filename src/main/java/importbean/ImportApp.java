package importbean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import utils.LogUtils;

/**
 * user is lwb
 **/


public class ImportApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext aca =
                new AnnotationConfigApplicationContext("importbean");//指定bean的来源，也就是指定扫描的范围。
        String[] names = aca.getBeanDefinitionNames();
        for (String name : names){
            LogUtils.info(name);
        }

    }
}
