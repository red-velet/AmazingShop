package icu.chiou;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("icu.chiou.mapper")
@EnableTransactionManagement
@Slf4j
public class ShopBackendApplication {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ShopBackendApplication.class, args);
        Environment env = applicationContext.getEnvironment();
        try {
            log.info("\n❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️\n\t" +
                            "🥤应用 【{}】 启动成功! 访问连接:\n\t" +
                            "➡️项目后台: http://{}:{}\n\t" +
                            "➡️项目API文档: http://{}:{}/doc.html\n\t" +
                            "🥤项目启动总耗时: {}秒\n\t" +
                            "❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️",
                    env.getProperty("spring.application.name"),
                    env.getProperty("server.address"),
                    env.getProperty("server.port"),
                    env.getProperty("server.address"),
                    env.getProperty("server.port"),
                    (System.currentTimeMillis() - start) / 1000);
//            log.info("\n❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️\n\t" +
//                            "🥤应用 【{}】 启动成功! 访问连接:\n\t" +
//                            "➡️项目后台: http://{}:{}\n\t" +
//                            "➡️项目API文档: http://{}:{}/doc.html\n\t" +
//                            "🥤项目启动总耗时: {}秒\n\t" +
//                            "❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️❤️",
//                    env.getProperty("spring.application.name"),
//                    InetAddress.getLocalHost().getHostAddress(),
//                    env.getProperty("server.port"),
//                    InetAddress.getLocalHost().getHostAddress(),
//                    env.getProperty("server.port"),
//                    (System.currentTimeMillis() - start) / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
