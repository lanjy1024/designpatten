package com.lanjy.designpatten.factorymethod;

/**
 * @项目名称：designpatten
 * @包名： com.lanjy.designpatten.factorymethod
 * @类描述：
 * @创建人：lanjy
 * @创建时间：2020/3/16
 */
public class WeChatBank extends BankEnginee{

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
