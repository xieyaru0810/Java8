package com.tydic.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class TestDateLocalTime {




    @Test
    public void test4() {
        //ZoneDate\ZoneTime\ZoneDateTime
//        Set<String> set = ZoneId.getAvailableZoneIds();
//        set.forEach(System.out::println);//遍历所有的时区 Asia/Shanghai

        LocalDateTime l1= LocalDateTime.now(ZoneId.of("Europe/Chisinau"));
        System.out.println(l1);
        LocalDateTime l = LocalDateTime.now(ZoneId.of("Europe/Chisinau"));
        ZonedDateTime z= l.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(z);
        //2018-12-26T11:20:40.467
        //2018-12-26T11:20:40.486+08:00[Asia/Shanghai]

    }
     @Test
    public void test3() {
        //时间日期格式化
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ld = LocalDateTime.now();
        String s0 = ld.format(dtf);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String s1 = ld.format(dtf2);

//       LocalDateTime l = LocalDateTime.parse(s1,dtf2);//还原成之前的格式
       LocalDateTime l = ld.parse(s1,dtf2);//还原成之前的格式
        System.out.println(s0);
        System.out.println(s1);
        System.out.println(l);
        //2018-12-26
        //2018年12月26日 17:03:05
    }

    @Test
    public void test2() {
        //Temporal Adjuster :时间校正器
        LocalDateTime l1 = LocalDateTime.now();
        System.out.println(l1);

        LocalDateTime l2 = l1.withDayOfMonth(2);
        System.out.println(l2);

        LocalDateTime l3 = l1.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println(l3);
        //2018-12-26
        //2018-12-02
        //2019-01-02

        //自定义下一个工作日
        LocalDateTime l4 = l1.with((l)->{
            LocalDateTime ld = (LocalDateTime)l;
            DayOfWeek d = ld.getDayOfWeek();
            if(d.equals(DayOfWeek.SUNDAY)){
                return ld.plusDays(1);
            }else if(d.equals(DayOfWeek.WEDNESDAY)){
                return ld.plusDays(2);
            }else{
                return ld.plusDays(3);
            }
        });
        System.out.println(l4);
    }

    @Test
    public void test1(){
        //当前时间、偏移、毫秒、推迟1000毫秒
        Instant ins = Instant.now();//默认获取UTC时区
        System.out.println(ins);
        OffsetDateTime of = ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(of);
        //2018-12-26T08:04:41.783Z
        //2018-12-26T16:04:41.783+08:00
        System.out.println(of.toEpochSecond());//1545811663  毫秒
        Instant ins1 = Instant.ofEpochMilli(1000);
        System.out.println(ins1);//距离1970-1-1  00：00：00 开始的1000秒

        /*
        时间和 日期的间隔：
        Duration
        Period
         */

        //时间戳间隔：
        Instant i1  = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant i2  = Instant.now();
        //毫秒 使用toMillis  秒和纳秒使用get,
        System.out.println(Duration.between(i1,i2).toMillis());//不调用方法：get..；  PT1.003S 这个是IOS显示的时间。

        LocalTime ldt =LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime dt =LocalTime.now();
        System.out.println(Duration.between(ldt,dt).toMillis());//1015  显然上面的时间 更准确。

        //天数间隔
        LocalDate l = LocalDate.of(2018,12,2);
        LocalDate l1 = LocalDate.now();
        System.out.println(Period.between(l,l1).getDays());
    }
}
