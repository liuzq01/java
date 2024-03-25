import java.util.HashSet;

import org.junit.Test;

public class Solution3 {    //无重复字符的最长子串
    @Test
    public void test(){
        String str="abcabc abc&1bb";
        System.out.println(lengthOfLongestSubstring(str));
    }
    public int lengthOfLongestSubstring(String s){
        char[] chars=strToChars(s);
        return findSubString(chars);
    }
    //分解字符串成字符数组
    private char[]  strToChars(String str){
        char[]chars =new char[str.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i]=str.charAt(i);
        }
        return chars;
    }
    //取子串，映射成子串下标组成的数组
    private int findSubString(char[] chars){
        //设i为子串的长度，取一长度为i的方框，从String的最左端移动到最右端，即可框到所有长度为i的子串
        for (int i = chars.length; i >=2; i--) {
            for (int j = 0; j <= chars.length-i; j++) {
                //j是方框移动的长度，逐一检验每个子串是否有重复字符
                //if( checkDuplicateChars(chars,i,j)) return i;
                if( checkDuplicateCharss(chars,i,j)) return i;
            }
        }
        return 1;
    }
    //检验一个子串是否有重复字符。
    private boolean checkDuplicateChars(char[]chars ,int i,int j){
        //取到的子字符串：[j,j+i-1]，检验每个字符是否与它后面的所有字符相同
        for (int k = j; k <j+i-1; k++) {
            for (int m = k+1; m < j+i; m++) {
                if(chars[k]==chars[m]) return false;
            }       
        }
        return true;
    }
    //法二：使用hashSet检验一个子串是否有重复字符。
    private boolean checkDuplicateCharss(char[]chars ,int i,int j){
        //取到的子字符串：[j,j+i-1]，存入hashSet看元素个数是否减少
        HashSet<Character> hashSet=new HashSet<>();
        for (int k = j; k <= j+i-1; k++) {
            hashSet.add(chars[k]);
            }
        if(hashSet.size()<i) return false;
        else return true;
    }
    @Test
    public void test1(){        //法三：使用subString()、递归
        String str="abcabc abc&1bb";
        System.out.println(lengthOfLongestSubstring1(str));
    }
    public int lengthOfLongestSubstring1(String s){
        return findSubString1(s);
    }
    private int findSubString1(String str){
        for (int i = str.length(); i >=2; i--) {
            for (int j = 0; j <= str.length()-i; j++) {
                if(checkDuplicateChars1(str.substring(j,j+i))) return i;
            }
        }
        return 1;
    }
    private boolean checkDuplicateChars1(String str){
        //判断第一个字符是否重复；不重复，则去掉它，剩余子串递归
        for (int j = 1; j < str.length(); j++) {
            if(str.charAt(0)==str.charAt(j)) return false;
        }
        if(str.length()==2) return true;
        else return checkDuplicateChars1(str.substring(1, str.length()));
    }
}
