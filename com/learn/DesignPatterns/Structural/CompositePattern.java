package com.learn.DesignPatterns.Structural;

import java.util.HashMap;

/**
 * 组合模式
 * 定义：用来表示“整体-部分”的关系。
 * 组合模式一般用来描述整体与部分的关系，它将对象组织到树形结构中，顶层的节点被称为根节点，根节点下面可以包含树枝节点和叶子节点，树枝节点下面又可以包含树枝节点和叶子节点。
 *
 * 样例：树枝、树叶
 * 树枝和树叶有相同的操作逻辑，对客户端来说是透明的，但是树枝可以添加{树枝、树叶}，树叶不能添加。
 *
 * 主要分位：
 * 1.透明组合模式：叶子节点也保留add(),remove()等节点，但是没有操作。这种方法不安全，直接忽略。
 * 2.安全组合模式：只在树枝节点保留添加、删除操作，叶子中只保留操作函数。
 */
public class CompositePattern {
    public static void main(String[] args) {
        System.out.println("这是组合模式");
        Branch branch1 = new Branch("根节点");
        Branch branch2 = new Branch("树枝节点");
        Composite leaf1 = new Leaf("叶子节点1");
        Composite leaf2 = new Leaf("叶子节点2");
        branch1.add(branch2);
        branch1.add(leaf1);
        branch2.add(leaf2);
        branch1.run();
//        branch2.run();
//        leaf1.run();
//        leaf2.run();
        branch1.showChildren();
        branch1.remove(branch2);
        branch1.showChildren();
        branch1.getChild("叶子节点3");
    }
}

// 定义组合中的标准操作方法
interface Composite{
    String getName();
    public void run();
}

// 叶子节点
class Leaf implements Composite{
    private String name;
    public Leaf(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        System.out.printf("这是一个叶子节点，名称：%s\n" , this.name);
    }
}

// 树枝节点
class Branch implements Composite{

    private String name;
    private HashMap<String, Composite> children = new HashMap<String, Composite>();
    public Branch(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.printf("这是一个树枝节点，名称：%s\n" , this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void add(Composite item){
        this.children.put(item.getName(),item);
    }

    public void remove(Composite item){
        this.children.remove(item.getName());
        System.out.printf("当前节点已删除'%s'子节点\n" , name);
    }

    public Composite getChild(String name) {
        if(!this.children.containsKey(name)){
            System.out.printf("当前节点不包含该子节点%s：\n" , name);
            return null;
        }
        return this.children.get(name);
    }

    public void showChildren(){
        System.out.printf("展示%s的分支节点：\n" , this.name);
        for (Composite child: this.children.values()){
            child.run();
        }
    }
}