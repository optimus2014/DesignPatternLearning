package com.learn.DesignPatterns.Behavioral;

/**
 * 责任链模式：
 * 链状的行为逻辑，每个角色只关注前一个和后一个角色。
 *
 * 职责链模式主要包含以下角色。
 * 抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 * 具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者。
 * 客户类（Client）角色：创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程。
 */
public class ChainPattern {
    public static void main(String[] args) {
        System.out.println("这是责任链模式。");
        ChainHandler role1 = new ConcreteHandler1();
        ChainHandler role2 = new ConcreteHandler2();
        role1.setNext(role2);
        role1.request("3");
    }
}


// Handler:定义角色规范，使用抽象类或者接口的方式（因为有公共方法，暂时使用抽象类）
abstract class ChainHandler{
    ChainHandler next = null;  // 设置默认值
    public void setNext(ChainHandler next){
        this.next = next;
    }
    public ChainHandler getNext(){
        return  this.next;
    }

    // 实际的执行函数
    public abstract void request(String msg);
}

// ConcreteHandler1：实际角色类型
class ConcreteHandler1 extends ChainHandler{

    @Override
    public void request(String msg) {
        if(msg.equals("1")){
            System.out.println("角色1执行了该任务。");
        } else {
            System.out.println("角色1没有权限审批。");
            if (this.next == null){
                System.out.println("没有人可以执行该任务。");
            } else {
                System.out.println("传递给下一个角色。");
                this.next.request(msg);
            }
        }
    }
}


// ConcreteHandler2
class ConcreteHandler2 extends ChainHandler{

    @Override
    public void request(String msg) {
        if(msg.equals("2")){
            System.out.println("角色2执行了该任务。");
        } else {
            System.out.println("角色2没有权限审批。");
            if (this.next == null){
                System.out.println("没有人可以执行该任务。");
            } else {
                System.out.println("传递给下一个角色。");
                this.next.request(msg);
            }
        }
    }
}
