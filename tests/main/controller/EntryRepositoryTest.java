package main.controller;

import main.exceptions.InvalidBudgetException;
import main.model.Entry;
import main.model.Member;
import main.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Dan on 04.04.2018.
 */
public class EntryRepositoryTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws InvalidBudgetException {
        MemberRepository memberRepository =new MemberRepository();

        Entry entry=new Entry("income",100,10);
        memberRepository.addEntry(entry);
        assert(memberRepository.getAllEntries().size()==10);
    }
    @Test
    public void test2() throws InvalidBudgetException {
        MemberRepository memberRepository =new MemberRepository();
        Entry entry=new Entry("income",100,10);
        Entry entry2=new Entry("income",100,10);
        memberRepository.addEntry(entry);
        try {
            memberRepository.addEntry(entry2);
        }catch (InvalidBudgetException e){
            e.printStackTrace();
        }
        assert (memberRepository.getAllEntries().size()==10);

        assert(memberRepository.getAllEntries().get(9).getIdMember()==10);
        assert("income".equals(memberRepository.getAllEntries().get(9).getType()));
    }
}
