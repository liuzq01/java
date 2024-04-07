import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Solution22 {
    @Test
    public void test(){
        //括号生成
/*
        输入：n = 3
        输出：["((()))","(()())","(())()","()(())","()()()"]
        输入：n = 2
        输出：["(())","()()"]
        输入：n = 1
        输出：["()"]
*/
        List<String> list=generateParenthesis(3);
        list.forEach(System.out::println);
    }
    public List<String> generateParenthesis(int n) {
        List<String> list0=new ArrayList<>();
        List<String> list1=new ArrayList<>();
        return generateParenthesis(n,1,list0,list1);
    }
    public List<String> generateParenthesis(int n,int k,List<String> list0,List<String> list1) {
        //n=k时，输出为 ∑P (P是字符串)；n=k+1时，输出为：∑{"(P)"，"()P"，"P()"}。再去重。
        if (k==1) {
            list0.add("()");
        }
        else{
            for (int i = 0; i < list0.size(); i++) {
                String p=list0.get(i);
                list1.add("("+p+")");
                list1.add("()"+p);
                list1.add(p+"()");
            }
            list0.clear();
            list0.addAll(list1);
            list1.clear();
        }
        if (k==n) return list0.stream().distinct().collect(Collectors.toList());
        else return generateParenthesis(n,k+1,list0,list1);
    }
}
