import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class Solution20
{
    @Test
    //有效的括号
    /*
        输入：s = "()[]{}"
        输出：true
        输入：s = "(]"
        输出：false
        s 仅由括号 '()[]{}' 组成
    */
    public void test(){
        String s="([] {})";
        //String s="( ]";       //false
        //String s="{([ )]}";    //false
        //String s="{([]) []}";    
        //String s="[] ((";       //false
        System.out.println(isValid(s));
    }
    public boolean isValid(String s) {  
    //有效的括号：以对称的方式闭合
        //用hashMap来描述闭合，用入栈出栈来描述对称。遇到左括号就入栈，遇到右括号就出栈，并与之比较是否匹配。
        System.out.println(s.length());
        HashMap<Character,Character> hashMap=new HashMap<>();
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('{','}');
        Stack<Character> stack=new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++)
        {
            c=s.charAt(i);
            if(hashMap.containsKey(c)) stack.push(c);
            if (hashMap.containsValue(c)) {
                if (stack.isEmpty()) return false;
                if(!hashMap.get(stack.pop()).equals(c)) return false;
            }
        }
        return stack.isEmpty();
    }

}
