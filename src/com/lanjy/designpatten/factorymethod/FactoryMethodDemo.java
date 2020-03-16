package com.lanjy.designpatten.factorymethod;



/**
 * 工厂方法模式（FACTORY METHOD）是一种常用的类创建型设计模式,
 * 此模式的核心精神是封装类中变化的部分，
 * 提取其中个性化善变的部分为独立类，
 * 通过依赖注入以达到解耦、复用和方便后期维护拓展的目的。
 * 它的核心结构有四个角色，
 * 分别是抽象工厂；具体工厂；抽象产品；具体产品
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        BankEnginee instance = BankEnginee.getInstance(WeChatBank.class);
        instance.bankGatePay("111111");
    }

}



/**
 * 简单工厂--用于创建不同类型的第三方支付实例
 * 1 它是一个具体的类，非接口 抽象类。
 */
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


abstract class BankEnginee implements IBank{
    //通过反射技术获取实例
    public static <T extends BankEnginee> T getInstance(Class<WeChatBank> clz) {
        T result = null;
        try {
            result = (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("实例化对象出错");
        }
        return result;
    }
}


