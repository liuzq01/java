import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class Solution49 {
    @Test
    public void test(){
        //字母异位词分组
        /*
        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        输入: strs = [""]
        输出: [[""]]
        输入: strs = ["a"]
        输出: [["a"]]
        */
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //String[] strs = {"a"};
        //String[] strs = {""};
        //String[] strs = {"bat"};
        List<List<String>> strLists=new ArrayList<>();
        strLists=groupAnagrams(strs);
        System.out.println(strLists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0) return new ArrayList<>(new ArrayList<>());
        //遍历strs,对每个单词，构造出它的所有异位词，存入list1。遍历strs、list1，找出符合条件的单词，存入list.
        List<List<String>> lists=new ArrayList<>();
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.addAll(Arrays.asList(strs));
        ArrayList<String> list1=  new ArrayList<>();
        ArrayList<String> list2=  new ArrayList<>();
        while (linkedList.size()>0) {
            list1= fullPermutationsOfWord(linkedList.get(0));
            for (int j = 0; j < linkedList.size(); j++) {
                if (list1.contains(linkedList.get(j))) {
                    list2.add(linkedList.get(j));
                    linkedList.remove(j);   // 删除已添加项，减少重复
                    j--;
                }
            }
            lists.add(new ArrayList<>(list2));
            list1.clear();  list2.clear();
        }
        return lists;
    }
    private ArrayList<String> fullPermutationsOfWord(String str){
        //单个单词的全排列
        ArrayList<Integer> numberList=new ArrayList<>();
        ArrayList<String> strlist=new ArrayList<>();
        fullPermutationsOfWord(str,"",numberList,strlist);
        return strlist;
    }
    private void fullPermutationsOfWord(String str,String str1,ArrayList<Integer> numberList,ArrayList<String> strlist){
        if(str1.length()==str.length()) {
            strlist.add(new String(str1));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if(numberList.contains(i)) continue;        //同一位置的字母，只选择一次
            else {
                numberList.add(i);
                str1=str1+str.charAt(i);
                fullPermutationsOfWord(str,str1,numberList,strlist);
                numberList.remove(numberList.size()-1);
                str1=str1.substring(0,str1.length()-1);
                }
        }
    }
}
