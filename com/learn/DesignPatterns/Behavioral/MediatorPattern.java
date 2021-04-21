package com.learn.DesignPatterns.Behavioral;

import java.util.HashMap;
import java.util.Map;

/**
 * 中介者模式：
 * MVC框架中，控制器（C）就是模型（M）和视图（V）的中介者；
 * 相当于把不同的角色解耦合，形成星型结构。
 *
 * 主要包含四个角色：
 * 1.抽象中介者
 * 2.具体中介者
 * 3.抽象“同事类”：执行业务操作的角色
 * 4.具体“同事类”
 *
 * 注：
 * 1. 重点是让中介知道自己的用户都是谁，让客户知道自己用的哪家中介
 *
 * TODO:
 * 1. 中介者模式和代理模式的区别
 */
public class MediatorPattern {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague zhangsan = new BuyerColleague("张三",100);
        Colleague lisi = new BuyerColleague("李四",200);
        Colleague wangwu = new BuyerColleague("王五",300);
        Colleague shaobing = new SellerColleague("烧饼店");
        Colleague shuiguo = new SellerColleague("水果店");

        mediator.register(zhangsan);
        mediator.register(lisi);
        mediator.register(wangwu);
        mediator.register(shaobing);
        mediator.register(shuiguo);

        zhangsan.pay("水果店",20);
        zhangsan.pay("烧饼店",40);
        zhangsan.pay("烧饼店",50);
        wangwu.pay("张三",100);
        zhangsan.pay("烧饼店",50);

    }
}

// 写一个商品买卖的中介代理方式（资金流、物流双剑合璧，就是个小蚂蚁，哈哈哈）
// 抽象中介者
interface Mediator{
    // 注册，商家，个人都可以注册为中介(第三方支付)的用户
    void register(Colleague colleague);

    // 转账(买家付钱给卖家)
    void transfer(Colleague buyer,String seller,double price);
}

// 具体中介者（负责转账支付操作，收取佣金）
class ConcreteMediator implements Mediator{
    // 中介者的钱
    private double cash = 0;
    // 手续费
    private double charge = 0.03;
    private Map<String,Colleague> customers = new HashMap<String, Colleague>();

    @Override
    public void register(Colleague colleague) {
        if(!customers.containsKey(colleague.getName())){
            this.customers.put(colleague.getName(),colleague);
            // 告知客户注册完成
            colleague.setMediator(this);
        }
    }

    @Override
    public void transfer(Colleague buyer,String seller,double price) {
        this.cash += price * this.charge;
        Colleague sellerColleague = this.customers.get(seller);
        sellerColleague.withdraw(price - price * this.charge);
        System.out.printf("*******交易完成：中介提供转发服务，收取手续费：%f，中介余额：%f.*******\n\n", price * this.charge,this.cash);
    }
}


// 抽象工作者（生态中的个体）
abstract class Colleague{
    // 账户中的钱
    protected double cash;
    // 工作者名称
    private String name;

    Colleague(String name,double cash){
        this.name = name;
        this.cash = cash;
    }

    // 获取商家名称
    String getName(){
        return this.name;
    }

    // 中介相关
    private Mediator mediator = null;
    void setMediator(Mediator mediator){
        this.mediator = mediator;
    }
    Mediator getMediator(){
        return this.mediator;
    }

    // 付钱
    abstract void pay(String seller,double price);

    // 收钱
    abstract void withdraw(double money);
}

// 具体工作者（买方）
class BuyerColleague extends Colleague{

    BuyerColleague(String name,double cash) {
        super(name,cash);
    }

    @Override
    void pay(String seller, double price) {
        if(this.cash < price){
            System.out.printf("用户-%s余额不足，余额为%f，交易终止。\n" , this.getName(),this.cash);
            return;
        }
        this.cash -= price;
        System.out.printf("%s向%s付款%f元，当前余额为%f。\n" , this.getName(),seller,price,this.cash);
        this.getMediator().transfer(this,seller,price);

    }

    @Override
    void withdraw(double money) {
        this.cash += money;
        System.out.printf("用户-%s，已收到金额：%f,当前账户余额：%f。\n" , this.getName(),money,this.cash);
    }

}

// 具体工作者（卖方）
class SellerColleague extends Colleague{

    public SellerColleague(String name){
        super(name,0);
    }

    @Override
    void pay(String seller, double price) {

    }

    @Override
    void withdraw(double money) {
        this.cash += money;
        System.out.printf("商家-%s，已收到金额：%f,当前账户余额：%f。\n" , super.getName(),money,this.cash);
    }

}

