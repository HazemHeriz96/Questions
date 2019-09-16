package com.example.questions;

class Question {
    private String question;
    private String choiceA,choiceB,choiceC,choiceD;
    private String answer;
    private String feedback;

    public Question(String question, String choiceA, String choiceB, String choiceC, String choiceD, String answer, String feedback) {
        this.question = question;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.answer = answer;
        this.feedback = feedback;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public String getAnswer() {
        return answer;
    }

    public String getFeedback() {
        return feedback;
    }
}
