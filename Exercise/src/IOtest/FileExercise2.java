package IOtest;

import org.junit.Test;

import java.io.File;

public class FileExercise2
{
    //exercise2
    //判断指定目录下是否有后缀名为 .jpg的文件，若有，输出文件名称
    @Test
    public void test()
    {
        String dir = "D:\\a新建文件夹\\Java学习笔记\\file";
        File file=new File(dir);
        String[] list = file.list();
        boolean b=false;
        for (String s:list)
        {
            if(s.endsWith(".jpg"))
            {
                System.out.println(s);
                b=true;
            }
        }
        if (!b)
        {
            System.out.println("没有.jpg文件");
        }
    }
}
