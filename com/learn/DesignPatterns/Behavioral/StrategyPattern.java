package com.learn.DesignPatterns.Behavioral;

/**
 * 策略模式
 * 相同行为，有多种不同的策略。
 * 角色：
 * 1.策略接口：定义策略行为规范
 * 2.具体策略实现类
 * 3.策略“窗口”：用于提供给客户端，策略的使用方法
 *
 * 策略模式的管理窗口，也可以不用，和工厂模式结合使用。
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.run();

        context.setStrategy(new ConcreteStrategyB());
        context.run();

    }
}

// 定义策略规范
interface Strategy {
    void run();
}




// 策略管理窗口类
class Context{

    // 当前策略
    private Strategy strategy;
    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        this.strategy.run();
    }
}

// 具体策略A
class ConcreteStrategyA implements Strategy{
    public void run() {
        System.out.println("这是策略A的方法");
    }
}

// 具体策略B
class ConcreteStrategyB implements Strategy{
    public void run() {
        System.out.println("这是策略B的方法");
    }
}
