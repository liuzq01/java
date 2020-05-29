package exercise2;

import org.junit.Test;

import java.io.*;
import java.util.Random;

public class Chapter17
{
    //exercise 17.1
    @Test
    public void test()
    {
        FileWriter fileWriter = null;
        try
        {
            File file = new File("Exercise\\src\\exercise2\\Exercisel7_01.txt");
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
            fileWriter = new FileWriter(file, true);
            Random random = new Random(1000);
            int k = 0;
            for (int i = 0; i < 100; i++)
            {
                k = random.nextInt(50);
                fileWriter.write(String.valueOf(k) + " ");
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                fileWriter.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Test
    //exercise 17.2
    public void test1()
    {
        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream("Exercise\\src\\exercise2\\Exercisel7_02.dat", true);
            int k = 0;
            for (int i = 0; i < 100; i++)
            {
                k = (int) (Math.random() * 50);
                fileOutputStream.write((byte) k);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                fileOutputStream.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    //exercise 17.4, 以下写法仅为复制文件，不符要求？
    //疑问---如何转换 ：字符-->字节？
    @Test
    public void test3() throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream("D:\\a新建文件夹\\Java学习笔记\\file\\统计字符频次.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("Exercise\\src\\exercise2\\Exercisel7_04.dat");
        FileOutputStream fileOutputStream1 = new FileOutputStream("Exercise\\src\\exercise2\\Exercisel7_04.txt");
        byte[] bytes = new byte[16];
        int read = fileInputStream.read(bytes);
        while (read!=-1)
        {
            fileOutputStream.write(bytes,0,read);
            fileOutputStream1.write(bytes,0,read);
            read = fileInputStream.read(bytes);
        }
        fileInputStream.close();
        fileOutputStream.close();
        fileOutputStream1.close();
    }
}
