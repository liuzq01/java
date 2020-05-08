
<!-- @import "[TOC]" {cmd="toc" depthFrom=1 depthTo=6 orderedList=false} -->

<!-- code_chunk_output -->

- [继承  (inheritance)](#%e7%bb%a7%e6%89%bf-inheritance)
- [重写  （overwrite）](#%e9%87%8d%e5%86%99-overwrite)
- [权限修饰符](#%e6%9d%83%e9%99%90%e4%bf%ae%e9%a5%b0%e7%ac%a6)
- [super 关键字](#super-%e5%85%b3%e9%94%ae%e5%ad%97)
- [super 与 this](#super-%e4%b8%8e-this)
- [多态  （polymorphism）](#%e5%a4%9a%e6%80%81-polymorphism)
- [包装类、基本数据类型、toString的转换](#%e5%8c%85%e8%a3%85%e7%b1%bb%e5%9f%ba%e6%9c%ac%e6%95%b0%e6%8d%ae%e7%b1%bb%e5%9e%8btostring%e7%9a%84%e8%bd%ac%e6%8d%a2)
- [static 关键字、变量的分类](#static-%e5%85%b3%e9%94%ae%e5%ad%97%e5%8f%98%e9%87%8f%e7%9a%84%e5%88%86%e7%b1%bb)
- [单例模式](#%e5%8d%95%e4%be%8b%e6%a8%a1%e5%bc%8f)
- [代码块](#%e4%bb%a3%e7%a0%81%e5%9d%97)
- [final](#final)
- [抽象类、抽象方法 (*abstract*)](#%e6%8a%bd%e8%b1%a1%e7%b1%bb%e6%8a%bd%e8%b1%a1%e6%96%b9%e6%b3%95-abstract)
- [接口（interface）](#%e6%8e%a5%e5%8f%a3interface)
- [异常（*Exception*)](#%e5%bc%82%e5%b8%b8exception)
- [多线程](#%e5%a4%9a%e7%ba%bf%e7%a8%8b)

<!-- /code_chunk_output -->

### 继承  (inheritance)

    语法：**class A extends B {}**

    特点：
  
    1. A 继承了 B 所有的属性、方法; B 私有的，A可以通过方法间接调用；
    
    2. 单继承性：1个子类只能有1个直接父类；
    
    3. 子类获取了其直接父类和所有间接父类的的属性和方法

### 重写  （overwrite）

    *重写：子类重写父类中已有的方法*

    方法的声明：权限修饰符 返回值类型 方法名 （参数）{方法体}

    1.子父类的方法名、形参列表相同
    2.权限修饰符：子类 >= 父类
        p.s. 子类不能重写父类 ==private==的方法
    3.返回值类型：
        -父类void,子类也必须是void
        -父类是A类型（Object），子类是A或A的子类(Object,String...)
        -父类是基本数据类型（double），子类与其相同(double,不能是其它的，int,float等不行)
    4.静态（**static**）的方法随着类的加载而加载，不能被重写

### 权限修饰符

|           | 类内部 | 同一个包 | 不同包的子类 | 整个工程 |
| --------- | ------ | -------- | ------------ | -------- |
| private   | yes    |          |              |          |
| 缺省      | yes    | yes      |              |          |
| protected | yes    | yes      | yes          |          |
| public    | yes    | yes      | yes          | yes      |

### super 关键字

super: **在子类中**调用父类的属性、方法、构造器。
适用范围：子类
    
- *属性*（可忽略）：
        1. 子父类有同名的：super.属性 --> 父类的
                          this.属性 --> 子类的
        2.子父类不同名的： 可以用上面的用法，可以省略super、this，直接调用
                          前提是权限够。但是通常封装属性，用get方法调用。
    
- **方法**： 跟属性类似
    
- **构造器**：  
              1. super() --> 父类的空参构造器          
              2. super(形参) --> 父类对应参数的构造器 
              3. super(形参)、this(形参)必须声明在构造器的首行,只能2选1
              4. 子类每个构造器的首行，自动隐式调用super()

### super 与 this

        super: 1. 父类被重写的方法 2. 父类的构造器
        this:  1. 当前方法的对象   2. 当前类重载的构造器

### 多态  （polymorphism）

    定义：子类对象赋给父类的引用，eg: `< Person man=new Man(); >`

    适用范围：方法。不适用于属性。方法体中不能调用父类的静态or私有的方法，它们不能重写。

    多态的前提：继承、重写。
    
    好处：提高方法的通用性。方法**A**的形参是父类的对象，它的方法体中调用的也是父类的
          一些方法，并且子类重写了这些的方法。那么，子类的对象B也可以使用方法A，也就是
          说，把B当作形参传给A，实际执行的是子类重写的那些方法。这样就不用再专门给每一
          个子类写相应的方法了，都使用方法A就行了。方法A不仅适用于父类，也适用于它所有
          子类的对象，提高了通用性。

### 包装类、基本数据类型、toString的转换

- 包装类 <--> 基本数据类型

            int a = 10;
            Integer b = a;  //自动装箱
            int c = b;      //自动拆箱

- 包装类、基本数据类型 <--> toString

        int b=10; (or Integer b= new Integer();)
    
        String a = String.valueOf(b); // b 是基本数据类型或包装类
    
        Integer c = Integer.parseInt(str);

- 八种基本数据类型

| 基本数据类型 | 包装类    |
| ------------ | --------- |
| char         | Character |
| byte         | Byte      |
| int          | Integer   |
| short        | Short     |
| long         | Long      |
| float        | Float     |
| double       | Double    |
| boolean      | Boolean   |

### static 关键字、变量的分类

- 变量：实例变量（属性）、静态变量、局部变量
  - 实例变量：随着对象的创建而加载
  - 静态变量：随着类的加载而加载，只加载一次，在内存中仅存一份

```
        private String name;   //实例变量name
        private int    age;    //实例变量age
        private static String nation="CN";  //静态变量nation
        public void setAge(int age){}       //局部变量age
        Integer a = new Integer(2);         //局部变量a
```

- 变量在内存中的位置

| 实例变量 | 静态变量 | 局部变量   |
| -------- | -------- | ---------- |
| 堆(heap) | 静态域   | 栈（stack) |

- static
    
    static可修饰：属性、方法、代码块
    
        - static修饰的方法中，只能调用静态的方法or属性
        
        - static修饰的方法中，不能使用this、super(没有对象)
        
| 属性 | 方法 | 代码块   |
| -------- | -------- | ---------- |
| 随着类的加载而加载 | 随着类的加载而加载| 随着类的加载而**执行** |

### 单例模式
步骤：
- 构造器私有化，不允许在类外部创建对象
- 在类内部造一个私有的、唯一的对象
- 在类外部通过公有的方法来获取该对象

|   |缺点|优点|
| -------- | -------- | -------- | 
| 懒汉式| 线程不安全 |随用随造，延迟对象的创建|
| 饿汉式 | 对象加载时间过长|线程安全|

### 代码块
- 静态代码块
    - 随着类的加载而执行，只执行一次
    - 作用：初始化类的信息
- 非静态代码块
    - 随着对象的加载而执行，每new一个对象，就执行一次
    - 作用：初始化对象的属性
- 属性可被赋值的位置
    - 默认初始化     //int a;
    - 显示初始化     //int a=1;
    - 代码块内初始化
     - 构造器初始化 
    - set方法

### final

可修饰：
- 类：不能被继承 （String)
- 方法：不能被重写 （Object类的getClass（））
- 变量 --> 常量
    - 属性：可以初始化赋值的位置：显示初始化、代码块中初始化、构造器中初始化
    - 局部变量：常量，不可再被修改、赋值
    - 静态变量： 全局常量
     
|  初始化常量属性 | 显示初始化| 代码块中| 构造器中|
| -------- | -------- | -------- |---- |
| 使用场景| 所有对象的属性值相同（国籍） |复杂的操作、判断等| 每个对象的属性值不同，都是常量（身份证号码）|
 
### 抽象类、抽象方法 (*abstract*)

- 抽象类：public abstract class Person(){}
    - 没有对象，不可实例化
    - 必定有构造器，便于子类对象的全实例化
    - 必定有子类，子类对象实例化，实现相关功能
    
- 抽象方法：public abstract void aFunction();
    - 没有方法体~~{}~~
    - 有抽象方法的类一定是抽象类，从而实现无对象调此方法
    - 抽象类中可以有普通方法
    - 子类若想变成普通类，必须重写所有父类的所有抽象方法，否则因继承了抽象方法，它还是抽象类
    
### 接口（interface）
      
- 成员： 全局常量、抽象方法、静态方法、默认方法
- 实现： 由类来实现接口，类必须实现接口的所有抽象方法，否则它是抽象类
- 多实现：1个类可以实现多个接口      
- 多继承： 接口之间可以继承，可以多继承
- 接口的使用，体现了多态
- 接口中的静态方法：只能通过接口调用，对实现类不可见
- 接口冲突：实现类实现了多个接口中都定义了同名同参的**默认方法**，在实现类中重写此默认方法，可解决冲突

### 异常（*Exception*)
- 常见异常

| 编译时异常|IOException(FileNotFoundException) |ClassNotFoundException | |
|--- |--- |--- |--- |
| 运行时异常| NullPointerException| ArrayIndexOutOfBoundsException| ClassCastException| NumberFormatException|

- try-catch-finally:finally{}中的语句一定会执行
- 对运行时异常往往不处理，找到错误，修改代码，解决异常
- throws 异常：暂时抛给别人，最终还得用try-catch来处理掉异常
- 方法被别的方法调用，先throws，最后再统一处理
- 手动抛异常： **throw**  new Exception()/ **throw**  new RuntimeException()    

### 多线程

|程序（program)|静态的代码|
|---|---|
|进程（process）|运行的程序|
|线程（thread)|一个进程可有多个线程|

    P.S. Java程序至少具有3个线程：main()的主线程、Exception相关的线程、垃圾回收器的线程

**创建多线程的2种方法**

1. 继承Thread类
    - 重写run()
    - new一个该类的对象 p
    - 启动线程：p.start()

``` 
            a. 继承Thread类
class PrimeThread extends Thread {
         long minPrime;
         PrimeThread(long minPrime) {
             this.minPrime = minPrime;
         }
            b. 重写run()
         public void run() {
             // compute primes larger than minPrime
              . . .
         }
     }
              . . .

     PrimeThread p = new PrimeThread(143);  c. new一个该类的对象 p
     p.start();                             d. 启动线程：p.start()
```

2. 实现Runnable接口
    - 重写run（）
    - new一个该实现类的对象 p
    - 启动线程：new Thread(p).start()
```
              a.实现Runnable接口
class PrimeRun implements Runnable {
         long minPrime;
         PrimeRun(long minPrime) {
             this.minPrime = minPrime;
         }
              b.重写run（）
         public void run() {
             // compute primes larger than minPrime
              . . .
         }
     }
              . . .
        PrimeRun p = new PrimeRun(143); c. new一个该类的对象 p
        new Thread(p).start();          d. 启动线程：new Thread(p).start()

```
### 同步(*synchronized*)

- 同步代码块(同步法1)
    - 同步监视器（锁）：可以是任何对象。多个线程必须共用一把锁
    - 共享变量被改变的代码需要被同步
    - 代码块包住的代码既不可多，也不可少，恰好才行
    
```
    synchronzied(锁)
{
//需要同步的代码
}

```
- 同步方法(同步法2)
    - 非静态方法：锁是当前对象(this)，可能不唯一，需将被同步的方法改成静态的
    - 静态方法：锁是当前的类
    
### 死锁

- 死锁的原因(出现在**同步方法**中)
    - 线程A存在同步方法的嵌套(m-->n)：对象m调用同步方法F1(锁是m)，在F1的方法体中，对象n调用方法F2(锁是n)
    - 线程B与A相反(n-->m)，对象n调用同步方法T1，T1中m调方法T2
    - A和B都等对方释放自己所需的锁，陷入死锁状态
- 解决方法
    - 改变算法，避免m到n，n到m的顺序同时出现
    - 避免同步方法的嵌套
    - 使用Reentrantlock,把锁和对象分离

- *Reentrantlock*(同步法3)
    - new 一个Reentrantlock的对象p
    - p.lock()加锁，p.unlock()解锁
    - 常常借用try-finally，解锁的语句放在finally中，保证一定会解锁
    - 继承Thread类创建的多线程，p不唯一，需设为静态的
    
- 线程通信
    - 可联合使用notify()-wait()
    - 使用范围：同步代码块、同步方法的方法体中
    - 调用两方法的对象是当前的同步监视器
    - notify():唤醒被wait的线程，wait():当前线程进入阻塞状态，并释放锁

### 创建多线程的新方法

- 实现Callable接口
    - 实现call()方法(将该线程执行的操作放在call方法中)
    - new一个该实现类的对象 p
    - q = new FutureTask(p)
    - new Thread(q).start()
    
    优点：
    - *q.get()可以获取call()的返回值*
    - *call()可以抛异常*
    - *Callable接口支持泛型*
    
- **使用线程池**





