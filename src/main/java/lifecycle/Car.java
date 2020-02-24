package lifecycle;

/**
 * user is lwb
 **/


public class Car {
    private String name;

    public Car() {
        System.out.println("创建Car.....");
    }


    public void init(){
        System.out.println("初始化Car....");
    }

    public void destroy(){
        System.out.println("销毁Car....");
    }
}
