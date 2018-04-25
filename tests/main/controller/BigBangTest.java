package main.controller;

import main.exceptions.InvalidBudgetException;
import main.exceptions.InvalidNameException;
import main.model.Entry;
import main.model.Member;
import main.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Dan on 25.04.2018.
 */
public class BigBangTest {
    private MemberRepository memberRepository;
    private Entry entry;
    private Member member;
    @Before
    public void setup(){
        memberRepository=new MemberRepository();
        entry=new Entry("income",50,88);
        member=new Member("test","88");
    }
    @Test
    public void test1(){
        try {
            memberRepository.addEntry(entry);
        } catch (InvalidBudgetException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        try {
            memberRepository.addMember(member);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3(){
        test1();
        test2();
        assert (memberRepository.getAllMembers().contains(member));
        assert (memberRepository.getAllEntries().contains(entry));
    }
}
