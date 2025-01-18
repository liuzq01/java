import org.junit.Test;

public class Solution647 {
    @Test
    public void test(){
        String s = "aaa";
        System.out.println(countSubstrings(s));
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aba"));
    }
    public int countSubstrings(String s) {
        //截取长度为l的子串，逐个判断，l∈[2, s.length()]
        int count=0;
        for (int l = 2; l <= s.length(); l++) {
            for (int j = 0; j <=s.length()-l; j++) {
                String subStr=s.substring(j, j+l);
                if (symmetryString(subStr)) {
                    count++;
                }
            }
        }
        return count+s.length();
    }
    private boolean symmetryString(String s){
        for (int i = 0; i <= s.length()/2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
/*
 * 647. 回文子串
给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。

回文字符串 是正着读和倒过来读一样的字符串。

子字符串 是字符串中的由连续字符组成的一个序列。

示例 1：

输入：s = "abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入：s = "aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */

