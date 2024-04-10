import java.util.HashMap;
import java.util.Stack;
import org.junit.Test;

public class Solution32 {
    @Test
    public void test(){
        //最长有效括号
/*
        输入：s = "(()"
        输出：2
        解释：最长有效括号子串是 "()"
        输入：s = ")()())"
        输出：4
        解释：最长有效括号子串是 "()()"
        输入：s = ""
        输出：0
        s[i]只包含 '('，')'，'{'，'}'，'['，']'
*/
        //String s="";
        String s="}[(]) {(())[]}([]{})";    // 14 ,[6,19], 输出最长字符串的左右端点下标
        //String s="(]";      //0
        //String s = ")()())";     //4, [1,4]
       int[] arr=longestValidParentheses(s);
       if(arr.length==0) System.out.println("没有有效括号");
       else System.out.printf("["+arr[0]+" , "+arr[1]+"]");
    }
    public int[] longestValidParentheses(String s) {
        //用长为l的长方形框，框取长度为l的字符串。移动长框，取得所有长度为l的字符串，
        //逐一判断是否为有效括号(Solution20)。欲寻找最长的，则l从最大值递减，找到的第一个即符合要求。
        if(s.length()==0) return new int[0];
        int left=0;     //长框的左端点
        int l=s.length();
        if (s.length()%2==1) l=l-1;
        for ( ; l >= 2; l=l-2) {   //有效括号是一对对儿的，偶数
            for (left = 0; left <= s.length()-l; left++) {
                //长框: [left,left+l-1]
                if(isValidBrackets(s,left,left+l-1)) return new int[]{left,left+l-1};
            }
        }
        return new int[0];
    }
    private boolean isValidBrackets(String s,int left,int right){
        HashMap<Character,Character> hashMap=new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('{', '}');
        hashMap.put('[', ']');
        Stack<Character> stack=new Stack<>();
        char c;
        for (int i = left; i <= right; i++) {
            c=s.charAt(i);
            if(hashMap.containsKey(c)) stack.push(c);
            if(hashMap.containsValue(c)) {
                if(stack.isEmpty()) return false;
                if(!hashMap.get(stack.pop()).equals(c)) return false;
            }
        }
        return stack.isEmpty();
    }
}
