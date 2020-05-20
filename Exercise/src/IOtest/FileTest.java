package IOtest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class FileTest
{
    //file方法的测试
//    - getAbsolutePath,getPath,getName,getParent
//    - length,lastModified,list(),listFiles()
    //renameTo

    @Test
    public void test()
    {
        File file = new File("helloTest.txt");
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println("**************");
        System.out.println(file.length());
        long l = file.lastModified();
        System.out.println(LocalDateTime.ofEpochSecond(l/1000,0, ZoneOffset.ofHours(10)));
        System.out.println("**************");

        //返回该文件夹下的所有文件夹和文件
        File file2 =new File("D:/GithubRepository/java/Exercise");
        String[] list = file2.list();
        for (String str:list)
        {
            System.out.println(str);
        }
        System.out.println("**************");
        //返回该文件夹下的所有文件夹和文件，带目录
        File[] files = file2.listFiles();
        for (File file1:files)
        {
            System.out.println(file1);
        }

    }
    @Test
    public void test1()
    {
        File file = new File("helloTest.txt");
//        File file1 = new File("peachTest.txt");
//        boolean b = file.renameTo(file1);
//        System.out.println(b);
//        System.out.println("*************");
        // isDirectory(),isFile(),exists(),canRead(),canWrite(),isHidden()
        File file2 =new File("D:/GithubRepository/java/Exercise");
        System.out.println(file2.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println("*************");
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
    }
    @Test
    public void test2()
    {
        //delete,createNewFile
        File file=new File("yoo.txt");
        try
        {
            boolean newFile = file.createNewFile();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
//        System.out.println(file.delete());
    }
    @Test
    public void test3()
    {
        File file2 =new File("D:/GithubRepository/java/Exercise/tt");
        System.out.println(file2.mkdir());
        File file3=new File("D:/aa/tt");
        System.out.println(file3.mkdirs());
    }
    @Test
    public void test4()
    {
        File file = new File("D:\\a新建文件夹\\Java学习笔记\\file\\dirTest\\str.txt");
        File file1 = new File("D:\\a新建文件夹\\Java学习笔记\\file\\");
        System.out.println(file.getParent()); //D:\a新建文件夹\Java学习笔记\file\dirTest
        System.out.println(file1.getParent()); //D:\a新建文件夹\Java学习笔记
    }
}
