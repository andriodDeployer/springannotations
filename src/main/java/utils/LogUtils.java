package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * user is
 **/


public class LogUtils {

    private static Logger infoLogger = LoggerFactory.getLogger("info");

    private static Logger errorLogger = LoggerFactory.getLogger("error");


    public static void info(String msg,String ...args){
        infoLogger.info(msg,args);
    }

    public static void error(String msg){
        errorLogger.error(msg);
    }

}
