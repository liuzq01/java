import java.util.ArrayList;

import org.junit.Test;

public class Solution10 {
    //正则表达式匹配
    @Test
    public void test(){
        String s="liuzhiqiang";
        String p="li.*ang";
        //String p="li.*ing";
        //String p="li.x*ang";
    }
            //把p拆分成3类：只包含a-z的字符串、"."、"*"，保持原有顺序存入arraylist。再把s作对应的拆分，并对比。
    public boolean isMatch(String s, String p) {
        ArrayList<String>   pList=new ArrayList<>();
        StringBuffer sBuffer=new StringBuffer();
        char c;
        for (int i = 0; i < p.length(); i++) {
            c=p.charAt(i);
            if('a'<=c && c<='z') sBuffer.append(c);
            else pList.add(sBuffer.toString());
            sBuffer.delete(0,sBuffer.length()); //重置
            break;
        }
            if(c=='.' || c=='*') pList.add(String.valueOf(c));
        }
}
