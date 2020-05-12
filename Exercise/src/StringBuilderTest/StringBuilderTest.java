package StringBuilderTest;

import org.junit.Test;

public class StringBuilderTest
{
    @Test
    public void sBuilderTest()
    {
        //增、删、改、查、插
       StringBuilder stringBuilder=new StringBuilder("abcdefg");
        System.out.println(stringBuilder);

        stringBuilder.append("hi");
        System.out.println(stringBuilder);

        stringBuilder.delete(0,2);
        System.out.println(stringBuilder);

        stringBuilder.replace(0,2,"mn");
        System.out.println(stringBuilder);

        stringBuilder.insert(2,"op");
        System.out.println(stringBuilder);

        stringBuilder.reverse();
        System.out.println(stringBuilder);

        int gf = stringBuilder.indexOf("gf");
        System.out.println(gf);

        String substring = stringBuilder.substring(2, 4);
        System.out.println(substring);

        int length = stringBuilder.length();
        System.out.println(length);

        char c = stringBuilder.charAt(2);
        System.out.println(c);

        stringBuilder.setCharAt(2,'l');
        System.out.println(stringBuilder);
    }
    @Test
    public void efficiencyTest()
    {
        //分别用String、StringBuffer、StringBuilder 给空字符串str添加20000个字符，对比所花费的时间
        //效率: String< StringBuffer < StringBuilder
        String str="";
        long startTime=0;
        long endTime=0;
        startTime=System.currentTimeMillis();
        for (int i = 0; i < 20000; i++)
        {
            str=str+i;
        }
        endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
//        System.out.println(str);

        StringBuffer str1=new StringBuffer();
        startTime=System.currentTimeMillis();
        for (int i = 0; i < 20000; i++)
        {
            str1.append(String.valueOf(i));
        }
        endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
//        System.out.println(str1);

        StringBuilder str2=new StringBuilder();
        startTime=System.currentTimeMillis();
        for (int i = 0; i < 20000; i++)
        {
            str2.append(String.valueOf(i));
        }
        endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
//        System.out.println(str2);

    }
}
