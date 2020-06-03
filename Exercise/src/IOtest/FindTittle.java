package IOtest;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FindTittle
{
    @Test
    public void test() throws IOException
    {
        FileReader fileReader = new FileReader("D:\\a新建文件夹\\Java学习笔记\\file\\提取tittle2.txt");
        FileWriter fileWriter = new FileWriter("D:\\a新建文件夹\\Java学习笔记\\file\\tittle2.txt");
        ArrayList<Integer> integers = new ArrayList<>(); //记录字符串开始的位置
        ArrayList<Integer> integersEnd = new ArrayList<>(); //记录字符串结束的位置
        ArrayList<String> strings = new ArrayList<>();  //存入字符串
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = new char[1024];
        int read = fileReader.read(chars);
        //读取文件所有字符，存入stringBuilder
        while (read!=-1)
        {
            stringBuilder.append(chars,0,read);
            read = fileReader.read(chars);
        }
//        System.out.println(stringBuilder);
//        System.out.println("*********stringBuilder**********");
        int i=0;
        //查找、记录tittle开始的位置
        while (i!=-1)
        {
            i = stringBuilder.indexOf("title=", i + 5);
            integers.add(i);
        }
        i=0;
        //查找、记录tittle结束的位置
        while (i!=-1)
        {
            i = stringBuilder.indexOf("><i class=", i + 5);
            integersEnd.add(i);
        }
//        System.out.println(integers);
//        System.out.println(integersEnd);
//        System.out.println("****integers***********");
        String substring;
        //提取tittle，存入strings
        for (int j = 0; j < integers.size() - 1; j++)
        {
             substring = stringBuilder.substring(integers.get(j)+7, integersEnd.get(j)-1);
             strings.add(substring);
        }
//        System.out.println(strings);
//        System.out.println("************strings***********");
        //把tittle存入文件
        for (int j = 0; j < strings.size(); j++)
        {
             fileWriter.write(strings.get(j)+"\n");
        }
        fileReader.close();
        fileWriter.close();
    }
}
