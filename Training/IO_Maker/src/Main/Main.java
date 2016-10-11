package Main;

import Interface.IQuiz;
import Quiz.*;

public class Main {

	public static void main(String[] args) {
		solve(new Quiz_2());
	}
	
	public static void solve(IQuiz quiz) {
		quiz.solve();
	}
}
