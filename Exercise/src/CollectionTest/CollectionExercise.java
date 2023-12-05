package CollectionTest;

import org.junit.Test;

import java.util.*;

public class CollectionExercise
{
    public static void main(String[] args)
    {
        // 由键盘输入10个数，保存到List；倒序；从大到小输出。
        Scanner scanner=new Scanner( System.in);
        System.out.println("plz input :");
        int i1;
        ArrayList list= new ArrayList(10);
        for (int i = 0; i < 10; i++)
        {
            System.out.println("第"+(i+1)+"个数：");
            i1 = scanner.nextInt();
            list.add(i1);
        }
        //倒序
        Collections.reverse(list);
        //从大到小输出
        Collections.sort(list, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return -Integer.compare(o1,o2);
            }
        });
        System.out.println("倒序："+list);

    }
}
