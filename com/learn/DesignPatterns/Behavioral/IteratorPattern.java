package com.learn.DesignPatterns.Behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式：
 * 链式集合内部，封装对象的具体内容，非显示的遍历整个对象
 *
 * 日常开发中，基本不会用到迭代器模式，编程语言中的集合都会实现迭代器接口
 */
public class IteratorPattern {
    public static void main(String[] args) {
        System.out.println("开始迭代器模式");
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("张三");
        System.out.print("当前迭代器版本号：" + aggregate.getIterator().getVersion() + "\n");
        aggregate.add("李四");
        System.out.print("当前迭代器版本号：" + aggregate.getIterator().getVersion() + "\n");
        aggregate.add("王五");
        System.out.print("当前迭代器版本号：" + aggregate.getIterator().getVersion() + "\n");
        aggregate.add("赵六");
        System.out.print("当前迭代器版本号：" + aggregate.getIterator().getVersion() + "\n");
        Iterator it = aggregate.getIterator();
        while(it.hasNext()){
            Object ob = it.next();
            System.out.print(ob.toString()  +"|版本号：" + it.getVersion() + "\n");
        }

        // 版本号
        Object ob = it.first();
        System.out.println("\nFirst：" + ob.toString() +"|版本号：" + it.getVersion());
        System.out.print(it.next().toString()  +"|版本号：" + it.getVersion() + "\n");

        aggregate.remove("李四");
        aggregate.add("孙七");
        System.out.print(aggregate.getIterator().next().toString()  +"|版本号：" + aggregate.getIterator().getVersion() + "\n");
    }
}
// 抽象集合接口
abstract class Aggregate{
    // 集合添加元素
    abstract void add(Object object);
    // 集合删除元素
    abstract void remove(Object object);

    protected Iterator iterator;
    //当前版本对象更新版本
    private int version = 0;
    int getVersion(){
        return this.version;
    }
    int updateVersion(){
        this.version += 1;
        return this.version;
    }
    // 获取迭代器
    abstract Iterator getIterator();

}

// 具体的集合
class ConcreteAggregate extends Aggregate{

    private List<Object> list = new ArrayList<Object>();

    @Override
    public void add(Object object) {
        this.list.add(object);
        this.updateVersion();
    }

    @Override
    public void remove(Object object) {
        this.list.remove(object);
        this.updateVersion();
    }

    @Override
    public Iterator getIterator() {
        // 保持预先获取迭代器，并保持版本更新后，重新获取
        if (this.iterator == null || this.getVersion() != this.iterator.getVersion()) {
            // 更新迭代器
            this.iterator = new ConcreteIterator(this.list);
            // 更新迭代器版本号
            this.iterator.setVersion(this.getVersion());

        }
        return this.iterator;
    }
}

// 定义迭代器规范
interface Iterator {
    // 迭代器第一个元素
    Object first();
    // 获取当前位置的下一个元素
    Object next();
    // 当前位置是否有下一个元素
    boolean hasNext();
    // 设置迭代器当前版本号
    int getVersion();
    void setVersion(int version);
}


// 具体迭代器
class ConcreteIterator implements Iterator{
    private int version = 0;
    private List<Object> list;
    private int index = -1;
    public ConcreteIterator(List<Object> list){
        System.out.println("创建迭代器");
        this.list = list;
    }

    @Override
    public int getVersion(){
        return this.version;
    }

    @Override
    public void setVersion(int version){
        this.version = version;
    }

    @Override
    public Object first() {
        this.index = 0;
        Object object = this.list.get(this.index);
        return object;
    }

    @Override
    public Object next() {
        Object object = null;
        if(this.hasNext()){
            this.index += 1;
            object = this.list.get(this.index);
        }
        return object;
    }

    @Override
    public boolean hasNext() {
        if(this.index >= this.list.size() - 1){
            return false;
        } else {
            return true;
        }
    }
}