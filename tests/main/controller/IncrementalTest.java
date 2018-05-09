package main.controller;

import main.exceptions.InvalidBudgetException;
import main.exceptions.InvalidNameException;
import main.model.Entry;
import main.model.Member;
import main.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;

public class IncrementalTest {
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
            assert (memberRepository.getAllEntries().size()==10);
            assert (memberRepository.getAllEntries().get(9).getIdMember()==88);
        } catch (InvalidBudgetException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        try {
            test1();
            memberRepository.addMember(member);
            assert (memberRepository.getAllEntries().size()==10);
            assert (memberRepository.getAllEntries().get(9).getIdMember()==88);
            assert (memberRepository.getAllMembers().size()==4);
            assert ("88".equals(memberRepository.getAllMembers().get(3).getId()));
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test3(){
        try{
            test1();
            test2();
            assert (memberRepository.getAllMembers().contains(member));
            assert (memberRepository.getAllEntries().contains(entry));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
