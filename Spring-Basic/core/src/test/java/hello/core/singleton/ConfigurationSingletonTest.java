package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.order.service.OrderServiceImpl;
import hello.core.member.repository.MemberRepository;
import hello.core.member.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // when
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        // then
        // 모두 같은 인스턴스를 참고하고 있다.
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        assertThat(memberRepository1).isSameAs(memberRepository);
        assertThat(memberRepository2).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        // given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // when
        // AppConfig도 스프링 빈으로 등록된다.
        AppConfig bean = ac.getBean(AppConfig.class);

        // then
        System.out.println("bean = " + bean.getClass());
        // 출력: bean = class hello.core.AppConfig$$SpringCGLIB$$0
    }
}
