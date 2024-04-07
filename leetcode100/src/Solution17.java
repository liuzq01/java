import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class Solution17 {
    @Test
    //电话号码的字母组合
    public void test(){
        //String str="23";
        String str="468";
        //String str="5";
        //String str="";
        List<String> list=letterCombinations(str);
        list.stream().forEach(System.out::println);
    }
    public List<String> letterCombinations(String digits) {
        //创建字符列表
        List<char[]> list=new ArrayList<>();
        list.add(new char[]{'a','b','c'});
        list.add(new char[]{'d','e','f'});
        list.add(new char[]{'g','h','i'});
        list.add(new char[]{'j','k','l'});
        list.add(new char[]{'m','n','o'});
        list.add(new char[]{'p','q','r','s'});
        list.add(new char[]{'t','u','v'});
        list.add(new char[]{'w','x','y','z'});
        //从digits中取出数字，减去2，与list的下标对应。这种对应与电话按键上的对应关系相同。
        char[]chars=digits.toCharArray();
        int[] arr=new int[chars.length];
        if(arr.length==0) return Collections.emptyList();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]=chars[i]-'0'-2;
        }
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();
        return generateLetterCombinations(list,arr,0,list1,list2);
    }

    private List<String> generateLetterCombinations(List<char[]> list, int[] arr,int n,List<String> list1,List<String> list2)
    {   //从一个char[]开始生成组合字符串，每增加一个char[]，在上一个组合的基础上，遍历所有字符串，逐一与新增char[]中的字符拼接，组成新的字符串组合
        char[] chars=list.get(arr[n]);
        if (n==0)   //只有一个char[]（只有一个电话按键）
        {
            for (int i = 0; i < chars.length; i++)
            {
                list1.add(String.valueOf(chars[i]));
            }
        }
        if (n>=1){
            for (int i = 0; i < chars.length; i++)
            {
                for (int j = 0; j < list1.size(); j++)
                {
                    String s = list1.get(j) + chars[i];
                    list2.add(s);
                }
            }
            list1.clear();
            list1.addAll(list2);
            list2.clear();
        }
        if (n==arr.length-1) return list1;
        else return generateLetterCombinations(list,arr,n+1,list1,list2);
    }
}
