package hellp.core;

import hellp.core.Member.MemberService;
import hellp.core.Member.MemberServiceImpl;
import hellp.core.Member.MemoryMemberRepository;
import hellp.core.discount.DiscountPolicy;
import hellp.core.discount.FixDiscountPolicy;
import hellp.core.discount.RateDiscountPolicy;
import hellp.core.order.OrderService;
import hellp.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    // 생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public   MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
