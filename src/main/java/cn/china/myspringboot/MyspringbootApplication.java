package cn.china.myspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//exclude = DataSourceAutoConfiguration.class右键执行这个主方法，不让它自动寻找数据库
@SpringBootApplication
@MapperScan({"cn.china.myspringboot.mapper"})
public class MyspringbootApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyspringbootApplication.class, args);
    }

}
