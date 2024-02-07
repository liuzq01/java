import java.io.File;
import org.junit.Test;

public class RecursiveExercise1 {
    @Test
    public void test(){
        //二分查找
        RecursiveExercise rec=new RecursiveExercise();
        //int[] arr = rec.generateArrary();
        int[]arr={32, 67 ,81 ,10 ,18 ,43 ,20, 7 ,42 ,72, 9 ,60 ,53 ,14 ,17, 74 ,91 ,36 ,50 ,91};
        rec.recursiveInsertSort(arr);
        int target=20;
        int index = recrusiveBinarySort(arr, target);
        if (index==-1) {
            System.out.println("查无此数");
        }
        else System.out.println("位置是： "+index);
        rec.printArrary(arr);
    }
    public int recrusiveBinarySort(int[]a, int target){
        return recrusiveBinarySort(a, 0, a.length-1, target);
    }
    private int recrusiveBinarySort(int[] a, int left, int right,int target){
        int middle=(left+right)/2;
        int index=0;
        if (left<=right) {
            if (target==a[middle]) {
                index=middle;
            }
            else if (target<a[middle]) {
                return recrusiveBinarySort(a, left, middle-1, target);
            }
            else {
                return recrusiveBinarySort(a, middle+1, right, target);
            }
            }
        else index=-1;
        return index;
    }
    @Test
    public void test1(){
        //计算目录的大小
        File file=new File("/users/neirong/desktop/oss-browser-darwin-x64");
        float size=getSize(file);
        System.out.println(size);
    }
    private float getSize(File file){
        File[] files= file.listFiles();
        float size=0;
        for (File file2 : files) {
            if (file2.isFile()) {
                size=size+file2.length();
            }
            if (file2.isDirectory()) {
                size=size+getSize(file2);
            }
        }
        return size;
    }
    @Test
    public void test2(){
        //han nuo 塔
        hTower(4);
    }
    public void hTower(int n){
        hTower(n, 'A', 'B', 'C');
    }
    private void hTower(int n,char from,char temp, char to){
        if (n>=2) {
            hTower(n-1, from, to, temp);
            //hTower(1, from, temp, to);
            System.out.println(n+", "+from+" -> "+to);
            hTower(n-1, temp, from, to);
            }
        if (n==1) {
            System.out.println(n+", "+from+" -> "+to);//hTower(1, from, temp, to)就是移动一步，用打印出来代替它
        }
    }
    @Test
    public void test3(){
        //尾递归写阶乘函数
        System.out.println(factorial(6));
    }
    public int factorial(int n){
        return factorial(n, 1); //初始化s（s用来存储阶乘的结果）
    }
    private int factorial(int n,int s){
        if (n==0) return s;
        else if(n>=1) {
            s=n*s;
            return factorial(n-1,s);    //factorial函数只起到「赋值」作用：n=n-1, s=s;
        }
        else return -1;
    }
    @Test
    public void test4(){
        //尾递归写斐波那契函数
        System.out.println(fib(10));
    }
    public int fib(int n){
        int[] f =new int[n+1];
        f[0]=0; f[1]=1;
        return fib(2, n,f); 
        }
    private int fib(int i, int s, int[] f){
        f[i]=f[i-1]+f[i-2];
        if(i>s-1) return f[s];
        else return fib(i+1,s,f);
    }
}
