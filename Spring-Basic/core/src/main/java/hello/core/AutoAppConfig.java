package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(classes = Configuration.class)
)
public class AutoAppConfig {

}
