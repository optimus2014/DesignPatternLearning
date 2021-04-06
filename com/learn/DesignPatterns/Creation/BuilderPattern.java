package com.learn.DesignPatterns.Creation;

/**
 * 建造者模式
 * 场景：创建属性较为复杂的类
 * 和工厂模式的区别：工厂模式侧重于创建不同类的对象，建造者侧重创建“一个”复杂类的对象
 * 将对象的构建和属性表达分在不同的类中实现
 * 案例：Flume中创建拦截器使用的就是建设者模式
 *
 * 注：该模式有4个角色
 * - 产品样板，有属性等信息
 * - Builder抽象类或者接口，定义实际创建者需要实现的方法
 * - 实际创建者，继承自Builder，定义各类复杂属性的赋值方法
 * - 指挥者：接受“创建者”对象，定义创建对象的方法及样板
 *
 * 另外：需要客户端通过指挥者，获取符合指定属性的对象。
 */
public class BuilderPattern {
    public static void main(String[] args) {
    Director d = new Director(new ConcreateBuilder());
    BuilderProduct bp = d
            .buildA()
            .construct();
    bp.showName();
    d.buildB().construct().showName();
    d.buildC().construct().showName();

    }
}

/**
 * 建设者模式需要创建的“产品”
 */
class BuilderProduct{
    private String name;
    public void setName(String name){
        this.name = name;
    }
    public void showName(){
        System.out.println("对象名称是：" + this.name);
    }
}

/**
 * 指挥者：负责整个对象创建过程的指挥工作
 */
class Director{
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    protected Director buildA(){
        this.builder.buildName("AAA");
        return this;
    }
    // 返回本对象，可以使用类似于函数式编程方法，依次处理。
    protected Director buildB(){
        this.builder.buildName("BBB");
        return this;
    }
    protected Director buildC(){
        this.builder.buildName("CCC");
        return this;
    }

    public BuilderProduct construct(){
        return builder.getProduct();
    }
}

/**
 * builder 抽象类，定义创建
 */
abstract class Builder{
    // 关键步骤
    protected BuilderProduct product = new BuilderProduct();

    abstract void buildName(String name);

    // 返回产品
    public BuilderProduct getProduct(){
        return this.product;
    }
}

/**
 * 实际建设者
 */
class ConcreateBuilder extends Builder{
    // 复写抽象方法
    @Override
    void buildName(String name) {
        System.out.println("开始给对象赋值：");
        this.product.setName(name);
    }

}