/**

    AnnotationApplicationContext和XmlApplicationContext这两个上下文，是spring中功能相同的上下文，
 都是实现将bean加载到容器中，只不过实现的方式不同。
 1.两者的 resource 来源不同(或者说两者的解析协议不同)，xmlApplicationContext的bean来自配置文件，根据不同的xmlApplicationContext的实现
    从不同的位置去加载配置文件，这些位置的差异，被srping封装成resource，进行屏蔽。
    按照指定的约定/协议，去解析指定的标签(这些特定的标签就是spring内核和配置文件编写者之间的约定，或者说这些标签就是spring中xml的协议)
    annotationApplicationContext的bean的数据来源，这是classpath或者某些外部jar中的class，通过扫描
    这些指定位置的类，然后解析这些类或者方法上的 annotation (这些annotation可以理解成spring在注解方面的协议，不同的注解有不同的含义，开发者需要遵守，
    这也是开发者和spring之间的协议)。对这些注解怎么处理，spring内部已经做了解析，而我们开发者只需要，了解这些注解的作用以及原理
    在满足规范的基础上进行开发即可。

 2.两者都是某个协议的实现着。


 bean的作用域：
    默认情况下spring创建的bean都是单例的，那么他的作用域就是这个ioc容器，他的生命周期通产和ioc容器是一样的，除非中途把这个bean卸载。
    对于单例的bean，在容器启动的时候会根据容器中所有的beandefinition自动创建出bean，属于early类型，可以使用@Lazy设置成懒加载，只有当用到这个bean时候，才会创建这个bean，然后放到容器中。
    无论是early还是lazy,不会影响这个bean的生命周期和作用域。

    而对于scope为prototype的bean，因为他没有放到ioc容器中，所以他的作用域和生命周期和ioc没有太大关系。只有用到这个bean的时候，他就会创建一个新的bean。
    所以scope为prototype的bean，一定是懒加载的。他不可能是early的。



 向容器中导入一个bean的方式：
    1.添加spring约定的注解(@Service,@Controller等)，然后用把这些类放到可以扫描到的包中。通常适用于与我们自己写的类。
    2.使用@Bean的方式，在一个方法上添加一个@Bean在方法体内，创建出这个bean，通常使用于，我们无法修改的类第三方类。
    3.使用@Import
        1.直接导入一个类，因为这个注解没有指定bean id的地方，默认的bean id就是这个类的全类名。
        2.导入一个实现了ImportSelector接口的类，通过实现selectImports方法来指定要导入类的集合。
        3.导入一个BeanDefination


 按照一定的条件将 某些类放到 ioc容器中：
    通常情况下@Bean标注的方法，会将返回值类型的一个bean放到ioc中，如果我们有一个需求：即使标注了@Bean，也不要将这个
    bean放进去，而是将满足了一定的条件后，在放进去。这个条件的定义，使用注解@Conditional(Condition.class)
    条件逻辑的定义体现在Condition的实现类中，


 BeanDefinition是一个bean的定义，就是一个bean的属性的一个集合体。通常来说beanDefinition的类型，就是创建bean的类型。
 因为默认情况下，会在容器中通过调用BeanDefinition中指定的class的无参构造方法创建bean。
 但是对于FactoryBean这种类型的bean，有一些特殊，这类bean的beanDefinition和bean的类型是不同的。
 对于FactoryBean，在容器中是这样存放的：factorybeanname对应的bean是getObject对应的bean。而&factorybeanname对应的才是factoryBean的Bean。
 因为要想调用getObject必要要有这个实例才行啊。有一点需要注意，如果FactoryBean的scope是prototype的话，factorybean和getObejct的返回的Bean都不会放进容器。


 bean的生命周期方法:
    1.使用initmethod和destroyMethod方法：
        在beandefinition中有两个属性 initmethod和destroymethod，可以在@bean注解中指定，这两个方法
        分别在bean创建成功后调用，和aplicationContext关闭后调用，这种情况主要对于单例bean情况，而对于多利的bean，由于这些bean不受ioc的管理。
        也就是bean不会放到ioc中，所以ioc上下文销毁的时候，不会执行destory方法。
    2.让一个类实现 实现 InitializingBean 和 DisposableBean 接口，因为在创建bean的时候，会对这两种bean进行特殊处理，分别执行 afterProperties 和 destroy方法。
    3.使用 @postConstrctor 和 @preDestroy 注解。这个注解是java规范中提供的，提供了对应的语义，spring对其进行了解析，并进行了实现。
    4.beanPostProcessor bean的后置处理，在bean进行初始化前后执行的一个自定义逻辑。其实就是一个监听器。
       beanPostProcessor的作用在于在bean初始化前后分别执行容器中所有的beanPostProcessor的 postProcessBeforeInitialization 和 postProcessAfterInitialization 方法(每个bean都会执行所有processor的这两个方法)。
       具体执行次序
                    0.创建bean对象。
                    1.populateBean(完成对属性值得设置(配置文件中property的处理，@Autowired,@Value的处理，@Autowired和@Value是通过AutowiredInitBeanPostProcessor完成解析的))
                    1.5：awarmethod方法的调用，主要想bean中增加一些 awar内容。
                    2.普通的beanPostProcessor的before执行。
                    3.InitlizingBean的处理，也就是afterPropertiesSet方法调用。
                    4.init-method方法调用。





 3.annotation比xml晚一些，annotation的支持的协议和功能基本上和xml相同。一些关键字都一样。




 *
 *
 */
package annotation;
