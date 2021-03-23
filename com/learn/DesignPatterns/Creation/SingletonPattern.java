package com.learn.DesignPatterns.Creation;

/**
 * 单例模式：
 * 属于创建型模式，分为懒汉式和饿汉式方法
 * 其中懒汉式是在调用类是实例化对象，饿汉式是在JVM加载类是实例化对象
 */
public class SingletonPattern {
    public static void main(String[] args) {
        System.out.println("运行懒汉式单例模式");
        LazySingleton ls = LazySingleton.getObject();
        ls.showScore();
        ls.addSore();
        ls.addSore();
        ls.showScore();

        LazySingleton ls1 = LazySingleton.getObject();
        ls1.showScore();
        ls1.addSore();
        ls1.showScore();

        System.out.println("运行饿汉式单例模式.");
        EagerSingleton es = EagerSingleton.getObject();
        es.showScore();
        es.addSore();
        es.addSore();
        es.showScore();

        EagerSingleton es1 = EagerSingleton.getObject();
        es1.showScore();
        es1.addSore();
        es1.showScore();
    }


}

class LazySingleton{
    private static LazySingleton ob = null;
    private Integer score = 0;
    private LazySingleton(){}

    public static LazySingleton getObject(){
        if (ob == null){
            ob = new LazySingleton();
        }
        return ob;
    }

    public void showScore(){
        System.out.println("当前得分:" + ob.score);
    }

    public void addSore(){
        ob.score ++;
    }
}

class EagerSingleton{
    private static EagerSingleton ob = new EagerSingleton();
    private Integer score = 0;
    private EagerSingleton(){}

    public static EagerSingleton getObject(){
        return ob;
    }

    public void showScore(){
        System.out.println("当前得分:" + ob.score);
    }

    public void addSore(){
        ob.score ++;
    }
}
