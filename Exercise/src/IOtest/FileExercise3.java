package IOtest;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FileExercise3
{
    /*
     *遍历指定目录所有文件名称，包括子文件目录中的文件
     * 拓展1：计算指定目录占用空间的大小
     * 拓展2：删除指定文件目录及其下的所有文件
     */
    private static long fileSize = 0; //文件总大小
    private static int total = 0;     //文件总个数

    @Test
    public void test()
    {
        //遍历
        String str = "D:\\a新建文件夹\\Java学习笔记\\file";
        File file = new File(str);
        FileExercise3.traverse(file);
        //文件大小
        System.out.println("文件总大小(字节): " + fileSize);
        System.out.println("文件总个数: " + total);
    }
    //     * 拓展2：删除指定文件目录及其下的所有文件
    //方法1：耗时(ms)：315
@Test
public void test1()
{
    String str = "D:\\a新建文件夹\\Java学习笔记\\file - 副本";
    File file = new File(str);
    long l = System.currentTimeMillis();
    FileExercise3.deleteFiles(file);    //删除所有文件
    //删除所有目录
    while (file.listFiles().length!=0)
    {
        FileExercise3.deleteDirectory(file);
    }
    System.out.println("删除是否成功："+file.delete());
    long ll = System.currentTimeMillis();
    System.out.println("耗时(ms)："+(ll-l));
}
    public static void traverse(File file)
    {
        File[] files = file.listFiles();
        for (File f : files)
        {
            if (f.isFile())
            {
                System.out.println(f.getName());
                fileSize += f.length();
                total++;
            }
            if (f.isDirectory()) traverse(f);
        }
    }

    public static void deleteFiles(File file)
    {
        File[] files = file.listFiles();
        for (File f : files)
        {
            if (f.isFile())
            {
//                System.out.println("已删除文件："+f.getName());
                f.delete();
            }
            if (f.isDirectory()) deleteFiles(f);
        }
    }

    //删除底层空目录
    public static void deleteDirectory(File file)
    {
        File[] files = file.listFiles();
        for (File f : files)
        {
            if (f.isDirectory() && f.listFiles().length==0)
            {
//                System.out.println("已删除目录："+f.getName());
                f.delete();
            }
            if (f.isDirectory() && f.listFiles().length!=0) deleteDirectory(f);
        }
        //f.listFiles() == null：返回路径名不表示一个目录，或者发生I / O错误
        //f.listFiles()=={}: 目录为空
    }
    /*********************************************************************************/
    //删除目录的方法2：
    //在上面的方法中，许多文件夹被遍历了很多次之后才被删除，效率低
    //设想：遍历所有文件夹的同时记录下名字、层级，将结果存在一个集合中，倒序排序，遍历集合，删除所有元素
    //耗时(ms)：195

   private static ArrayList arrayList=new ArrayList();
    @Test
    public void test3()
    {
        String str = "D:\\a新建文件夹\\Java学习笔记\\file - 副本";
        File file = new File(str);
        long l = System.currentTimeMillis();
        FileExercise3.addToList(file,0);
        FileExercise3.delDir(arrayList);
        System.out.println("删除是否成功："+file.delete());
        long ll = System.currentTimeMillis();
        System.out.println("耗时(ms)："+(ll-l));

    }
    public static void addToList(File file, int level)
    {
        File[] files = file.listFiles();
        level++;
        for (File f : files)
        {
            if (f.isFile())
            {
//                System.out.println("已删除文件："+f.getName());
                f.delete();
            }
            if (f.isDirectory())
            {
                arrayList.add(new Dir(f,level));
//                System.out.println("add: ("+f+" , "+level+")");
                addToList(f,level);
            }
        }
    }
    public static void delDir(ArrayList<Dir> arrayList)
    {
        Collections.sort(arrayList);
//        System.out.println(arrayList);
        for (int i = 0; i < arrayList.size(); i++)
        {
            File file1 = arrayList.get(i).getFile();
            file1.delete();
        }
    }
    //f.listFiles() == null：返回路径名不表示一个目录，或者发生I / O错误
    //f.listFiles()=={}: 目录为空


}
