package hellp.core.order;

import hellp.core.Member.Member;
import hellp.core.Member.MemberRepository;
import hellp.core.Member.MemoryMemberRepository;
import hellp.core.discount.DiscountPolicy;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 단일 책임의 원칙 . SRP 잘지킨 예제


        return new Order(memberId, itemName , itemPrice, discountPrice);
    }
}
