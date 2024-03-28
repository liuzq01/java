import org.junit.Test;

public class Solution5 {
    //最长回文子串
    @Test
    public void test(){
       String   str= "1221xxliuuilyyqianggnaiqzz2333"; 
       System.out.println(longestPalindrome(str));
    }
    public String longestPalindrome(String s) {
        return findSubString(strToChars(s));
    }
    //分解字符串成字符数组
    private char[] strToChars(String str){
        char[] chars=new char[str.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i]=str.charAt(i);
        }
        return chars;
    }
    //取子串，映射成子串下标组成的数组
    private String findSubString(char[]chars){
        //设子串的长度为i, 长为i的方框从左向右移动，移动距离为j，即可框取到长度为i的子串
        for (int i = chars.length; i >= 2; i--) {
            for (int j = 0; j <= chars.length-i; j++) {
                //框到的子串为[j,j+i-1],检验是否回文
                if(isPalindrome(chars,i,j)) {
                    char[] charsij=new char[i];
                    for (int k = j; k <= j+i-1; k++) {      //复制到新的字符数组，输出
                        charsij[k-j]=chars[k];
                    }
                    return String.valueOf(charsij);
                }
            }
        }
        return String.valueOf(chars[0]);
    }
    //检验一个子串是否回文
    private boolean isPalindrome(char[]chars,int i,int j){
        if(chars[j]!=chars[j+i-1])  return false;
        if(i==1 || i==2) return true;   //上一步执行通过的情况下，chars[j]==chars[j+i-1]，此时意味着待测字符串的最短子串也检测为真
        return isPalindrome(chars, i-2, j+1);
    }
    /* 
    @Test
    public void test1(){
       String   str= "1221xxliuuilyyqianggnaiqzz2333"; 
       System.out.println(longestPalindrome1(str));
    }
    //法二：动态规划
    public String longestPalindrome1(String s) {
        return findSubString1(s);
    }
    */
}
