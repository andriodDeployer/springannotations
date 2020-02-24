package lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * user is lwb
 **/


public class LifeCycleApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext aca =
                new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        aca.close();



    }
}
