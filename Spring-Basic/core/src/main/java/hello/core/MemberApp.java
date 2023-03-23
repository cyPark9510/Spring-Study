package hello.core;

import hello.core.member.entity.Member;
import hello.core.member.repository.Grade;
import hello.core.member.service.MemberService;
import hello.core.member.service.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
        System.out.println("new Member Equals find Member = " + member.equals(findMember));
    }
}
