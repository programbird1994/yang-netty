package springboot.Configurations;

import com.huyang.netty.server.diy.DiyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ServerProperties.class)
public class ServerConfigurations {

    @Autowired
    private ServerProperties serverProperties;


    @Bean
    public DiyServer diyServer() {
        Integer port = Integer.valueOf(serverProperties.getHostPort());
        DiyServer diyServer=new DiyServer(port);
        return diyServer;
    }
}
