package com.example.socialmediaanalytics.services;

import com.example.socialmediaanalytics.utils.AnalysisResult;
import org.springframework.stereotype.Service;

@Service
public class AnalysisService {

    public AnalysisResult analyzePost(String content) {
        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }

        int wordCount = countWords(content);
        double averageWordLength = calculateAverageWordLength(content, wordCount);

        return new AnalysisResult(wordCount, averageWordLength);
    }

    private int countWords(String content) {
        String[] words = content.split("\\s+");
        return words.length;
    }

    private double calculateAverageWordLength(String content, int wordCount) {
        if (wordCount == 0) {
            return 0;
        }

        int totalLength = content.replaceAll("\\s", "").length();
        return (double) totalLength / wordCount;
    }
}
