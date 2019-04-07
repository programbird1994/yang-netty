package springboot;


import com.huyang.netty.client.diy.DiyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springboot.Configurations.ClientConfigurations;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ClientConfigurations.class})
public class NettyClientApp implements CommandLineRunner{

    @Autowired
    private DiyClient diyClient;

    public static void main(String [] args) {
        SpringApplication springApplication=new SpringApplication(NettyClientApp.class);
        springApplication.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        diyClient.connect("Yang spring boot test");
    }
}
