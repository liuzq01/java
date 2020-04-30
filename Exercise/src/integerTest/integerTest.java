package integerTest;

import java.util.Scanner;
import java.util.Vector;

public class integerTest
{
    public static void main(String[] args)
    {
        //把学生成绩存储在vector中
        int i = 0;
        Vector v=new Vector();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入学生成绩：");
        while ( i >=0)
        {
             i = scanner.nextInt();
             Integer a=i;
             if(i>=0)  v.addElement(a);
        }
        //找出最高分
        int max=0;
        int score=0;
        for (int j = 0; j < v.size(); j++)
        {
            Object o = v.elementAt(j);
            score=(Integer)o;
            if(score>max)
            {
                max=score;
            }
        }
        System.out.println("最高分是："+max);
        //输出所有学生的成绩及其等级
        for (int j = 0; j < v.size(); j++)
        {
            Object o = v.elementAt(j);
            score=(Integer)o;
            if(max-score<10) System.out.println(score+": A");
            else if(max-score<20) System.out.println(score+": B");
            else if(max-score<30) System.out.println(score+": C");
            else  System.out.println(score+": D");
        }
    }
}
