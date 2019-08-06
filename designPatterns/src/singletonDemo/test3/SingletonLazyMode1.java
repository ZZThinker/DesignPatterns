package singletonDemo.test3;

/**
 * Created by qianweijie on 2019/8/5.
 */
public class SingletonLazyMode1 {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println("singleton1:" + singleton1.hashCode());
        System.out.println("singleton2:" + singleton2.hashCode());

        Singleton2 singleton11 = Singleton2.getInstance();
        Singleton2 singleton22 = Singleton2.getInstance();
        System.out.println(singleton11 == singleton22);
        System.out.println("singleton1:" + singleton11.hashCode());
        System.out.println("singleton2:" + singleton22.hashCode());


        Singleton3 singleton111 = Singleton3.getInstance();
        Singleton3 singleton222 = Singleton3.getInstance();
        System.out.println(singleton111 == singleton222);
        System.out.println("singleton1:" + singleton111.hashCode());
        System.out.println("singleton2:" + singleton222.hashCode());
    }

}

/**
 * 懒汉式单例模式（线程不安全）
 */
class Singleton {
    private Singleton(){}

    private static Singleton instance;

    //提供公有的静态方法 使用到该方法时才去创建实例
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}


/**
 * 懒汉式单例模式（线程安全 但是效率很低 每次得到实例对象都要进行同步）
 */
class Singleton2 {
    private Singleton2(){}

    private static Singleton2 instance;

    //提供公有的静态方法 使用到该方法时才去创建实例 加入同步处理，解决线程安全问题
    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}

/**
 * 懒汉式单例模式（线程不安全）
 */
class Singleton3 {
    private Singleton3(){}

    private static Singleton3 instance;

    //提供公有的静态方法 使用到该方法时才去创建实例 对象上加同步锁，线程不安全
    public static Singleton3 getInstance(){
        if(instance == null){
            synchronized (Singleton3.class){
                instance = new Singleton3();
            }
        }
        return instance;
    }

}

