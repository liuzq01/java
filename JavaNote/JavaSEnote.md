
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


