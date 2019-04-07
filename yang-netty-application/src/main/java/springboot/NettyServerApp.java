package springboot;

import com.huyang.netty.client.diy.DiyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springboot.Configurations.ServerConfigurations;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ServerConfigurations.class})
public class NettyServerApp implements CommandLineRunner{

    @Autowired
    private DiyServer diyServer;


    public static void main(String [] args) {
        SpringApplication springApplication=new SpringApplication(NettyServerApp.class);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        diyServer.start();
    }
}
