package main.controller;

import main.exceptions.InvalidBudgetException;
import main.model.Entry;
import main.model.Member;
import main.repository.MemberRepository;
import org.junit.Test;

/**
 * Created by Dan on 04.04.2018.
 */
public class NotAEntryRepositoryTest {
    @Test
    public void test4(){

    }
    @Test(expected = InvalidBudgetException.class)
    public void test3() throws InvalidBudgetException {
        MemberRepository memberRepository =new MemberRepository();
        Entry entry=new Entry("income",100,5);
        memberRepository.addEntry(entry);
        assert(memberRepository.getAllEntries().size()==9);
    }
}
