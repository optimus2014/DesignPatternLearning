package com.learn.DesignPatterns.Structural;

/***
 * 桥接模式
 * 用来拼接多个维度属性的对象
 *
 * 将抽象部分与它的实现部分分离，使它们都可以独立地变化。它是一种对象结构型模式，又称为柄体(Handle and Body)模式或接口(Interface)模式。
 *
 * 核心思想：维护两套集成关系，一套用接口实现的方法，一套用抽象类继承的方法。
 */
public class BridgePattern {
    public static void main(String[] args) {
        System.out.println("桥接模式展示中");
        AbstractionOperation rb = new RefinedBridgeOperator(new BridgeImpleA());
        rb.Operation();
    }
}

interface BridgeInterface{
    void opearte();
}

class BridgeImpleA implements BridgeInterface{

    @Override
    public void opearte() {
        System.out.println("桥接模式方法A实现了");
    }
}




abstract class AbstractionOperation{
    BridgeInterface impl;
    protected AbstractionOperation(BridgeInterface impl){
        this.impl = impl;
    }
    protected abstract void Operation();
}

class RefinedBridgeOperator extends AbstractionOperation{

    protected RefinedBridgeOperator(BridgeInterface impl){
        super(impl);
    }
    @Override
    protected void Operation() {
        System.out.println("扩展抽象化(Refined Abstraction)角色被访问");
        this.impl.opearte();
    }
}