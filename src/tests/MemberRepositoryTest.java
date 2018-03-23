package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Member;
import repository.MemberRepository;

public class MemberRepositoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		MemberRepository memberRepository =new MemberRepository();
		
		Member member=new Member("name1","id1");
		memberRepository.addMember(member);
		assert(memberRepository.getAllMembers().size()<2&&memberRepository.getAllMembers().size()>0);
		
	}
	@Test
	public void test2(){
		MemberRepository memberRepository =new MemberRepository();
		Member member=new Member("name1","id1");
		memberRepository.addMember(member);
		assert(memberRepository.getAllMembers().get(0).getName().equals(member.getName()));
	}

}
