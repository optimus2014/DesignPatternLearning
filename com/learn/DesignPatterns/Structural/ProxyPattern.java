package com.learn.DesignPatterns.Structural;

/**
 * 代理模式，结构型模式之一
 * 代理模式包含：代理接口，代理类，实际执行类三个部分组成。
 * 难点：动态代理模式
 *
 * 根据代理的创建时期，代理模式分为静态代理和动态代理。
 * 静态：由程序员创建代理类或特定工具自动生成源代码再对其编译，在程序运行前代理类的 .class 文件就已经存在了。
 * 动态：在程序运行时，运用反射机制动态创建而成
 */
public class ProxyPattern {
    public static void main(String[] args) {
        System.out.println("展示代理模式");
        ProxyInterface p = new Proxy();
        p.run();
    }
}

/**
 * 代理接口
 */
interface ProxyInterface{
    // 定义可执行方法，用于约束代理类和实际可执行类
    void run();
}

/**
 * 代理类
 */
class Proxy implements ProxyInterface{
    private RealSubject realSub;

    public void run() {
        if (realSub == null){
            this.realSub = new RealSubject();
        }
        // 代理类夹带私活
        this.preRequest();
        this.realSub.run();
    }

    private void preRequest(){
        System.out.println("实际类执行之前，执行的方法");
    }
}

/**
 * 实际执行类
 */

class RealSubject implements ProxyInterface{

    public void run() {
        System.out.println("实际执行类，开始执行……");
    }
}
/**
 *动态代理模式：
 * 利用Java反射机制
 * TODO
 */