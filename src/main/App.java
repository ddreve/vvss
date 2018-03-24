package main;

import main.repository.MemberRepository;
import main.controller.MemberController;
import main.ui.MemberUI;;

public class App {
	public static void main(String[] args) {
		
			MemberRepository repo = new MemberRepository();
		
			MemberController ctrl = new MemberController(repo);
		
			MemberUI console = new MemberUI(ctrl);
			console.Run();
		
	}
}
