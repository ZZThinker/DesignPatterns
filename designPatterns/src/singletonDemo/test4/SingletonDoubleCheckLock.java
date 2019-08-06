package singletonDemo.test4;

/**
 * Created by qianweijie on 2019/8/5.
 */
public class SingletonDoubleCheckLock {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println("singleton1:"+singleton1.hashCode());
        System.out.println("singleton2:"+singleton2.hashCode());
    }
}

class Singleton{

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



}
