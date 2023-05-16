package minhphuc.serverjva;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("minhphuc.serverjva.mapper")
public class ServerjvaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerjvaApplication.class, args);
    }

}
