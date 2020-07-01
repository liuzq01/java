package aRename;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;

public class Rename
{
    //给B站下载的视频文件(*.flv)重命名，与弹幕文件(*.ass)保持一致
    @Test
    public void test()
    {
        String strVideo = "D:\\document\\video";
        String strAss = "D:\\document\\javaweb";
        String[] namesOfVideo = getNames(strVideo);
        String[] namesOfASS = getNames(strAss);
//        System.out.println(Arrays.toString(namesOfVideo));
        preRename(namesOfVideo, namesOfASS);
//        System.out.println(Arrays.toString(namesOfVideo));
        rename(strVideo,namesOfVideo);
    }

    //获取文件名，不带后缀
    public String[] getNames(String str)
    {
        File file = new File(str);
        String[] list = file.list();
//        System.out.println(Arrays.toString(list));
        String[] strings = new String[list.length];
        for (int i = 0; i < list.length; i++)
        {
            String substring = list[i].substring(0, list[i].length() - 4);
            strings[i] = substring;
        }
//        System.out.println("****************");
//        System.out.println(Arrays.toString(strings));
        return strings;
    }

    //预重命名，不带后缀
    //对比视频名字和字幕名字的最后length-3个字符，改成字幕文件名字
    public static void preRename(String[] namesOfVideo, String[] namesOfASS)
    {
        int k=0;
        for (int i = 0; i < namesOfVideo.length; i++)
        {
            for (int j = 0; j < namesOfASS.length; j++)
            {
                if (namesOfASS[j].indexOf('-')<=3) k=namesOfASS[j].indexOf('-'); //ass文件为2、3
                else k=0;
                String substringOfASS = namesOfASS[j].substring(k+1, namesOfASS[j].length());
                if (namesOfVideo[i].equals(substringOfASS)) //待解决：有些ass文件名的最后几个字会丢失(可能是文件名过长引起的)
                {
                    namesOfVideo[i] = namesOfASS[j];
                }
            }
        }
    }

    //视频文件重命名
    public static void rename(String strVideo, String[] namesOfVideo)
    {
        File file = new File(strVideo);
        File[] files = file.listFiles();
        String s = null;
        File file1 = null;
        for (int i = 0; i < files.length; i++)
        {
            s = strVideo + "\\" + namesOfVideo[i] + ".flv";
            file1 = new File(s);
            files[i].renameTo(file1);
        }
    }

    //修改字幕文件名,并重命名视频文件
    @Test
    public void test2()
    {
        String strAss = "D:\\document\\javaweb";
        String[] namesOfASS = getNames(strAss);
        String[] newNamesOfASS =new String[namesOfASS.length];
        int n=0;int k=0;
        for (int i = 0; i < namesOfASS.length; i++)
        {
            n = namesOfASS[i].indexOf('-');
            k = namesOfASS[i].indexOf('.');
            newNamesOfASS[i]=namesOfASS[i].substring(0,n+1)+namesOfASS[i].substring(k+1,namesOfASS[i].length());
        }
//        System.out.println(Arrays.toString(newNamesOfASS));
        String strVideo = "D:\\document\\video";
        String[] namesOfVideo = getNames(strVideo);
        preRename(namesOfVideo, newNamesOfASS);
        rename(strVideo,namesOfVideo);
        renameAss(strAss,newNamesOfASS);
    }
    public static void renameAss(String strAss, String[] namesOfASS)
    {
        File file = new File(strAss);
        File[] files = file.listFiles();
        String s = null;
        File file1 = null;
        for (int i = 0; i < files.length; i++)
        {
            s = strAss + "\\" + namesOfASS[i] + ".ass";
            file1 = new File(s);
            files[i].renameTo(file1);
        }
    }

}
