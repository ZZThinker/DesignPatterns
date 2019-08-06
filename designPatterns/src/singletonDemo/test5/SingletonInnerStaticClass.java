package singletonDemo.test5;

/**
 * Created by qianweijie on 2019/8/5.
 */
public class SingletonInnerStaticClass {


    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println("singleton1:"+singleton1.hashCode());
        System.out.println("singleton2:"+singleton2.hashCode());
    }
}


/**
 * 静态内部类实现单例模式
 * 线程安全 效率高
 */
class Singleton{

    private Singleton(){}

    //静态内部类会在需要其内部对象时初始化；Singleton装载时，静态内部类并不会被加载
    static class SingletonInstance{
        //类的静态属性只会在第一次加载类时初始化 jvm保证了线程的安全
        private final static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }



}
