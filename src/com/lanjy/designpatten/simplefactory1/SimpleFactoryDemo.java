package com.lanjy.designpatten.simplefactory1;

/**
 * 简单工厂模式
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        WeChatBank weChatBank = SimpleBankFactory.getInstance(WeChatBank.class);
        weChatBank.bankGatePay("支付100元");
        weChatBank.bankGateQueryWater("查询交易流水的报文");
    }

}


/**
 * 简单工厂--用于创建不同类型的第三方支付实例
 * 1 它是一个具体的类，非接口 抽象类。
 */
class SimpleBankFactory{

    //通过反射技术获取实例
    public static <T extends IBank> T getInstance(Class<T> clz) {
        T result = null;
        try {
            result = (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例化对象出错");
        }
        return result;
    }
}


/**
 * 第三方支付接口
 * 后续如果添加更多的第三方支付，只需要实现IBank
 */
interface IBank{
    /**
     * 支付
     * @param data
     * @return
     */
    String bankGatePay(String data);

    /**
     * 查询支付流水
     * @param data
     * @return
     */
    String bankGateQueryWater(String data);
}


class WeChatBank implements IBank{

    @Override
    public String bankGatePay(String data) {
        System.out.println("调用了微信支付，报文信息:"+data);
        return "SUCCESS";
    }

    @Override
    public String bankGateQueryWater(String data) {
        System.out.println("调用了微信查询支付流水，报文信息:"+data);
        return "SUCCESS";
    }
}

class Alipay implements IBank{

    @Override
    public String bankGatePay(String data) {
        System.out.println("调用了支付宝支付，报文信息:"+data);
        return "SUCCESS";
    }

    @Override
    public String bankGateQueryWater(String data) {
        System.out.println("调用了支付宝查询支付流水，报文信息:"+data);
        return "SUCCESS";
    }
}