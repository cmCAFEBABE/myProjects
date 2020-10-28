package mystudy.project_seckill_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
//@MapperScan(basePackages = "mapper")
public class ProjectSeckillServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSeckillServerApplication.class, args);
    }

}
