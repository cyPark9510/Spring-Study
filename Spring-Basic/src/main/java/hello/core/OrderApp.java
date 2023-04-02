package hello.core;

import hello.core.order.entity.Order;
import hello.core.order.service.OrderService;
import hello.core.member.entity.Member;
import hello.core.member.repository.Grade;
import hello.core.member.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        long memberId = 1L;

        Member member = new Member(memberId, "member", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item", 10000);

        System.out.println("order = " + order);
    }
}
