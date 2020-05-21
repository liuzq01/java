package IOtest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StreamExercise
{
    //Exercise1:节点流、缓冲流复制文件效率对比
    //节点流  (耗时(ms)：2202)
    @Test
    public void test() throws IOException
    {
        long l = System.currentTimeMillis();
        String str = "D:\\a新建文件夹\\markdown教程.flv";
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\a新建文件夹\\Java学习笔记\\node.flv"));
        byte[] bytes = new byte[1024];
        int read = fileInputStream.read(bytes);
        while (read != -1)
        {
            fileOutputStream.write(bytes, 0, read);
            read = fileInputStream.read(bytes);
        }
        fileInputStream.close();
        fileOutputStream.close();
        long ll = System.currentTimeMillis();
        System.out.println("耗时(ms)：" + (ll - l));
    }

    //缓冲流  (耗时(ms)：753)
    @Test
    public void test1() throws IOException
    {
        long l = System.currentTimeMillis();
        String str = "D:\\a新建文件夹\\markdown教程.flv";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("D:\\a新建文件夹\\Java学习笔记\\buffer.flv")));
        byte[] bytes = new byte[1024];
        int read = bufferedInputStream.read(bytes);
        while (read != -1)
        {
            bufferedOutputStream.write(bytes, 0, read);
            read = bufferedInputStream.read(bytes);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
        long ll = System.currentTimeMillis();
        System.out.println("耗时(ms)：" + (ll - l));

    }

    //Exercise2:图片加密
    @Test
    public void test2() throws IOException
    {
        String str = "D:\\a新建文件夹\\Java学习笔记\\file\\exercise.jpg";
        String str2 = "D:\\a新建文件夹\\Java学习笔记\\file\\encryption.jpg";
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
        int read = fileInputStream.read();
        while (read != -1)
        {
            fileOutputStream.write(read ^ 5);//每次读一个字符做异或运算，把结果写入新文件
            read = fileInputStream.read();                  //乘除有精度损失，无法还原
        }
        fileInputStream.close();
        fileOutputStream.close();
        //解密
        String str3 = "D:\\a新建文件夹\\Java学习笔记\\file\\encryption.jpg";
        String str4 = "D:\\a新建文件夹\\Java学习笔记\\file\\Decrypt.jpg";
        FileInputStream fileInputStream3 = new FileInputStream(new File(str3));
        FileOutputStream fileOutputStream4 = new FileOutputStream(new File(str4));
        int read3 = fileInputStream3.read();
        while (read3 != -1)
        {
            fileOutputStream4.write(read3 ^ 5);
            read3 = fileInputStream3.read();
        }
        fileInputStream3.close();
        fileOutputStream4.close();
    }

    //Exercise3：统计文本中每个字符出现的次数
    @Test
    public void test3() throws IOException
    {
        String str = "D:\\a新建文件夹\\Java学习笔记\\file\\统计字符频次.txt";
        StreamExercise streamExercise = new StreamExercise();
        HashMap<Character, Integer> characterIntegerHashMap = streamExercise.dataToMap(str);
        streamExercise.mapToFile(characterIntegerHashMap, str);
    }

    //统计字符频次，写入HashMap
    public HashMap<Character, Integer> dataToMap(String str) throws IOException
    {
        FileReader fileReader = new FileReader(new File(str));
        int read = fileReader.read();
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        while (read != -1)
        {
            char read1 = (char) read;
            if (!characterIntegerHashMap.containsKey(read1))
            {
                characterIntegerHashMap.put(read1, 1); //Map中不存在，添加
            } else
            {
                characterIntegerHashMap.put(read1, characterIntegerHashMap.get(read1) + 1); //存在，修改value
            }
            read = fileReader.read();
        }
        fileReader.close();
        return characterIntegerHashMap;
    }

    //Map-->toString，写入原文件末尾
    public void mapToFile(HashMap<Character, Integer> hashMap, String str) throws IOException
    {
//        String string = hashMap.toString();
//        FileWriter fileWriter = new FileWriter(new File(str), true);
//        fileWriter.write("\n" + string);
//        fileWriter.close();

        //方法二，遍历map，逐个写入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(str), true));
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Character, Integer> e : entries)
        {
            bufferedWriter.newLine();  //BufferedWriter有换行方法，FileWriter只能手动加"\n"
            switch (e.getKey())
            {
                case ' ':
                    bufferedWriter.write("空格="+e.getValue());
                    break;
                case '\t':
                    bufferedWriter.write("tab键="+e.getValue());
                    break;
                case '\r':
                    bufferedWriter.write("回车="+e.getValue());
                    break;
                case '\n':
                    bufferedWriter.write("换行="+e.getValue());
                    break;
                default:
                    bufferedWriter.write(e.getKey()+"="+e.getValue());
                    break;
            }
        }
        bufferedWriter.close();
    }
}
