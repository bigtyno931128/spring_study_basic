package hellp.core;

import hellp.core.Member.Grade;
import hellp.core.Member.Member;
import hellp.core.Member.MemberService;
import hellp.core.Member.MemberServiceImpl;
import hellp.core.order.Order;
import hellp.core.order.OrderService;
import hellp.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(1L , "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
        
    }
}
