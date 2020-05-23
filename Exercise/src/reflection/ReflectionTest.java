package reflection;


import CollectionTest.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class ReflectionTest
{
    //获取Class类的实例
    @Test
    public void test1() throws ClassNotFoundException
    {
        Class aClass = String.class;  //显示赋值

        Class aClass1 = Class.forName("java.lang.String"); //调静态方法

        String str = new String("abc");
        Class aClass2 = str.getClass();     //getClass()方法

        System.out.println(aClass == aClass1);    //true
        System.out.println(aClass == aClass2);    //true
    }

    //反射的动态性，运行时才确定是哪个类
    @Test
    public void test2() throws ClassNotFoundException
    {
        String classpath = "";
        int i = 0;
        for (int j = 0; j < 20; j++)
        {
            i = (int) (Math.random() * 3);
            if (i == 0) classpath = "java.util.Date";
            if (i == 1) classpath = "java.lang.Object";
            if (i == 2) classpath = "java.lang.String";
            Class aClass = Class.forName(classpath);
            System.out.println(aClass);
        }
    }
    //调用运行时类的指定结构
    @Test
    public void test3() throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        //调用、设置属性
        Class<Person> aClass= Person.class;
        Person person = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);       // name是private的,设为可访问的
        name.set(person,"li");
        System.out.println(person);
        //调用、设置方法
        Method subName = aClass.getDeclaredMethod("subName", String.class); //(方法名，形参类)
        subName.setAccessible(true);
        Object str = subName.invoke(person, "zhiQiang");    //（对象，形参）
        System.out.println(str);
    }
}
