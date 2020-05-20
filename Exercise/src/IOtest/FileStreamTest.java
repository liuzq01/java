package IOtest;

import org.junit.Test;

import java.io.*;

public class FileStreamTest
{
    @Test
    public void test()
    {
        File file = new File("D:\\a新建文件夹\\Java学习笔记\\file\\testDir\\regret.txt");
        FileReader fileReader = null;

        {
            try
            {
                fileReader = new FileReader(file);
                int read = fileReader.read();
                while (read!=-1)
                {
                    System.out.print((char)read);
                    read = fileReader.read();
                }
            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            } catch (IOException e)
            {
                e.printStackTrace();
            } finally
            {
                try
                {
                    fileReader.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }

            }
        }

    }
    @Test
    public void test1() throws IOException
    {
        File file = new File("D:\\a新建文件夹\\Java学习笔记\\file\\testDir\\regret.txt");
        FileReader fileReader = new FileReader(file);
        char[] chars=new char[3];
        int read=fileReader.read(chars);
//        while (read!=-1)
//        {
//            System.out.print(new String(chars));
//            read = fileReader.read(chars);
//            if (read<3)
//            {
//                for (int i = 0; i < read; i++)
//                {
//                    System.out.print(chars[i]);
//                }
//                break;
//            }
//        }
        while (read!=-1)
        {
            System.out.print(new String(chars,0,read));
            read = fileReader.read(chars);
        }

    }
    @Test
    public void test2() throws IOException
    {
        File file=new File("D:\\a新建文件夹\\Java学习笔记\\file\\testDir\\regret.txt");
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write("liu");
        fileWriter.write("zhiQiang");
        fileWriter.close();

    }
}
