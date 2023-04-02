package hello.core.unit.order;

import hello.core.AppConfig;
import hello.core.order.entity.Order;
import hello.core.order.service.OrderService;
import hello.core.member.entity.Member;
import hello.core.member.repository.Grade;
import hello.core.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        // given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        // when
        Order order = orderService.createOrder(memberId, "itemA", 20000);

        // then
        assertThat(order.getDiscountPrice()).isEqualTo(2000);
        assertThat(order.calculatePrice()).isEqualTo(18000);
    }
}
