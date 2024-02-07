import java.math.BigInteger;
import org.junit.Test;

public class RecursiveExercise2 {
    @Test
    public void test(){
        //用BigInteger类，计算大数的阶乘  
        /* 
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入一个数");
        int userInput = scanner.nextInt();  */
        System.out.println(100+" 的阶乘等于：");  
        System.out.println(factorial(100));
        //scanner.close();
    }
    public BigInteger factorial(int n){
        return factorial(n, new BigInteger("1"));
    }
    private BigInteger factorial(int n, BigInteger b){
        if(n==0) return b;
        else {
            b=b.multiply(new BigInteger(String.valueOf(n))); //
            return factorial(n-1, b);
        }
    }
    @Test
    public void test1(){
        //使用迭代写斐波那契数列
        System.out.println(factorial1(10));
    }
    public int factorial1(int n){
        int[] f =new int[n+1];
        f[0]=0; f[1]=1;
        for (int i = 2; i <= n; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];
    }
    @Test
    public void test2(){
        //递归求最大公约数
        System.out.println(gcd(20,15));
    }
    public int gcd(int m , int n){
        int j=m%n;
        if (j==0) return n;
        else return gcd(n,j);
    }
    @Test
    public void test3(){
        //递归求数列和：Σ（1/i）
        for (int i = 1; i <= 10; i++) {
            System.out.println(aE(i));
            System.out.println();
        }
    }
    public double aE(int input){
        return aE(1, 0, input);
    }
    private double aE(int n,double s, int input){
        s=s+1.0/n;
        if(n>=input) return s;
        else return aE(n+1, s, input);
    }
    @Test
    public void test4(){
        //递归求数列和：Σ（i/(2*i+1)）
        for (int i = 1; i <= 10; i++) {
            System.out.println(bE(i));
            System.out.println();
        }
    }
    public double bE(int input){
        return bE(1,0,input);
    }
    private double bE(int n, double s, int input){
        s=s+(1.0*n)/(2*n+1);      //注意“截断”
        if(n>=input) return s;
        else return bE(n+1,s,input);
    }
    @Test
    public void test5(){
        //递归写斐波那契数列，记录调用此数
        int[] k={0};        //或者使用静态变量
        System.out.println(factorial2(20,k));
        System.out.println("调用次数： "+ k[0]);
    }
    public int factorial2(int n, int[] k){
        if(n==0){
            k[0]=k[0]+1;
            return 0;
        } 
        else if(n==1) {
            k[0]=k[0]+1;
            return 1;
        }
        else {
            k[0]=k[0]+1;
            return factorial2(n-1,k)+factorial2(n-2,k);
        }
    }
}
