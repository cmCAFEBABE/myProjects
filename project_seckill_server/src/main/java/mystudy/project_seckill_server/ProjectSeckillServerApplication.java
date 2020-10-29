package mystudy.project_seckill_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "mapper")
public class ProjectSeckillServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSeckillServerApplication.class, args);
    }

}
