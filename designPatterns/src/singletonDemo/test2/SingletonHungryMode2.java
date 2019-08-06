package singletonDemo.test2;

/**
 * Created by qianweijie on 2019/8/5.
 */
public class SingletonHungryMode2 {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println("singleton1:"+singleton1.hashCode());
        System.out.println("singleton2:"+singleton2.hashCode());
    }
}

/**
 * 饿汉式单例模式 静态代码块
 * 优点：简单，类加载时实例化对象，类加载机制避免了线程同步问题
 * 缺点：非懒加载，未使用到此对象时浪费内存
 */
class Singleton{
    //构造器私有化
    private Singleton(){}

    //类内部创建对象实例
    private static Singleton instance ;

    //静态代码块，在类加载时就执行，初始化类实例
    static {
        instance = new Singleton();
    }

    //提供公有的静态方法 返回对象实例
    public static Singleton getInstance(){
        return instance;
    }

}
