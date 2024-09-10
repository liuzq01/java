import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Solution139 {
    
    @Test
    public void test(){
        String s="applepenapple";
        List<String> wordDict=Arrays.asList("apple", "pen");
        String s1="catsandog";
        List<String> wordDict1=Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreak(s1, wordDict1));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] a={false};
        wordBreak(s,0,0, wordDict,a);
        return a[0];
    }
    public void wordBreak(String s,int start,int i, List<String> wordDict,boolean[] a) {
        //从wordDict选词排列组合，与s匹配。每次可选n个，n叉树。逐词匹配以剪枝。s的长度决定递归终止条件（确定n叉树的深度）。
        if(start==s.length()) a[0]=true;
        for ( i = 0; i < wordDict.size(); i++) {     
            int l=wordDict.get(i).length();
            if(start+l<=s.length()){
                if(wordDict.get(i).equals(s.substring(start, start+l)))  wordBreak(s,start+l,i,wordDict,a); 
            }
        }
    }
/*  单词拆分
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
s 和 wordDict[i] 仅由小写英文字母组成.wordDict 中的所有字符串 互不相同.

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false 
*/
}
