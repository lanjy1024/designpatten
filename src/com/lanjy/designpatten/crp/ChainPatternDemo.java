package com.lanjy.designpatten.crp;

/**
 * @author：lanjy
 * @date：2020/4/14
 * @description：
 * 责任链模式（Chain of Responsibility Pattern）为请求创建了一个接收者对象的链。
 * 


/**
 * 步骤 1
 * 创建抽象的记录器类。
 */
abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        if(this.level <= level){
            write(message);
        }
        if(nextLogger !=null){
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);

}


/**
 * 步骤 2
 * 创建扩展了该记录器类的实体类。
 */
class InfoLogger extends AbstractLogger {

    public InfoLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("=========InfoLogger Console::Logger: " + message);
    }


    
}



class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("=========ErrorLogger Console::Logger: " + message);
    }
}


class DebugLogger extends AbstractLogger {

    public DebugLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("=========DebugLogger::Logger: " + message);
    }
}


/**
 * 步骤 3
 * 创建不同类型的记录器。赋予它们不同的错误级别，并在每个记录器中设置下一个记录器。每个记录器中的下一个记录器代表的是链的一部分。
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger logger = getChainOfLoggers();

        logger.logMessage(AbstractLogger.INFO, "This is an information.");

//        logger.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");

//        logger.logMessage(AbstractLogger.ERROR,"This is an error information.");
    }

}