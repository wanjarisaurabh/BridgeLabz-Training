package com.examscanner;

// base for different subjects
public interface AnswerSheet {
    String getSubjectName();
    String[] getCorrectAnswers();
}