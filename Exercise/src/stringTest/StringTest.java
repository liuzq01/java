package stringTest;

import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void test6()
    {
        //模拟trim(),去除字符串首尾的空格

        String s = "  Hello World  ";
        //step1:去掉开头的空格
        int num = s.length();
        for (int i = 0; i < num; i++)
        {
            if (s.startsWith(" "))
            {
                s = s.substring(1, s.length());
            }
        }
        //step2:去掉结尾的空格
        int p = s.length();
        for (int i = 0; i < p; i++)
        {
            if (s.endsWith(" "))
            {
                s = s.substring(0, s.length() - 1);
            }
        }
        System.out.println("---" + s + "---");
    }

    @Test
    public void test7()
    {
        //将字符串中指定部分反转，"abcdefg" --> "abfedcg"
        //假定不知道子串的位置
        String s = "abcdefg";
        String sub = "cdef";
        int l = sub.length();
        int index;  //子串的位置
        index = s.indexOf(sub);
        String subReverse;
        char[] ch = new char[l];
        for (int i = 0; i < l; i++)
        {
            ch[i] = sub.charAt(l - 1 - i);
        }
        subReverse = new String(ch);
        String sReverse = s.substring(0, index) + subReverse + s.substring(index + l, s.length());
        System.out.println(sReverse);
    }

    @Test
    public void test8()
    {
        //查询一个字符串a在另外一个字符串b中出现的次数，"ab" --> "kdjfkjablksjdfabkljfjj"
        //分析：依次取b的子串与a对比，相同记为1，不同记为0，结果组成一个数组array
        //       array中1的个数为所求的次数，1的位置为a在b中出现的位置
        String a = "ab";
        String b = "kdjfkjablksjdfabkljfjj";
        int inquireNum = b.length() - a.length();   //检查所需的总次数
        int[] array = new int[inquireNum];
        int total = 0;
        for (int i = 0; i < inquireNum; i++)
        {
            String sub = b.substring(i, i + a.length());
            if (a.equals(sub))
            {
                array[i] = 1;
                total++;
            } else array[i] = 0;
        }
        System.out.println(Arrays.toString(array));
        System.out.println("次数：" + total);
    }

    @Test
    public void test9()
    {
        //获取2个字符串中最大相同子串(假设只有一个)
        String s1 = "ksdhfkshellolkuinrgjgkdhjr";
        String s2 = "cvijhellojfurhe";
        //tips:将短串进行长度依此递减的字串与长串比较
        int l;    //子串的长度
        label:
        for (l = s2.length(); l >0; l--)
        {
            for (int m=0;m<s2.length()-l;m++)
            {
                for (int j = 0; j < s1.length() - l; j++)
                {
                    if(s2.substring(m, m + l).equals(s1.substring(j, j + l)))
                    {
                        System.out.println("最大相同字串是："+s2.substring(m, m + l));
                        break label;
                    }
                }
            }
        }

    }
    //将上面的过程封装成方法，并测试
    public String common(String s1,String s2)
    {
        if(s1!=null&&s1!=""&&s2!=null&&s2!="")
        {
            //如果s1是短串，将它和s2交换
            if(s1.length()<=s2.length())
            {
                String temp;
                temp=s1;
                s1=s2;
                s2=temp;
            }
            int l;    //子串的长度
            for (l = s2.length(); l >0; l--)
            {
                for (int m=0;m<s2.length()-l;m++)
                {
                    for (int j = 0; j < s1.length() - l; j++)   //可以使用contains()
                    {
                        if(s2.substring(m, m + l).equals(s1.substring(j, j + l)))
                        {
                           return s2.substring(m, m + l);
                        }
                    }
                }
            }
        }
        return null;
    }
    @Test
    public void test11()
    {
        String s1 = "ksdhfksHELLOlkuinrgjgkdhjrSHELL";
        String s2 = "cvijHELLOjfurheSHELL";
        System.out.println("最大相同子串是："+ common(s2,s1));
    }

    @Test
    public void test10()
    {
        //对字符串中的字符进行自然顺序排序
        //tips：1）字符串-->字符数组
//                2）对数组排序，选择，冒泡，Arrays.sort();
//                3)排序后的数组-->字符串
        String s="qwertyuiopasdfghjklzxcvbnm";
        char[] chars=new char[s.length()];
        for (int i = 0; i < s.length(); i++)
        {
            chars[i]=s.charAt(i);
        }
        Arrays.sort(chars);
        String ss=new String(chars);
        System.out.println(ss);
    }

}
