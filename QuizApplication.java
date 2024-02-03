import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication
  {
    private static final int timeLimit = 60;
    private static final String[] newQuestions = 
    {
            "In which year was the Declaration of Independence signed?",
            "What is the capital of Australia?",
            "Which is the smallest continent on Earth?",
            "What is the fastest land animal?",
            "NASA abbreviation",
            "How many continents are there in the world?"
    };

    private static final String[] correctAnswers =
    {
            "1776",
            "Canberra",
            "Australia",
            "Cheetah",
            "National Aeronautics and Space Administration",
            "7"
            
    };

    private static int userScore = 0;

    public static void main(String[] args)
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask()
          {
            int seconds = timeLimit;

            @Override
            public void run()
            {
                if (seconds > 0)
                {
                    if (seconds % 10 == 0) 
                    {
                        System.out.println("Time left: " + seconds + " seconds");
                    }
                    seconds--;
                } else
                {
                    System.out.println("Time's up!");
                    timer.cancel();
                    showResult();
                    System.exit(0);
                }
            }
        }, 0, 1000); 
        startQuiz();
        showResult();
    }

    private static void startQuiz() 
    {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < newQuestions.length; i++) 
        {
            System.out.println("Question " + (i + 1) + ": " + newQuestions[i]);
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(correctAnswers[i]))
            {
                System.out.println("Correct!\n");
                userScore++;
            } else
            {
                System.out.println("Incorrect. The correct answer is: " + correctAnswers[i] + "\n");
            }
        }
    }

    private static void showResult()
    {
        System.out.println("Quiz ended. Your score: " + userScore + " out of " + newQuestions.length);
        System.exit(0);
    }
}
