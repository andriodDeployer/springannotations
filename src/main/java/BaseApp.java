import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * user is lwb
 **/


public class BaseApp {
    public AnnotationConfigApplicationContext aca;
    public BaseApp(AnnotationConfigApplicationContext aca) {
        this.aca = aca;
    }
}
