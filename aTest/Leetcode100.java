import org.junit.Test;

public class Leetcode100 {
    @Test
    public void test(){
        //两数之和
        int[] nums={4,8,16,32,64,128};
        int target=80;
        sumOfTwo(nums, target);
    }
    private void sumOfTwo(int[] sums,int target){
        for (int i = 0; i < sums.length-1; i++) {
            for (int j = i+1; j < sums.length; j++) {
                if(sums[i]+sums[j]==target) {
                    System.out.println("["+i+" , "+j+"]");
                    return;
                }
            if((i==sums.length-2 )&& (j==sums.length-1 )&& (sums[i]+sums[j]!=target)) 
            System.out.println("查无此数");
            }
        }
    }
    @Test
    public void test1(){
        //两数相加
        int[] l1={2,4,3}; int[]l2={5,6,4};   //708
        sumOfTwo1(l1, l2);
    }
    private void sumOfTwo1(int[]l1,int[]l2){
        int n1=arrToNum(l1);
        int n2=arrToNum(l2);
        numToArr(n1+n2);
    }
    private int arrToNum(int[] l0){
        int num=0;
        for (int i = 0; i < l0.length; i++) {
            num=(int) (num+l0[i]*Math.pow(10, i));
        }
        return num;
    }
    private void numToArr(int num){
        int quotient=num/10;    //  807/10 = 80
        int remainder=num%10;   //  807%10 = 7
        System.out.printf("%d ",remainder);
        if(quotient!=0)  numToArr(quotient);
    }
}
