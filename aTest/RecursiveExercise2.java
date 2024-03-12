import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        //输出一个字符串的所有排列组合（length=n)
        /*任选一个字符放在第一位（以交换的方式实现），有n种可能。第一个字符放好后，从剩下的字符中任选一个，放在第二位，有n-1种可能。
        以此类推，共n!种可能。字符中有相同的，还需要去重，这里只考虑所有字符都不相同的情况。 可以使用set存储字符串来去重。*/
        String str="abcd";
        displayPermutation(str);
    }
    private  void displayPermutation(String str){
        int[] sum={0};
        int l=str.length();
        char[] arr=strToarr(str,l);
        displayPermutation(arr,0,l,sum);
    }
    private  void displayPermutation(char[] chars,int i, int l,int[] sum){
        if (i==l-1) {   //递归结束
            sum[0]++;   //计数
            System.out.println(String.valueOf(chars)+" , "+sum[0]);
        }
        else{
            for(int j=i;j<l;j++){       //j从i开始，选定原字符串的第1个字符，作为第一个字符。
                swap(chars,i,j);        //任选一个字符放在第一位（以交换的方式实现）
                displayPermutation(chars,i+1,l,sum);    //选定第一个字符的每一种情况，都对子字符串重复同样的操作，所以用递归，且递归放在循环体里面
                swap(chars,i,j);        //恢复到原字符串，选定原字符串的第2个字符，作为第一个字符......
            }
        }
         
    }
    private char[] strToarr(String string,int l){   //把字符串存入字符数组，字符的移动，映射成数组下标对应的矩阵
        char[] chars=new char[l];
        for (int i = 0; i < l; i++) {
            chars[i]=string.charAt(i);
        }
        return chars;
    }
    private void swap(char[] chars,int i,int j){    //交换数组中的字符
        char temp=' ';
        temp=chars[j];
        chars[j]=chars[i];
        chars[i]=temp;
    }
    @Test
    public void test16(){
    //某个目录下的文件数目
        String dir="/users/neirong/desktop/截图1";
        System.out.println(fileSum(dir));
    }
    private int fileSum(String dir){
        File file1=new File(dir);
        return fileSum(file1,0);
    }
    private int fileSum(File file2,int sum){
        File[]files= file2.listFiles();
        for (File file : files) {
            //System.out.println(file.getName());
            if(file.isFile() && !file.getName().startsWith(".")) sum++;
            if(file.isDirectory()) return fileSum(file, sum);
        }
        return sum;
    }
    //非递归目录大小
    //递归地用一个新单词替换某个目录下的所有文件中出现的某个单词
    @Test
    public void test17(){
        //递归地找出某个目录下的所有文件中某个单词出现的次数
        String dir="/users/neirong/desktop/截图1";
        String word="the";
        System.out.println(wordSum(dir, word));
    }
    private int wordSum(String str1,String word){
        File file1=new File(str1);
        return wordSum(file1,word,0);
    } 
    private int wordSum(File file2,String word,int sum){    //统计目录下所有文件中的该单词数
        File[]files= file2.listFiles();
        for (File file : files) {
            if(file.isFile()) sum=sum+wordSum1(file, word);
            if(file.isDirectory()) return wordSum(file, word,sum);
        }
        return sum;
    } 
    private int wordSum1(File file3,String word){   //统计一个文件中的该单词数
        int count=0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file3))) {
            String line; 
            while ((line = reader.readLine()) != null) {
                // 使用 split 方法将每行按照空格分割为单词数组
                String[] words = line.split("\\s+");
                for (String w : words) {
                    // 如果单词与目标单词相同，则增加计数器
                    if (w.equals(word)) {
                        count++;
                    }
                }
            }        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
