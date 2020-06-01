package exercise3;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Chapter22
{
    //exercise 22.5
    @Test
    public void test() throws IOException
    {
        FileReader fileReader = new FileReader("D:\\a新建文件夹\\Java学习笔记\\file\\统计单词.txt");
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();   //存的是单词的起始位置
        ArrayList<String> list2 = new ArrayList<>();
        int read = fileReader.read();
        //取出所有的字符，一个一个的存入list
        char ch;
        while (read != -1)
        {
            ch = (char) read;
            list.add(ch);
            read = fileReader.read();
        }
        //过滤掉list中的非字母符号,以空格代替
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) >= 'a' && list.get(i) <= 'z') characters.add(list.get(i));
            else if (list.get(i) >= 'A' && list.get(i) <= 'Z') characters.add(list.get(i));
            else if (list.get(i) == 0x20) characters.add(list.get(i));
            else characters.add(' ');
        }
        list.clear();
        list.addAll(characters);
        System.out.println(list);
        System.out.println("*********list********");
        //查找单词的起始位置，存入list1
        for (int i = 0; i < list.size() - 1; i++)
        {
            if (list.get(i).equals(' ') && (list.get(i + 1).equals(' ') == false)) list1.add(i + 1); //字符的前面是空格
            if (list.get(i + 1).equals(' ') && (list.get(i).equals(' ') == false)) list1.add(i);  //字符的后面是空格
            if (i == list.size() - 2 && (list.get(i + 1).equals(' ') == false)) list1.add(i + 1); //添加最后一个字符
        }
        //过滤list1中重复的数字
        List<Integer> collect = list1.stream().distinct().collect(Collectors.toList());
        list1.clear();
        list1.addAll(collect);
        System.out.println(list1);
        System.out.println("**************list1***************");
        //把所有字符拼接成一个字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            stringBuilder.append(list.get(i));
        }
        System.out.println(stringBuilder);
        System.out.println("******************stringBuilder******************");
        //取出单词，存入list2
        for (int i = 0; i < list1.size() - 1; i++)
        {
            if (stringBuilder.substring(list1.get(i) + 1, list1.get(i + 1)) != null)
            {
                if (stringBuilder.substring(list1.get(i) + 1, list1.get(i + 1))
                        .contains(" ") == false)
                    list2.add(stringBuilder.substring(list1.get(i), list1.get(i + 1) + 1)); //两个位置之间是单词，添加
                if (list1.get(i) > 0 && list1.get(i) < stringBuilder.length() - 1 && stringBuilder.charAt(list1.get(i) - 1) == 0x20
                        && stringBuilder.charAt(list1.get(i) + 1) == 0x20)
                    list2.add(String.valueOf(stringBuilder.charAt(list1.get(i)))); //单个字符的单词，添加
                if (list1.get(i) == 0 && stringBuilder.charAt(list1.get(i) + 1) == 0x20)
                    list2.add(String.valueOf(stringBuilder.charAt(list1.get(i))));    //开头是单个字符，添加
                if (list1.get(i) == stringBuilder.length() - 1 && stringBuilder.charAt(list1.get(i) - 1) == 0x20)
                    list2.add(String.valueOf(stringBuilder.charAt(list1.get(i)))); //结尾是单个字符，添加
                //0x20是空格
            }
        }
        System.out.println(list2);
        System.out.println("********list2**********");
        //排序
        Collections.sort(list2);
        System.out.println(list2.size());
        System.out.println(list2);
    }

    @Test
    public void test2() throws IOException
    {
        //上面取单词比较麻烦，先统计空格的位置，按空格取单词
        FileReader fileReader = new FileReader("D:\\a新建文件夹\\Java学习笔记\\file\\统计单词.txt");
        ArrayList<Character> list = new ArrayList<>();  //存所有的字符
        ArrayList<Integer> list1 = new ArrayList<>();   //存空格的位置
        ArrayList<String> list2 = new ArrayList<>();    //存单词
        int read = fileReader.read();
        //取出所有的字符，一个一个的存入list
        char ch;
        while (read != -1)
        {
            ch = (char) read;
            list.add(ch);
            read = fileReader.read();
        }
        //过滤掉list中的非字母符号,以空格代替
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) >= 'a' && list.get(i) <= 'z') characters.add(list.get(i));
            else if (list.get(i) >= 'A' && list.get(i) <= 'Z') characters.add(list.get(i));
            else if (list.get(i) == 0x20) characters.add(list.get(i));
            else characters.add(' ');
        }
        list.clear();
        list.addAll(characters);
        System.out.println(list);
        System.out.println("*********list********");
        //把所有的字符拼接在一起，连续多个空格仅保留一个
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            if (i == 0) stringBuilder.append(list.get(i));
            if (i > 0)
            {
                if (list.get(i).charValue() != 0x20) stringBuilder.append(list.get(i));
                if (list.get(i).charValue() == 0x20 && list.get(i - 1).charValue() != 0x20)
                    stringBuilder.append(list.get(i));
            }
        }
        System.out.println(stringBuilder);
        System.out.println("*********stringBuilder********");
        //统计空格的位置，存入list1
        for (int i = 0; i < stringBuilder.length(); i++)
        {
            if (stringBuilder.charAt(i)==' ')  list1.add(i);
        }
        System.out.println(list1);
        System.out.println("*********list1********");
        //取出单词，存入list2
        for (int i = 0; i < list1.size()-1; i++)
        {
            if (i==0)
            {
                //检查首尾是否有遗漏，只执行一次,保持添加的顺序
                if (stringBuilder.charAt(0)!=' ') list2.add(stringBuilder.substring(0,list1.get(0)));
            }
            list2.add(stringBuilder.substring(list1.get(i)+1,list1.get(i+1)));
            if (i==list1.size()-2)
            {
                //检查首尾是否有遗漏，只执行一次
                if (stringBuilder.charAt(stringBuilder.length()-1)!=' ')
                    list2.add(stringBuilder.substring(list1.get(list1.size()-1)+1,stringBuilder.length()));
            }
        }
        System.out.println(list2);
        System.out.println("*********list2********");
        Collections.sort(list2);
        System.out.println(list2.size());
        System.out.println(list2);
    }
}
