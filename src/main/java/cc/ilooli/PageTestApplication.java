package cc.ilooli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cc.ilooli.common.mapper")
public class PageTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PageTestApplication.class, args);
    }

}
