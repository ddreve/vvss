package main.controller;

import main.exceptions.InvalidBudgetException;
import main.exceptions.InvalidNameException;
import main.repository.MemberRepository;

import main.model.Member;
import main.model.Entry;


import java.util.ArrayList;
import java.util.List;

public class MemberController {
	
    private MemberRepository mr;
    
    public MemberController(MemberRepository newMr){    	
    	this.mr =newMr;    	
    }
    
    public void addMember(Member aMemebr){
        try {
            mr.addMember(aMemebr);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }

    public void addEntry(Entry oneEntry){
        try {
            mr.addEntry(oneEntry);
        } catch (InvalidBudgetException e) {
            e.printStackTrace();
        }
    }

     public List<Entry> allEntries() {
        
    	
        List<Entry> allE= new ArrayList<>();
        allE = this.mr.getAllEntries();
        return allE;
    }
} 