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
        s[i] 只包含 '(' 和 ')' 
 */
        String s=")()())";
        //String s = "";
        System.out.println(longestValidParentheses(s));
    }
    public int longestValidParentheses(String s) {

    }
}
