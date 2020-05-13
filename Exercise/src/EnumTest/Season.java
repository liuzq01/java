package EnumTest;

import java.security.Principal;
    //enum修饰类
enum Season
{
    //给出枚举的对象，用逗号隔开
    SPRING("春天","暖"),
    SUMMER("夏天","热"),
    FALL("秋天","凉"),
    WINTER("冬天","冷");

    //私有化属性，并设置为常量
    private final String name;
    private final  String describe;

    //私有化构造器
 private  Season(String name , String describe)
    {
        this.name=name;
        this.describe=describe;
    }

    public String getName()
    {
        return name;
    }

    public String getDescribe()
    {
        return describe;
    }

//    @Override       //可重写，也可以不重写，父类Enum已经重写过了
//    public String toString()
//    {
//        return "Season{" +
//                "name='" + name + '\'' +
//                ", describe='" + describe + '\'' +
//                '}';
//    }
}
