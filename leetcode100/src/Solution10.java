import java.util.ArrayList;

import org.junit.Test;

public class Solution10 {
    //正则表达式匹配。'.'： 匹配任意单个字符；'*'：匹配其前面的元素零次或多次。这意味着前面的元素可以出现多次，也可以完全不出现。
    /*
     * <1> s="aab", p="aabb*", 干掉“b*”，p = "aab" == s；所以，干掉“b*”，相当于*让第2个b重复0次（即抹掉了第二个b）
     * <2> s="aab", p="aab*"，p = "aab" == s，*使得b重复1次
     */
    @Test
    public void test(){
        String s="liuzhiqiang";
        //String p="li.*ang";     //s,p只包含3种字符：a-z  .  *，*的前面肯定有一个字符
        //String p="li.*ing";
        //String p="li.*ang.";
        String p="li.*ang*";
        //String p="li.x*ang";
        ArrayList<String>  aList=segmentation(p);
        for(String str:aList) System.out.println(str);
        //System.out.println(isMatch(s, p));
    }
            //把p拆分成3类：只包含a-z的字符串、"."、"*"，保持原有顺序存入arraylist。再把s作对应的拆分，并对比。
    public boolean isMatch(String s, String p) {
        ArrayList<String>  aList=segmentation(p);
        return comparison(s, aList);
    }
    //分割p
    private ArrayList<String> segmentation(String p){
        ArrayList<String>   pList=new ArrayList<>();
        StringBuffer sBuffer=new StringBuffer();
        char c;     
        for (int i = 0; i < p.length(); i++) {
                c=p.charAt(i); 
                if('a'<=c && c<='z') sBuffer.append(c);
                if(c=='.' || c=='*' || i==p.length()-1) {    
                    if(sBuffer.length()!=0) {
                        pList.add(sBuffer.toString());
                        sBuffer.delete(0,sBuffer.length()); //重置
                    }
                    if(c=='.' || c=='*' ) pList.add(String.valueOf(c));     //加条件 if(c=='.' || c=='*' ) ，可避免最后一个字符属于(a,z)时被重复添加
                }
        }
        return pList;
    }
    //对比是否匹配
    private boolean comparison(String s,ArrayList<String> pList){

    }
}
