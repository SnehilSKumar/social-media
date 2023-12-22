package com.example.socialmediaanalytics.services;

import com.example.socialmediaanalytics.utils.AnalysisResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisServiceTest {

    @Test
    void analyzePost() {
        String content = "This is a sample post for analysis.";

        AnalysisService analysisService = new AnalysisService();
        AnalysisResult result = analysisService.analyzePost(content);

        assertNotNull(result);
        assertEquals(7, result.getWordCount());
        assertEquals(4.142857142857143, result.getAverageWordLength(), 0.0001);
    }

    @Test
    void analyzePostWithNullContent() {
        String content = null;

        AnalysisService analysisService = new AnalysisService();

        assertThrows(IllegalArgumentException.class, () -> analysisService.analyzePost(content));
    }

    @Test
    void analyzePostWithEmptyContent() {
        String content = "";

        AnalysisService analysisService = new AnalysisService();

        assertThrows(IllegalArgumentException.class, () -> analysisService.analyzePost(content));
    }
}
