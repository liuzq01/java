
import org.junit.Test;

public class Solution10 {
    //正则表达式匹配。'.'： 匹配任意单个字符；'*'：匹配其前面的元素零次或多次。这意味着前面的元素可以出现多次，也可以完全不出现。
    /*
     * <1> s="aab", p="aabb*", 干掉“b*”，p = "aab" == s；所以，干掉“b*”，相当于*让第2个b重复0次（即抹掉了第二个b）
     * <2> s="aab", p="aab*"，p = "aab" == s，*使得b重复1次
     */
    @Test
    public void test(){
     //   String s="liuzhiqiang";
        //String p="li.*ang";     //s只包含2种字符(a-z .), p只包含3种字符(a-z  .  *)，*的前面肯定有一个字符, **不存在
        //String p="li.*ing";
        //String p="li.*ang.";
    //    String p="li.*ang*";
        //String p="li.x*ang";
        //System.out.println(isMatch(s, p));
    }
        //  _*_   _*   _ _
        //  
        //  .*.  a*.  .*a  a*a   .*  a*  ..  .a  a.  aa
        public boolean isMatch(String s, String p) {
            int end=p.length()-1;
            return isMatch(s, p,end);
        }
    public boolean isMatch(String s, String p, int end) {
        char c0=p.charAt(end);  char c1=p.charAt(end-1);  char c2=p.charAt(end-2);
    //    char s0=s.charAt(end);  char s1=s.charAt(end-1);  char s2=s.charAt(end-2);
        if(c0=='.'&& c1=='*' && c2=='.')  {
            return isMatch(s, p,end-3); //
        }
        if(c0=='.'&& c1=='*' && ('a'<=c2 && c2<='z'))  {

        }
        if(('a'<=c0 && c0<='z') && c1=='*' && c2=='.')  {

        }
        if(('a'<=c0 && c0<='z') && c1=='*' && ('a'<=c2 && c2<='z'))  {

        }

        if(c0=='*' && c1=='.') {

        }
        if(c0=='*' &&  ('a'<=c1 && c1<='z')) {

        }
        if(c0=='.' && c1=='.') {

        }
        if(('a'<=c0 && c0<='z') && c1=='.') {

        }
        if(c0=='.' && ('a'<=c1 && c1<='z')) {

        }
        if(('a'<=c0 && c0<='z') && ('a'<=c1 && c1<='z')) {

        }
        return false;
    }
}
