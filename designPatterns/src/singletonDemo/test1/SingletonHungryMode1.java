package singletonDemo.test1;

class SingletonHungryMode1 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println("singleton1:"+singleton1.hashCode());
        System.out.println("singleton2:"+singleton2.hashCode());
    }
}

/**
 * 饿汉式 静态常量
 * 优点：简单，类加载时实例化对象，类加载机制避免了线程同步问题
 * 缺点：非懒加载，未使用到此对象时浪费内存
 */
class Singleton {
    //私有化构造函数（防止new）
    private Singleton() {
    }

    //本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    //提供公有静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}
