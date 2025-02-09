import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class Solution438 {
    @Test
    public void test(){
        String s = "cbaebabacd"; String p = "abc";
        //String s = "abab"; String p = "ab";
        System.out.println(findAnagrams(s, p).toString());
    }
    public List<Integer> findAnagrams(String s, String p) {
        // 生成p的全排列，存入hashSet。遍历s，截取子串与hashSet对比。
        HashSet<String> hashSet=new HashSet<>();
        char[] chars=p.toCharArray();
        permutation(hashSet,chars,new HashSet<Integer>(),"");
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < s.length()-p.length()+1; i++) {
            String subString=s.substring(i, i+p.length());
            if (hashSet.contains(subString)) {
                list.add(i);
            }
        }
        return list;
    }
    private void permutation(HashSet<String> hashSet, char[] chars,HashSet<Integer> tempSet,String tempString) {
        if (tempString.length()==chars.length) {
            hashSet.add(tempString);
            return;
        }
        int num=0;
        for (int i = 0; i < chars.length; i++) {
            if (!tempSet.contains(i)) {
                tempString=tempString+chars[i];
                tempSet.add(i);
                num=i;
                permutation(hashSet, chars, tempSet, tempString);
                tempSet.remove(num);
                tempString=tempString.substring(0, tempString.length()-1);
            }
        }
    }
}
/*
 * 438. 找到字符串中所有字母异位词
给定两个字符串 s 和 p，找到 s 中所有 p 的 
异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */

