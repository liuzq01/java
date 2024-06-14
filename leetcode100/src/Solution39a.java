import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Solution39a {
@Test
    public void test(){
//组合总数，无重复元素
        int[]a=new int[10];
        for (int i = 1; i <=10; i++) {
            a[i-1]=i;
        }
        int sum=10;
        List<List<Integer>> combine =new ArrayList<>();
        searchCombine(combine,new ArrayList<>(),0,sum,a);
        for (int i = 0; i < combine.size(); i++) {
            for(Integer e:combine.get(i)){
                System.out.printf(e+" ");
            }
            System.out.println();
        }
    }
    private void searchCombine(List<List<Integer>> combine,ArrayList<Integer> arrayList,int n, int sum,int[] a){
        if(n>=10) return;
        if(sum==0) {
            combine.add(new ArrayList<>(arrayList));
            return;
        }
        searchCombine(combine, arrayList, n+1, sum, a);

        arrayList.add(a[n]);
        searchCombine(combine, arrayList, n+1, sum-a[n], a);

        arrayList.remove(arrayList.size()-1);
    }

}