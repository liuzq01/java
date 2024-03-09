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
    @Test
    public void test6(){
        //逆序输出整数
        int outNumber=reverseNumber(12345);
        System.out.println("逆序："+outNumber);
     }
    private int reverseNumber(int n){
        return reverseNumber(n,0,0,0);
    }
    private int reverseNumber(int n, int outNumber,int a,int b){
        b=n/10;         //  12345/10 = 1234
        a=n%10;         //  12345%10 = 5
        outNumber=a+outNumber*10;
        if (b==0)   return  outNumber;
        else        return reverseNumber(b, outNumber,a,b);
    }
    @Test
    public void test7(){
        //逆序输出字符串
        String str="liuZhiqiang";
        String reverseStr=reverseString(str);
        System.out.println("逆序："+reverseStr);
     }
    private String reverseString(String str){
        int l=str.length();
        return reverseString(str,l,"");
     }
    private String reverseString(String str,int l,String s){
        if(l==0) return s;
        else {
            s=s+str.charAt(l-1);
            return reverseString(str,l-1,s);
            }
     }
     @Test
     public void test8(){
     //字符串中某个指定字符出现的次教
     String str="liuzhiqiang"; char c='i';
     int number=characterCount( str, c);
     System.out.println(number);
    }
    private int characterCount(String str,char c){
        int l=str.length();
        return characterCount( str, c,0,l-1);
    }
    private int characterCount(String str,char c,int sum,int l){
        char a=str.charAt(l);
        if(a==c)   sum++;
        if (l==0) return sum;
        else return characterCount(str, c, sum, l-1);
    }
    @Test
    public void test9(){
        //求数组中大写字母的个数
        char[] chars={'a','A','b','B','C','D','d'};
        int number=uppercase(chars);
        System.out.println(number);
    }
    private int uppercase(char[] chars){
        int l=chars.length;
        return uppercase(chars,0,l);
    }
    private int uppercase(char[] chars,int sum,int l){
        if(chars[l-1]>='A'&&chars[l-1]<='Z') sum++;
        if(l==1) return sum;
        else return uppercase(chars,sum,l-1);
    }
    @Test
    public void test10(){
        //字符数组中某个指定字符出现的次数
        char[] chars={'l','i','u','z','h','i','q','i','a','n','g'};
        int number=charCount(chars,'i');
        System.out.println(number);
    }
    private int charCount(char[]chars,char c){
        int l=chars.length;
        return charCount(chars, c,l,0);
    }
    private int charCount(char[]chars,char c,int l,int sum){
        if(chars[l-1]==c) sum++;
        if(l==1) return sum;
        else return charCount(chars, c,l-1,sum);
    }
    @Test
    public void test11(){
        //将十进制数转换为二进制教
        int decNumber=27;
        int binNumber=dec2Bin(decNumber);
        System.out.println(decNumber+" 对应的二进制数是："+binNumber);
    }
    private int dec2Bin(int decNumber){
        return dec2Bin(decNumber,0,0);
    }
    private int dec2Bin(int decNumber,int i,int result){
        //quotient=商, remainder=余数
        int quotient=decNumber/2;
        int remainder=decNumber%2;
        result=result+(int)(remainder*Math.pow(10, i)); // 写成 10^i ，不行，因为 ^ 是异或操作符
        if(quotient==0) return result;
        else return dec2Bin(quotient,i+1,result);
    }
    @Test
    public void test12(){
        //将十进制数转换为十六进制数
        int dec=274;
        String hex=dec2Hex(dec);
        System.out.println(dec+" 对应的十六进制数： "+hex);
    }
    private String dec2Hex(int dec){
        char[] chars= new char[100];
        dec2Hex(dec,chars,0);
        return charsToString(chars);
    }
    private char[] dec2Hex(int dec,char[] chars,int i){
        int quotient=dec/16;    //商
        int remainder=dec%16;   //余数
        toChar(remainder,chars,i);  //余数依次存入字符数组chars
        if(quotient==0) return chars;
        else return dec2Hex(quotient,chars,i+1);
    }
    private void toChar(int remainder,char[] chars,int i){
        if(remainder>=0 && remainder<=9) chars[i]=(char) (remainder+'0');     //余数由数字转为字符
        else chars[i]=(char)(remainder-10+'A');
    }
    private String charsToString(char[] chars){
        int l=chars.length;
        return charsToString(chars,l-1,"");
    }
    private String charsToString(char[]chars,int l,String str){
        str=str+chars[l];       //逆序把chars的所有字符拼接在一起
        if(l==0) return str;
        else return charsToString(chars, l-1,str);
    }
    @Test
    public void test13(){
        //将二进制数转换为十进制数
        String str="11011";
        System.out.println(bin2Dec(str));
    }
    private  int bin2Dec(String binarystring){
        int l=binarystring.length();
        return bin2Dec(binarystring,l-1,0,0);
    }
    private  int bin2Dec(String binarystring,int l,int result,int i){
        char c=binarystring.charAt(l);
        int cc=c-'0';       //字符转数字
        result=(int) (result+cc*Math.pow(2, i));
        if(l==0) return result;
        else return bin2Dec(binarystring,l-1,result,i+1);
    }
    @Test
    public void test14(){
        //将十六进制数转换为十进制数
        String str="1AB";
        System.out.println(hex2Dec(str));
    }
    private  int hex2Dec(String hexString){
        int l=hexString.length();
        return hex2Dec(hexString,l-1,0,0);
    }
    private  int hex2Dec(String hexString,int l,int result,int i){
        char c=hexString.charAt(l);
        int cc=0;
        if(c>='0'&&c<='9') cc=c-'0';        //字符转数字
        else cc=c-'A'+10;
        result=(int) (result+cc*Math.pow(16, i));
        if(l==0) return result;
        else return hex2Dec(hexString,l-1,result,i+1);
    }
    @Test
    public void test15(){
        //输出一个字符串的所有排列组合
    }
    private  void displayPermutation(String s){

    }
    //非递归目录大小
    //某个目录下的文件数目
    //递归地找出某个目录下的所有文件中某个单词出现的次数
    //递归地用一个新单词替换某个目录下的所有文件中出现的某个单词
}
