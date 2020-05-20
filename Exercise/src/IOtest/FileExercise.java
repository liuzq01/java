package IOtest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileExercise
{
    //exercise1
    //利用File构造器，new一个文件目录file
    // 1）在其中创建多个文件和目录
    // 2）编写方法，实现删除file中指定文件的操作
    @Test
    public void test1() throws IOException
    {
        //创建目录
        File file=new File("D:/a新建文件夹/Java学习笔记/file/testDir");
        boolean mkdir = file.mkdirs();
        if(mkdir)
        {
            System.out.println("成功创建目录：testDir");
        }
        else System.out.println("失败：创建目录testDir");
        //创建文件
        String parent = file.getParent();
        File file1 = new File(parent, "newFile1.txt");
        boolean newFile = file1.createNewFile();
        if(newFile)
        {
            System.out.println("成功创建文件：newFile1.txt");
        }
        else System.out.println("失败：创建文件：newFile1.txt");
    }
    @Test
    public void test2()
    {
        //方法：删除指定文件
        String str="D:/a新建文件夹/Java学习笔记/file/newFile1.txt";
        boolean b = FileExercise.delFile(str);
        if (b)
        {
            System.out.println("删除成功："+str);
        }else System.out.println("删除失败："+str);

    }
    public static boolean delFile(String s)
    {
        File file=new File(s);
        return file.delete();
    }

}
