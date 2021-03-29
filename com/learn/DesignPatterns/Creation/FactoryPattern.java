package com.learn.DesignPatterns.Creation;

/**
 * 工厂模式：创建型模式
 * 简单工厂模式
 * 工厂方法模式
 * 抽象工厂模式
 */
public class FactoryPattern {
    public static void main(String[] args) {
        // 简单工厂模式
        System.out.println("开始展示简易工厂模式");
        Product A = SimpleFactory.getProjuct("A");
        Product B = SimpleFactory.getProjuct("B");
        A.showName();
        B.showName();

        // 工厂方法模式
        System.out.println("开始展示工厂方法模式");
        Factory Af = new FactoryA();
        Product Ap = Af.createProjuct();
        Ap.showName();
        Factory Bf = new FactoryB();
        Product Bp = Bf.createProjuct();
        Bp.showName();


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
 * 定义商品interface，根据传参的不同，返回不同的对象
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


/**
 * 工厂方法模式
 * 定义工厂的接口(抽象类)
 * 将用户和商品隔离开，商品的创建逻辑完全交给工厂方法
 */
interface Factory{
    // 创建工厂的方法
    Product createProjuct();
}

class FactoryA implements Factory{
    // 固定工厂类只能返回确定的商品，在工厂层面将使用者和商品进行了隔离。
    public Product createProjuct() {
        return new ProductA();
    }
}

class FactoryB implements Factory{
    public Product createProjuct() {
        return new ProductB();
    }
}

interface Product1{
    void showInfo();
}
class Product1_1 implements Product1{
    public void showInfo() {
        System.out.println("这是Product1-1");
    }
}
/**
 * 抽象工厂模式
 * 和工厂方法模式的不同点是一个工厂里面可以创建多种类型的商品。
 * 也可以生产多个层级的商品。
 */
interface AbstractFactory{
    Product createProduct();
    Product1 createProduct1();
}