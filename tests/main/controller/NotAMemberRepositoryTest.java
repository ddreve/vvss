package main.controller;

import main.model.Member;
import main.repository.MemberRepository;
import org.junit.Test;

/**
 * Created by Dan on 25.03.2018.
 */
public class NotAMemberRepositoryTest {
    @Test
    public void test3(){
        MemberRepository memberRepository =new MemberRepository();
        Member member=new Member("name1","1");
        memberRepository.addMember(member);
        assert(memberRepository.getAllMembers().size()==3);
    }
    @Test
    public void test4(){
        MemberRepository memberRepository =new MemberRepository();
        Member member=new Member("Dan","8");
        memberRepository.addMember(member);
        assert(memberRepository.getAllMembers().size()==3);
    }
}
