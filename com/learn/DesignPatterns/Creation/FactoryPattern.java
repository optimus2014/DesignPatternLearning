package com.learn.DesignPatterns.Creation;

/**
 * 工厂模式：创建型模式
 * 简单工厂模式
 * 工厂方法模式
 * 抽象工厂模式
 */
public class FactoryPattern {
    public static void main(String[] args) {
        System.out.println("开始展示简易工厂模式");
        Product A = SimpleFactory.getProjuct("A");
        Product B = SimpleFactory.getProjuct("B");
        A.showName();
        B.showName();
    }
}


interface Product{
    public void showName();
}

class ProductA implements Product{
    public void showName() {
        System.out.println("这是一个A产品.");
    }
}

class ProductB implements Product{
    public void showName() {
        System.out.println("这是一个B产品.");
    }
}

/**
 * 简易工厂方法
 */
class SimpleFactory{
    // 使用简单的if else进行匹配，关联生成不同的对象。
    static Product getProjuct(String type){
        if (type.equals("A")){
            return new ProductA();
        } else {
            return new ProductB();
        }
    }
}