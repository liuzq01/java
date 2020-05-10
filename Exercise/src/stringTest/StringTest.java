package stringTest;

import org.junit.Test;

public class StringTest
{
    @Test
    public void test1()
    {
        String s1 = "abc";        //"abc" 存储在方法区的常量池中，仅有一份
        String s2 = "abc";
        String s3 = new String("abc");        //new String("abc")存储在堆中
        String s4 = new String("abc");
        System.out.println(s1 == s2);         //true
        System.out.println(s3 == s4);         //false
    }

    @Test
    public void test2()
    {
        Person a = new Person("liu", 1);
        Person b = new Person("liu", 2);
        System.out.println(a == b);       //false
        System.out.println(a.name.equals(b.name));      //true
        System.out.println(a.name == b.name);     //true  存储在常量池中
    }

    @Test
    public void test3()
    {
        String s1 = "ab";
        String s2 = "cd";
        String s3 = "abcd";
        String s4 = "ab" + "cd";
        String s5 = s1 + "cd";
        String s6 = s1 + s2;
        System.out.println(s3 == s4);     //true  存储在常量池中
        System.out.println(s3 == s5);     //false 有变量s1参与，存储在堆中
        System.out.println(s3 == s6);     //false 存储在堆中

    }

    @Test
    public void test4()
    {
        String s = "Hello World  ";
        String ss = "Hello world  ";
        System.out.println(s.length());
        System.out.println(s.charAt(4));
        System.out.println(s.isEmpty());
        System.out.println(s.toLowerCase());    //s本身没变
        System.out.println(s.toUpperCase());
        System.out.println("---" + s.trim() + "---");
        System.out.println(s.equals(ss));
        System.out.println(s.equalsIgnoreCase(ss));
        System.out.println(s.compareTo(ss));
        System.out.println(s.substring(6, 11));
        System.out.println(s.endsWith("d"));
        System.out.println(s.endsWith("d  "));
        System.out.println(s.startsWith("he"));
        System.out.println(s.startsWith("He"));
        System.out.println(s.contains("or"));
        System.out.println(s.indexOf("ll", 1));
        System.out.println(s.lastIndexOf("ll", 10));
        System.out.println(s.replace("ll", "r"));
    }

    @Test
    public void test5()
    {
        String str = "hello2333World";
        System.out.println(str.replaceAll("\\d+", ","));    //正则表达式

    }
}
