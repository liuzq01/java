import org.junit.Test;

public class Solution394 {
    @Test
    public void test(){
        String s = "rs3[ad]mn12[bc]ef";
        System.out.println(decodeString(s));
        String s1 = "rs3[ad2[bc]e]f";
        System.out.println(decodeString(s1));
    }
    public String decodeString(String s) {
        int[] arr={0};
        return decodeString(s,arr);
    }
    private String decodeString(String s, int[] arr) {
        //待码的字符串分成两部分：'a'、3[ab]（类似于这种形式）。3[ab]与3[ab]的关系：并列、嵌套。
        //与之相似，文件系统分成两部分：文件、文件夹。文件夹与文件夹的关系：并列、嵌套。处理方法：并列-遍历，嵌套-递归。
        String str=""; String coefficient=""; 
        for (int j = arr[0]; j < s.length(); j++) {
            char c=s.charAt(j);
            if ('0'<=c && c<='9')  coefficient=coefficient+c;
            if (c=='[') {
                arr[0]=j+1;
                str=str+decodeString(s,arr).repeat(Integer.valueOf(coefficient));
                coefficient="";
                j = arr[0]; 
                continue;
            }
            if ('a'<=c && c<='z')  str=str+c;
            if (c==']') {
                arr[0]=j;
                return str;
            }
        }
        return str;
    }
}
/*
 * 394. 字符串解码
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例 1：

输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：

输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：

输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
示例 4：

输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"
 

提示：

1 <= s.length <= 30
s 由小写英文字母、数字和方括号 '[]' 组成
s 保证是一个 有效 的输入。
s 中所有整数的取值范围为 [1, 300] 
 */
