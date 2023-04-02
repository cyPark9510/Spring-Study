package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        // given
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        // when
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();

        // then
        /* 출력결과
        생성자 호출, url = null
        connect: https://hello-spring.dev
        call: https://hello-spring.dev / message = 초기화 연결 메시지
        close: https://hello-spring.dev
         */
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("https://hello-spring.dev");
            return networkClient;
        }
    }
}
