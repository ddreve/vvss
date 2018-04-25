package main.controller;

import main.exceptions.InvalidBudgetException;
import main.exceptions.InvalidNameException;
import main.model.Member;
import main.repository.MemberRepository;
import org.junit.Test;

/**
 * Created by Dan on 25.03.2018.
 */
public class NotAMemberRepositoryTest {
    @Test(expected = InvalidNameException.class)
    public void test3() throws InvalidNameException {
        MemberRepository memberRepository =new MemberRepository();
        Member member=new Member("name1","1");
        memberRepository.addMember(member);
        assert(memberRepository.getAllMembers().size()==3);
    }
    @Test(expected = InvalidNameException.class)
    public void test4() throws InvalidNameException {
        MemberRepository memberRepository =new MemberRepository();
        Member member=new Member("Dan","8");
        memberRepository.addMember(member);
        assert(memberRepository.getAllMembers().size()==3);
    }
}
