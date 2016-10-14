package Main;

import Interface.IQuiz;
import Quiz.*;

public class Main {

	public static void main(String[] args) {
//		solve(new Quiz_1());
//		solve(new Quiz_2());
//		solve(new Quiz_3());
//		solve(new Quiz_4());
//		solve(new Quiz_5());
//		solve(new Quiz_6());
//		solve(new Quiz_7());
//		solve(new Quiz_8());	need modify
//		solve(new Quiz_9());
//		solve(new Quiz_10());
		solve(new Quiz_11());
	}
	
	public static void solve(IQuiz quiz) {
		quiz.solve();
	}
}
