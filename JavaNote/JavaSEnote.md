
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
- [同步(*synchronized*)](#%e5%90%8c%e6%ad%a5synchronized)
- [死锁](#%e6%ad%bb%e9%94%81)
- [创建多线程的新方法](#%e5%88%9b%e5%bb%ba%e5%a4%9a%e7%ba%bf%e7%a8%8b%e7%9a%84%e6%96%b0%e6%96%b9%e6%b3%95)
- [值传递](#%e5%80%bc%e4%bc%a0%e9%80%92)
- [常用类](#%e5%b8%b8%e7%94%a8%e7%b1%bb)
- [时间、日期](#%e6%97%b6%e9%97%b4%e6%97%a5%e6%9c%9f)
- [Comparable、Comparator](#comparablecomparator)
- [Enum类](#enum%e7%b1%bb)
- [注解（*Annotation*）](#%e6%b3%a8%e8%a7%a3annotation)
- [集合](#%e9%9b%86%e5%90%88)
  - [**List**](#list)
  - [**Map**](#map)
- [Collections](#collections)
- [泛型(*generic*)](#%e6%b3%9b%e5%9e%8bgeneric)
- [IO流](#io%e6%b5%81)
- [网络编程](#%e7%bd%91%e7%bb%9c%e7%bc%96%e7%a8%8b)
- [反射](#%e5%8f%8d%e5%b0%84)
- [lambda表达式](#lambda%e8%a1%a8%e8%be%be%e5%bc%8f)

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
        
| 属性               | 方法               | 代码块                 |
| ------------------ | ------------------ | ---------------------- |
| 随着类的加载而加载 | 随着类的加载而加载 | 随着类的加载而**执行** |

### 单例模式
步骤：
- 构造器私有化，不允许在类外部创建对象
- 在类内部造一个私有的、唯一的对象
- 在类外部通过公有的方法来获取该对象

|        | 缺点             | 优点                     |
| ------ | ---------------- | ------------------------ |
| 懒汉式 | 线程不安全       | 随用随造，延迟对象的创建 |
| 饿汉式 | 对象加载时间过长 | 线程安全                 |

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
     
| 初始化常量属性 | 显示初始化                   | 代码块中           | 构造器中                                     |
| -------------- | ---------------------------- | ------------------ | -------------------------------------------- |
| 使用场景       | 所有对象的属性值相同（国籍） | 复杂的操作、判断等 | 每个对象的属性值不同，都是常量（身份证号码） |
 
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

| 编译时异常 | IOException(FileNotFoundException) | ClassNotFoundException         |                    |
| ---------- | ---------------------------------- | ------------------------------ | ------------------ |
| 运行时异常 | NullPointerException               | ArrayIndexOutOfBoundsException | ClassCastException | NumberFormatException |

- why:出异常被catch住，使得后面的代码可以继续执行
- try-catch-finally:finally{}中的语句一定会执行
- 对运行时异常往往不处理，找到错误，修改代码，解决异常
- throws 异常：暂时抛给别人，最终还得用try-catch来处理掉异常
- 方法被别的方法调用，先throws，最后再统一处理
- 手动抛异常： **throw**  new Exception()/ **throw**  new RuntimeException()    

### 多线程

| 程序（program)  | 静态的代码           |
| --------------- | -------------------- |
| 进程（process） | 运行的程序           |
| 线程（thread)   | 一个进程可有多个线程 |

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

- **同步代码块(同步法1)**
    - 同步监视器（锁）：可以是任何对象。多个线程必须共用一把锁
    - 共享变量被改变的代码需要被同步
    - 代码块包住的代码既不可多，也不可少，恰好才行
    
```
    synchronzied(锁)
{
//需要同步的代码
}

```
- **同步方法(同步法2)**
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
    - 使用Reentrantlock,把锁和对象分离(或者说没有锁的概念)

- ***Reentrantlock*(同步法3)**
    - new 一个Reentrantlock的对象p
    - p.lock()加锁，p.unlock()解锁
    - 常常借用try-finally，解锁的语句放在finally中，保证一定会解锁
    - 继承Thread类创建的多线程，p不唯一，需设为静态的
    - p不是同步监视器(此法中无此概念)，但可以当做锁来看
    
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

    - Executors的静态方法
        - newFixedThreadPool（int nThreads）
        - newSingleThreadExecutor（）
        - newCachedThreadPool（）
        - newScheduledThreadPool（int corePoolSize）
    - 步骤
        - 调用Executors的静态方法，创建线程池 service
        - 线程池对象 service 执行(execute)线程
        - 关闭线程池
        - 线程需执行的操作写在run()中，它所在的类实现了Runnable接口
```java
//    public static void main(String[] args)
//    {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);  step1. 调用Executors的静态方法，创建线程池 p
//        executorService.execute(new Even());  step2. 线程池对象 p 执行(execute)线程
//        executorService.shutdown();           step3. 关闭线程池
//    }

class Even implements Runnable
{
    @Override
    public void run()      // step4. 线程需执行的操作写在run()中，它所在的类实现了Runnable接口
    {
        //...
    }
}
```
    - 优点
        - 提高线程的重复利用率，效率高，节约内存
        - Executors功能更丰富，便于线程的管理
        
```
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executorService1 = (ThreadPoolExecutor) executorService;   //转换为ThreadPoolExecutor类型后，
        executorService1.setCorePoolSize(15);                                           可设置、管理线程池
```

### 值传递

- function(int a){...}    基本数据类型，传递的是值

- function(String a){...}     引用数据类型，传递的是地址值？不是a指向的对象？

### 常用类
- String
    - String s1="abc";     //"abc" 存储在方法区的常量池中，仅有一份
    - String s3=new String("abc");   //new String("abc")存储在堆中
    - String s4="ab"+"cd";      //存储在常量池中
    - String s5=s1+"cd";(String s1="ab")  //有变量s1参与，存储在堆中

- StringBuffer、StringBuilder
    - String: 不可变的字符序列，底层使用char[]存储
    - StringBuffer：可变的字符序列，线程安全，效率低，底层用char[]存储
    - StringBuilder：可变的字符序列，线程不安全，效率高，底层用char[]存储
    
### 时间、日期

- jdk 8 之前的API
    - System.currentTimeMillis()(系统时间以毫秒展示)
    - java.util.Date(过时),java.sql.Date
    - SimpleDateFormat(格式化：日期-->字符串；解析：字符串-->日期)
    - Calendar(也不好用)
    
- jdk 8
    - 类：**LocalDateTime**(LocalDate、LocalTime)
        - 实例化(静态方法)
            - LocalDateTime.of()：设置指定时间日期，获取对象
            - LocalDateTime.now():获取当前时间日期的对象
        - 方法：getXxx()
        - 设置时间、日期：withXxx()
```
        //now()
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
        //of()
        LocalDateTime localDateTime1=LocalDateTime.of(2020,5,1,14,30);
        System.out.println(localDateTime1);
        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        //设置时间、日期：withXxx()
        // （不可变性）
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(17);
        System.out.println(localDateTime2);
        System.out.println(localDateTime);
```  
  
- Instant: 时间戳的类
    - Instant.now()：实例化/获取当前时间的对象
    - toEpochMilli()：时间戳，毫秒数
        
```
        Instant instant=Instant.now();      //实例化/获取当前时间的对象
        System.out.println(instant);
        long l = instant.toEpochMilli();    //时间戳，毫秒数
        System.out.println(l);

```        
        
- DateTimeFormatter
    - 实例化
        - DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss E")
    - 格式化(日期-->字符串)  
        - format()  
    - 解析(字符串-->日期)
        - parse()

```
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String s= dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(s);
        //解析
        String ss="2020-06-07 11:43:22";
        TemporalAccessor parse = dateTimeFormatter.parse(ss);
        System.out.println(parse );

```

### Comparable、Comparator

- Comparable
    - 自然排序(假设需要排序的数组为array)
    - 自定义类(Class A)需实现Comparable，并重写**compareTo**(),才能进行排序
    - Arrays.sort(array)
    
```
    @Override       //重写compareTo()方法
    public int **compareTo**(Object o)
    {
        if (o instanceof Goods)
        {
            Goods goods = (Goods) o;
            if (this.price < goods.price) return -1;
            if (this.price == goods.price) return 0;
            if (this.price > goods.price) return 1;

            //或者   return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("输入数据有误");
    }

```    
    
- Comparator
    - 自定义排序（临时性质的，每次指定排序规则）
    - 匿名类的匿名对象：a=new Comparator(){...}，重写**compare**(Object o1,Object o2)
    - Arrays.sort(array,a)
    
### Enum类

- 步骤
    - 给出枚举的对象，用逗号隔开
    - 私有化属性，并设为常量
    - 私有化构造器

```
    //enum修饰类名
enum Season
{
    //给出枚举的对象，用逗号隔开
    SPRING("春天","暖"),
    SUMMER("夏天","热"),
    FALL("秋天","凉"),
    WINTER("冬天","冷");

    //私有化属性，并设为常量
    private final String name;
    private final  String describe;

    //私有化构造器
 private  Season(String name , String describe)
    {
        this.name=name;
        this.describe=describe;
    }
    ...
        //通过类直接调用枚举对象
        System.out.println(Season.SPRING);
```

- 常用静态方法
    - values()：返回包含所有枚举对象的数组
    - valueOf(str)：返回名为str的枚举对象

- 用enum定义的枚举类实现接口
    - 可像普通类那样重写接口的抽象方法
    - 也可以对每个枚举对象，分别重写其抽象方法
    
### 注解（*Annotation*）

- 注解是一种标记，其作用类似于配置文件。在框架中通过反射读取注解，从而确定如何执行代码。
- 元注解
    - Retention:指定Annotation的生命周期(Source/Class/Runtime)
    - Target:指定Annotation可以修饰的结构(FIELD, METHOD, PARAMETER, CONSTRUCTOR...)
    - Documented
    - Inherited
    
```
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.SOURCE)
public @interface SuppressWarnings {

    String[] value();
}
```

### 集合
- Collection接口：存储一个一个的对象
    - list:有序可重复("动态"数组)
        -ArrayList
        - LinkedList
        - Vector
    - set：无序不可重复(数学定义中的"集合")
        - HashSet
        - LinkedHashSet
        - TreeSet
    - 常用方法
        - size(),add(),addAll(),clear(),isEmpty()
        - contains(new A())： A需重写equals()方法    
        - remove(a)：A需重写equals()方法
        - coll.removeAll(collection)
            - collection包含a ，A需重写equals()方法
            - 取差集并赋值给原集合:coll=coll-collection
        - A.retainAll(B)： 取交集并赋值给A，A=A∩B (对于list，取交集后可能有重复的元素，不是严格的数学定义上的交集)
        - equals():比较两个集合是否相同，比较的是元素。对于list，元素相同，顺序不同，返回false。
        - toArray(),Arrays.asList()
        
- Map接口：存储一对一对（key-value）的数据（类似于数学定义上的映射）
    - HashMap
    - LinkedHashMap
    - TreeMap
    - Hashtable
    - Properties
- Iterator 
    - 用于遍历Collection(非Map，Map的keySet、entrySet可以)
    - iterator() <-- iterator
    - iterator.hasNext()
    - iterator.next()
    - iterator.remove()
    
```
//不涉及集合的细节
    Iterator iterator=collection.iterator();
    while(iterator.hasNext())
        {
            System.out.println(iterator.next()); 
        }
    这时候指针已经到容器底部了，再次遍历，需生成新的iterator对象
    iterator=collection.iterator();
```
#### **List**
    - ArrayList
        - 常用，线程不安全，效率高，底层用Object[]存储
    - LinkedList
        - 插入、删除数据时常用，底层用双向链表存储
    - Vector
    - 方法(Collection的方法也可以用)
        - size,add,addAll
        - remove(index)
        - set
        - get(index)
        - indexOf(obj),lastIndexOf(obj)
        - subList
#### **Map**
    - HashMap
        - 常用，线程不安全，效率高；可存储<null,null>
    - LinkedHashMap
        - HashMap的子类，可按添加的顺序遍历元素，适用于频繁遍历的情况
    - TreeMap
        - 存储方式为红黑树，可按添加的顺序排序、遍历
    - Hashtable
    - Properties
        - 处理配置文件
- <key,value>
    - key是无序不可重复的，用set来存；value无序可重复
    - node<key,value>是Map的存储单位，无序不可重复
    - 对于HashMap，key所在的类需重写equals()和hashCode()，value所在的类需重写equals()
    
- HashMap的底层实现原理
    - 存储结构：数组+链表+红黑树
```
        HashMap hashMap= new HashMap(); //实例化时没创建数组
        ...
        hashMap.put(key,value1);     //创建一个长度16的Node[]
        hashMap.put(key,value);     //替换了(key,value1)，视为修改了元素
```    
        
    - 计算key的hash值，找到Node[]上对应的位置，没有元素，这一对(key,value)添加成功；
    - 有元素，该位置上的元素以链表的方式存储。需要把新元素与链表上的所有元素做对比，比较两者的key的hash值，都不相同，添加成功；
    - 有相同的，调用equals()比较两者的key，不同，添加成功；
    - 相同，以新的(key,value)替换掉原来的(key,value1)，相当于修改了元素。
    - 缺点：需要遍历链表上所有的元素并逐个做对比，当元素过多，效率变低
    - 解决方法：当链表上的元素 >8 && Node[]的元素 > 64，不用链表，改为红黑树
    - 扩容：默认为原来的2倍，把原数组的元素都复制到新数组来
    - CAPACITY(起始默认容量):16,FACTOR(加载因子):0.75,threshold(扩容临界值):16*0.75=12

- Map常用方法 
    - 增、删、改
        - put,putAll,remove,clear
    - 查
        - get,containsKey,containsValue,size,isEmpty,equals
    - 元视图操作方法(可借用Iterator遍历Map)
        - keySet：返回一个Set集合,包含所有的key
        - values：返回一个Collection集合，包含所有的value
        - entrySet:返回一个Set集合,包含所有的(key,value)对
    - TreeMap、TreeSet排序
        - 需借用Comparable、Comparator
        - TreeMap的key必须属于同一个类，才可以按key排序，无法按value排序
        
    
- Set
     - HashSet
        - 常用，线程不安全，效率高,可存储null值，适用于快速查找元素，无需和所有元素作比较
     - LinkedHashSet
        - HashSet的子类，可按添加的顺序遍历元素
     - TreeSet
        - 所有元素必须属于同一个类，可按照对象的属性排序
     - 无序不可重复
        - 无序：元素的存储位置由hash值确定，与添加的先后顺序无关 
        - 不可重复：用equals()和hashCode()判断元素是否重复
            - 元素所属的类A重写了equals()和hashCode()，多次new A()一般来说是重复的元素
            - 没重写或只重写了equals()，多次new A()不是重复的元素
            - 数学定义中的"集合"是理想情况，Set达不到，例子见HashSetTest
        - 只用equals()判断是否重复的缺点：新元素需要与所有元素都比较一遍，效率低
### Collections
    - 操作List、Set、Map等集合的工具类
    - 提供了一些静态方法，可对集合中的元素进行改、查、排等操作
    - Arrays是操作数组的工具类
- 常用方法
    - List
        - reverse,sort,copy,replaceAll
        - shuffle:随机排序
        - swap:交换位置
    - Collection
        - max,min,frequency
    - sort,min,max,涉及比较、排序，需要元素都是同一个类的
    - 把List、Set、Map变成线程安全的
        - Collections.synchronizedList(),Collections.synchronizedMap(),Collections.synchronizedSet()
        
### 泛型(*generic*)

- 泛型 
    - 指定集合中元素的类型(都是引用数据类型)，安全，便于排序
    - 静态方法中不能调用带泛型的属性：泛型在类的实例化时才指定具体类型，晚于静态方法的加载
    - 适用范围：集合
- 泛型方法
    - 使用场景：不确定传入参数的类型
    - 优点：提高方法的通用性
    - 泛型方法调用时，指明其具体类型，跟实例化无关，故泛型方法可以是静态的
    - 泛型方法的泛型参数，跟它所在类的泛型参数无关
```java
HashMap<String,Integer> hashmap=new HashMap<>();
```
- 自定义泛型类
    - 使用场景：不确定类的某一属性的类型
```java
//定义类型T
public class Student<T>
{
    private String name;
    private int age;
    private T id;
      ...
    //泛型方法，这里是E，跟T没关系(可以是静态的)
    public <E> List<E> copyArraytoList(E[] array)
    {
        ArrayList<E> list=new ArrayList<>();
        for(E e:array)
        {
            list.add(e);
        }
        return list;
    }

      ...
}
    
//实例化时指定T的具体类型(假设为String)
        Student<String> stu= new Student<>("liu",2,"007");
        stu.setId("996");   //相关方法的参数只能为String
          ...
        Integer[] array=new Integer[]{1,2,3};
//泛型方法调用时，指明其具体类型(假设为Integer)，跟类型T没有关系
//(跟实例化没关系，所以泛型方法可以是静态的)
        List<Integer> integers = student.copyArraytoList(array);
        System.out.println(integers);
        ...
//子类继承泛型类时，指定了类型(假设为Integer)，则子类为普通类
    public class SubStudent extends Student<Integer>
    {
        ...
    }
    //子类可以保留泛型
    public class SubStudent<T> extends Student<T>
    {
        ...
    }
```
- 通配符 ?
    - ArrayList<?>是ArrayList<String>、ArrayList<Object>的父类，可以用多态写通用方法
- 有限制的通配符 
    - List<? extends Person>是List<Person>、List<Student>的父类(Student是Person的子类)
        - 可读不可写
    - List<? super Person>是List<Person>、List<Object>的父类
        - 可读可写( 可add (Person及Person子类的对象) )
```java
 @Test
    public void test()
    {
        ArrayList<String> list1 =new ArrayList<>();
        ArrayList<Object> list2 =new ArrayList<>();
//        ArrayList<?> list =new ArrayList<>();
        list1.add("2333");list1.add("666");list2.add(22);list2.add(88);
//        list2=list1; 不可以
//        list=list1; //可以
//        list=list2; //可以
        WildcardTest.traverseList(list1);
        WildcardTest.traverseList(list2);
    }

    list1 和 list2 都可以调用的通用方法
    public static void traverseList(ArrayList<?> list)
    {
//        Iterator<?> iterator = list.iterator();
//            while (iterator.hasNext())
//            {
//                System.out.println(iterator.next());
//            }
        for (Object arr:list)
        {
            System.out.println(arr); //无法add元素，可以get元素(可读不可写)
        }
    } 
```
### IO流
- File类实例化
    - File的对象是文件或文件夹
```java
        File file = new File("helloTest.txt");  //文件
        File file2 =new File("D:/GithubRepository/java/Exercise");  //文件夹
```
- File类常用方法
    - getAbsolutePath,getPath,getName,getParent
    - length,lastModified,renameTo，delete,createNewFile
    - list(),listFiles():返回所有的文件和文件夹
    - isDirectory(),isFile(),exists(),canRead(),canWrite(),isHidden()
    - mkdir;mkdirs:创建目录，上层目录不存在，不创建；创建
    - 目录下有文件，无法删除该目录，需先删除所有文件，再遍历目录并由里到外删除所有目录
    
- IO流
    - 字节流(1B),字符流(2B ? )
    - 输入流，输出流
    - 节点=流，处理流
    
| 抽象基类 | 字节流       | 字符流 |
| -------- | ------------ | ------ |
| 输入流   | InputStream  | Reader |
| 输出流   | OutputStream | Writer |

| 分类       | 字节输入流              | 字节输出流               | 字符输入流            | 字符输出流             |
| ---------- | ----------------------- | ------------------------ | --------------------- | ---------------------- |
| 抽象基类   | ==InputStream==         | ==OutputStream==         | ==Reader==            | ==Writer==             |
| 访问文件   | ==FileInputStream==     | ==FileOutputStream==     | ==FileReader==        | ==FileWriter==         |
| 访问数组   | ByteArrayInputStream    | ByteArrayOutputStream    | CharArrayReader       | CharArrayWriter        |
| 访问管道   | PipedInputStream        | PipedOutputStream        | PipedReader           | PipedWriter            |
| 访问字符串 |                         |                          | StringReader          | StringWriter           |
| 缓冲流     | ==BufferedInputStream== | ==BufferedOutputStream== | ==BufferedReader==    | ==BufferedWriter==     |
| 转换流     |                         |                          | ==InputStreamReader== | ==OutputStreamWriter== |
| 对象流     | ==ObjectInputStream==   | ==ObjectOutputStream==   |                       |                        |
|            | FilterInputStream       | FilterOutputStream       | FilterReader          | FilterWriter           |
| 打印流     |                         | PrintStream              |                       | PrintWriter            |
| 推回输入流 | PushbackInputStream     |                          | PushbackReader        |                        |
| 特殊流     | DataInputStream         | DataOutputStream         |                       |                        |

- 文件流
    - FileReader、FileWriter、FileInputStream、FileOutputStream
    - 文件对象-->文件流对象-->读入或写出-->关闭文件流
    - 字符流只可以处理字符类文件，对图片、视频等字节文件无效
    - 方法
        - read():每次读一个字符，以数字的形式返回该字符
        - read(char[] char):读字符存入char，每次存满，存了几个作为返回值
        - write():写出str到文件，不存在会自动创建
```java
        File file=new File("D:\\a新建文件夹\\Java学习笔记\\file\\testDir\\regret.txt");
        FileWriter fileWriter = new FileWriter(file,true);//true:追加而不覆盖原文件；false:覆盖
        fileWriter.write("liu");
        fileWriter.write("zhiQiang");
        fileWriter.close();
```
 
### 网络编程

### 反射

### lambda表达式