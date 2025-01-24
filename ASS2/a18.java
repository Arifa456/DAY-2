package com.ASS2;

import java.util.*;

class Question {
    private String questionText;
    private List<String> options;
    private int correctOption; // Index of the correct option

    public Question(String questionText, List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctOption;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(questionText).append("\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append((i + 1) + ". " + options.get(i)).append("\n");
        }
        return sb.toString();
    }
}

class Quiz {
    private List<Question> questions = new ArrayList<>();
    private Map<String, Integer> results = new HashMap<>();

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void conductQuiz(String userName) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Quiz, " + userName + "!");
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ":");
            System.out.println(question);

            System.out.print("Your answer (1-" + question.getOptions().size() + "): ");
            int userAnswer = scanner.nextInt();

            if (question.isCorrect(userAnswer - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + (question.getCorrectOption() + 1));
            }
        }

        System.out.println("Quiz Completed! Your score: " + score + "/" + questions.size());
        results.put(userName, score);
    }

    public void displayResults() {
        System.out.println("Quiz Results:");
        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

public class a18 {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Adding sample questions
        quiz.addQuestion(new Question("What is the capital of France?", Arrays.asList("Paris", "Berlin", "Rome", "Madrid"), 0));
        quiz.addQuestion(new Question("What is 5 + 3?", Arrays.asList("5", "8", "10", "7"), 1));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?", Arrays.asList("Earth", "Mars", "Jupiter", "Venus"), 1));

        // Taking the quiz
        quiz.conductQuiz("John");

        // Display results
        quiz.displayResults();
    }
}
