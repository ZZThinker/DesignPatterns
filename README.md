# 设计模式

8种方式：
1、饿汉模式（静态常量）
2、饿汉模式（静态代码块）
3、懒汉模式（线程不安全）
4、懒汉模式（线程安全，同步方法，效率低下）
5、懒汉模式（非线程安全，同步代码块）
6、双重检查
7、静态内部类
8、枚举


##### ==1、饿汉模式（静态常量）==
```
public class SingletonHungryMode1 {
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
```
##### ==2、饿汉模式（静态代码块）==
```
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
```
##### 3、懒汉模式（线程不安全）
```
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
```
##### 4、懒汉模式（线程安全，同步方法，效率低下）
```
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
```
 ##### 5、懒汉模式（非线程安全，同步代码块）
```

/**
 * 懒汉式单例模式（同步代码块,线程不安全）
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
```
 ##### ==6、双重检查==
```
private Singleton(){}

    //volatile 修改的对象立即变更到公共堆栈，防止指令重排
    private static volatile Singleton instance;

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
```
##### ==7、静态内部类==
```
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
```
##### ==8、枚举==
```
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
```
