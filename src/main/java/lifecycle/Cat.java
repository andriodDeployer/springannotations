package lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * user is
 **/

public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("创建Cat.....");
    }

    public void destroy() throws Exception {
        System.out.println("销毁 cat.....");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化 cat.....");
    }

    public void init(){
        System.out.println("init .....");
    }

    public void destory(){
        System.out.println("destroy ......");
    }
}
