package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * user is lwb
 **/


public class Dog {

    public Dog(){
        System.out.println("创建Dog....");
    }


    @PostConstruct
    public void dog(){
        System.out.println("postConstruction....");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("predestroy......");
    }

}
