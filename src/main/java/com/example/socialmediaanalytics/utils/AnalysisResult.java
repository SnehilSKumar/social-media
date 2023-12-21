package com.example.socialmediaanalytics.utils;

public class AnalysisResult {
    private int wordCount;
    private double averageWordLength;

    public AnalysisResult(int wordCount, double averageWordLength) {
        this.wordCount = wordCount;
        this.averageWordLength = averageWordLength;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public void setAverageWordLength(double averageWordLength) {
        this.averageWordLength = averageWordLength;
    }
}