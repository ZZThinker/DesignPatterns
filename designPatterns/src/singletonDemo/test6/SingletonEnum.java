package singletonDemo.test6;

/**
 * Created by qianweijie on 2019/8/5.
 */
public class SingletonEnum {

    public static void main(String[] args) {

        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        System.out.println(singleton1 == singleton2);
        System.out.println("singleton1:"+singleton1.hashCode());
        System.out.println("singleton2:"+singleton2.hashCode());

        singleton1.sayYes();
    }
}


/**
 * 枚举实现单例模式 线程安全 可防止反序列化重新生成新的实例
 */
enum Singleton{
    INSTANCE;

    public void sayYes(){
        System.out.println("No!");
    }
}
