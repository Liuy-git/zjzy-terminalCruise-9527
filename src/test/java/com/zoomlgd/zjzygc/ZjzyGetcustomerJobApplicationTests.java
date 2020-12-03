package com.zoomlgd.zjzygc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class ZjzyGetcustomerJobApplicationTests {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class Share{
        private  String  name;
        private  Integer age;
        private  String sex;

    }

    @Test
    void contextLoads() {
        List<Share> list = Arrays.asList(

                new Share("张三", 12, "男"),
                new Share("张三", 13, "男"),
                new Share("李四", 12, "男"),
                new Share("王武", 12, "男"),
                new Share("张宇", 12, "男")
        );

//        System.out.println(list.stream().filter(s -> s.getName().equals("张三")).collect(Collectors.toList()));
//        System.out.println("=================================");
//
        List<String> liststr = new ArrayList<>(Arrays.asList("==,====,=======,=========,=======,====,==".split(",")));
        liststr.forEach(System.out::println);
//
        list.forEach(System.out::println);

//        List<Share> list1 = list.stream().filter(s -> s.getName().equals("张三")).peek(s -> s.setName("张飞")).collect(Collectors.toList());
//        System.out.println("map 替换 = " + list1);

        list.stream().filter(s -> s.getAge()==12).peek(s -> s.setSex("女")).collect(Collectors.toList()).forEach(System.out::println);


    }

}
