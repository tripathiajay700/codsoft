import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Task4_Quiz {
    private static final int QUESTION_DURATION = 15; // Duration for each question in seconds
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static Question[] quizData = {
        new Question("What is the capital of India ?", new String[]{"A. Delhi", "B. Rajasthan", "C. Mumbai", "D. Andaman"}, "A"),
        new Question("How many States Are in India ?", new String[]{"A. 25", "B. 28", "C. 29", "D. 21"}, "B"),
        new Question("Which City is the IT Hub of India ?", new String[]{"A. Noida", "B. Hyderabad", "C. Bengaluru", "D. Chennai"}, "C"),
        new Question("Who is Current Prime Minister of India ?", new String[]{"A. Narendra Modi", "B. Mamata Banerjee", "C. Arvind Kejriwal", "D. Rahul Gandhi"}, "A")

        // Add more questions 
    };
    private static Timer timer;

    public static void main(String[] args) {
        startQuiz();
    }

    private static void startQuiz() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                showResult();
            }
        }, QUESTION_DURATION * 1000);

        askQuestion();
    }

    private static void askQuestion() {
        Question currentQuestion = quizData[currentQuestionIndex];
        System.out.println(currentQuestion.getQuestion());
        for (String option : currentQuestion.getOptions()) {
            System.out.println(option);
        }

        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine().toUpperCase();

        if (userAnswer.equals(currentQuestion.getCorrectAnswer())) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }

        currentQuestionIndex++;
        if (currentQuestionIndex < quizData.length) {
            startQuiz();
        } else {
            showResult();
        }
    }

    private static void showResult() {
        timer.cancel();
        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + quizData.length);
    }
}

class Question {
    private String question;
    private String[] options;
    private String correctAnswer;

    public Question(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
