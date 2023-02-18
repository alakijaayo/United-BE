package com.UnitedBE.Client;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Questions {
  Random rn = new Random();
  
  @Autowired
  QuestionData questionData;
  
  @Autowired
  QuestionSelect questionSelect;

  @Autowired
  GetFileData getFileData;

  public HashMap<String, String> levelQuestion(String level, String environment) {
    questionData.setUserEnvironment(environment);
    questionData.setUserLevel(level);;
    questionData.setQuestionCount();

    Object getData = getFileData.selectFile(level, environment);
    questionSelect.convertObjectToList(getData);
    HashMap<String, String> question = questionSelect.getQuestion(questionData.selectNumber());
    question.put("questionCount", questionData.getQuestionCount().toString());
    return question;
  }

  public HashMap<String, String> checkAnswer(String body) {
    return getFileData.checkAnswer(questionData, body);
  }

  public HashMap<String, String> resetNumbers() {
    return questionData.resetScoreCount();
  }

  public HashMap<String, String> setScore(String questionCount, String score, String pathname) {
    return questionData.setScore(questionCount, score, pathname);
  }
}
