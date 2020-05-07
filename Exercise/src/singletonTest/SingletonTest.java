package singletonTest;

import polymorphism.Test;

public class SingletonTest
{
    //构造器私有化，不允许在类外部创建对象
    private SingletonTest()
    {
    }
    private static SingletonTest sin= new SingletonTest();  //在类内部造一个私有的、唯一的对象
    private static SingletonTest sin1;  //懒汉式
    //在类外部通过公有的方法来获取该对象
    public static synchronized SingletonTest getInstance()
    {
        if (sin1 == null)
        {
            sin1=new SingletonTest();
        }
        return sin1;

    }
}
