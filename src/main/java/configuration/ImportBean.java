package configuration;/**
 * Created by lwb on 2020/2/4.
 */

/**
 * user is lwb
 **/


public class ImportBean {

    static {
        System.out.println("static 代码块");
    }

    public ImportBean(){
        System.out.println("init 代码块");
    }
}
