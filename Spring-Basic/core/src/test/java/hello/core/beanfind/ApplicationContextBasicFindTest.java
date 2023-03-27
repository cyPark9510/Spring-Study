package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        // when
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("타입으로 조회")
    void findBeanByType() {
        // when
        MemberService memberService = ac.getBean(MemberService.class);

        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구현 타입으로 조회")
    void findBeanByImplementType() {
        // when
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("존재하지 않는 빈 이름 조회")
    void findBeanByName_X() {
        // when
        // then
        assertThatThrownBy(() -> ac.getBean("xxxx"))
                .isInstanceOf(NoSuchBeanDefinitionException.class);
    }
}
