package hellp.core;

import hellp.core.Member.Grade;
import hellp.core.Member.Member;
import hellp.core.Member.MemberService;
import hellp.core.Member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("find Member = " + findMember.getName());
        System.out.println("new member = " + member.getName());
    }
}
