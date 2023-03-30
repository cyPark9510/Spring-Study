package hello.core;

import hello.core.order.service.OrderService;
import hello.core.order.service.OrderServiceImpl;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.MemoryMemberRepository;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository(), new RateDiscountPolicy()

    // 예상 log
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.memberRepository
    // call AppConfig.discountPolicy
    // call AppConfig.memberRepository
    // call AppConfig.discountPolicy

    // 실제 log
    // call AppConfig.memberService
    // call AppConfig.memberRepository
    // call AppConfig.orderService
    // call AppConfig.discountPolicy

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        MemberServiceImpl memberService = new MemberServiceImpl();
        memberService.init(memberRepository());
        return memberService;
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.init(memberRepository(), discountPolicy());
        return orderService;
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
