package TimeTest;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class TimeTest
{
    //LocalDateTime类及其方法的测试(LocalDate、LocalTime)
    @Test
    public void test1()
    {   //now()
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
    }
    //Instant,瞬时的时间点
    @Test
    public void test2()
    {
        Instant instant=Instant.now();
        System.out.println(instant);

        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(-12)); //不同的时区有时差
        System.out.println(offsetDateTime);

        long l = instant.toEpochMilli();    //时间戳，毫秒数
        System.out.println(l);
    }
    //DateTimeFormatter
    @Test
    public void test3()
    {
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String s= dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(s);
        //解析
        String ss="2020-06-07 11:43:22";
        TemporalAccessor parse = dateTimeFormatter.parse(ss);
        System.out.println(parse );
    }
}
