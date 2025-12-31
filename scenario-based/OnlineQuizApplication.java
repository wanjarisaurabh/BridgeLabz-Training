
import java.util.Scanner;

/*
 * Program: OnlineQuizApplication
 * Description:
 * Asks 5 MCQ questions.
 * Uses arrays, for-loop, and switch-case.
 * Calculates and displays final score.
 */
public class OnlineQuizApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] questions = {
            "1. Java is a?\nA) OS\nB) Programming Language\nC) Browser\nD) Device",
            "2. Size of int?\nA) 2 bytes\nB) 4 bytes\nC) 8 bytes\nD) Depends",
            "3. Which keyword creates object?\nA) new\nB) class\nC) static\nD) void",
            "4. JVM stands for?\nA) Java Virtual Machine\nB) Java Variable Method\nC) Joint Virtual Mode\nD) None",
            "5. Entry point of Java program?\nA) start()\nB) run()\nC) main()\nD) init()"
        };

        char[] correctAnswers = {'B', 'B', 'A', 'A', 'C'};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Enter your answer: ");
            char userAnswer = sc.next().toUpperCase().charAt(0);

            switch (userAnswer) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                    if (userAnswer == correctAnswers[i]) {
                        score++;
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
            }
            System.out.println();
        }

        System.out.println("Quiz Completed!");
        System.out.println("Your Score: " + score + "/5");
    }
}
