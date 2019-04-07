package springboot.Configurations;

import com.huyang.netty.client.diy.DiyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@EnableConfigurationProperties(ClientProperties.class)
public class ClientConfigurations {

    @Autowired
    private ClientProperties clientProperties;

    @Bean
    public DiyClient diyClient() {
        Integer port = Integer.valueOf(clientProperties.getHostPort());
        String host = clientProperties.getHostName();
        DiyClient diyClient=new DiyClient(host,port);
        return diyClient;
    }
}
