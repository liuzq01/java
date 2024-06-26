import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;

public class Solution49a {
    @Test
    public void test(){
        //字母异位词分组
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //String[] strs = {"a"};
        //String[] strs = {""};
        //String[] strs = {"bat"};
        List<List<String>> strLists=new ArrayList<>();
        strLists=groupAnagrams(strs);
        System.out.println(strLists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //归一化：把字符串转成字符数组，可以当成普通的数字数组排序。同组的异位词排序结果相同。
        //用hashmap记录排序前后的对应关系，再合并同类项。
        HashMap<char[],List<String>> hashmap=new HashMap<>();
        List<String> strList=new ArrayList<>();
        char[]chars;
        for (int i = 0; i < strs.length; i++) {
            chars= strs[i].toCharArray();
            Arrays.sort(chars);
            if(hashmap.containsKey(chars)){     //
                strList=hashmap.get(chars);
                strList.add(strs[i]);
                hashmap.put(chars,new ArrayList<>(strList) );
            } 
            else hashmap.put(chars,new ArrayList<>(Arrays.asList(strs[i])));
        }
        return new ArrayList<>(hashmap.values());
    }
}
