package Java9to11;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class Java9test2
{
    //try-catch新语法,需要关闭的资源放在try()中，自动关闭
    @Test
    public void test()
    {

        try(FileReader fileReader = new FileReader("D:\\a新建文件夹\\Java学习笔记\\file\\lowerCase.txt"))
        {
            char[] chars = new char[16];
            int read = fileReader.read(chars);
            System.out.println(new String(chars));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
