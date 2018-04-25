package main.repository;

import java.io.BufferedReader;

import main.exceptions.InvalidBudgetException;
import main.exceptions.InvalidNameException;
import main.model.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
	private List<Member> members = new ArrayList<Member>();
	private List<Entry> entries = new ArrayList<Entry>();

	private final static String filenameMember = "membersF.txt";
	private final static String filenameBudget = "budgetF.txt";

	private int maxMembers=0;
	private int maxBudgets=0;

	public List<Member> getAllMembers(){
		return members;
	}
	@SuppressWarnings("resource")
	public MemberRepository() {
		
	try{
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String currentLine = null;

		fileReader = new FileReader(filenameMember);
		bufferedReader = new BufferedReader(fileReader);
		
		while ((currentLine = bufferedReader.readLine()) != null) {
			String line[] = currentLine.split(";");
			Member m = new Member(line[0], line[1]);
			this.addMember(m);
			maxMembers++;
		}
	 }catch(Exception ex){
         System.err.println(ex.getMessage());
     }
	try{
		FileReader fileReaderEntry = null;
		BufferedReader bufferedReaderEntry = null;
		String currentLineEntry = null;

		fileReaderEntry = new FileReader(filenameBudget);
		bufferedReaderEntry = new BufferedReader(fileReaderEntry);
		
		while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
			String line[] = currentLineEntry.split(";");
			int valueEntry = Integer.parseInt(line[1]);
			int idEntryMember = Integer.parseInt(line[2]);
			Entry e = new Entry(line[0],valueEntry,idEntryMember);
			this.addEntry(e);
			maxBudgets++;
		}
	 }catch(Exception ex){
         System.err.println(ex.getMessage());
     }
	}

	 public void addMember(Member m) throws InvalidNameException {
		for(Member me:members)
		{
			if(me.getId().equals(m.getId())||me.getName().equals(m.getName()))
				throw new InvalidNameException("Member already exists!");
		}
		members.add(m);
	 }
	 public void addEntry(Entry e)throws InvalidBudgetException{
		for(Entry en:entries) {
			if (en.getIdMember()==e.getIdMember()){
				throw new InvalidBudgetException("Entry already exists!");
			}
		}
		entries.add(e);
	 }
	 public List<Entry> getAllEntries(){
		 
		 return entries;
	 }
}
