package com.UnitedBE.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Questions {
  Integer number = 99;
  ArrayList<Integer> questionsSelected = new ArrayList<Integer>();
  Random rn = new Random();
  Integer getNumber;
  String userEnvironment;
  String userLevel;
  
  @Autowired
  QuestionSelect questionSelect;

  @Autowired
  GetFileData getFileData;

  public HashMap<String, String> levelQuestion(String level, String questionNumber, String environment) {
    userEnvironment = environment;
    userLevel = level;

    Object getData = getFileData.selectFile(level, environment);
    getNumber = selectNumber(questionNumber);
    questionSelect.convertObjectToList(getData);
    HashMap<String, String> question = questionSelect.getQuestion(getNumber);
    return question;
  }

  public Integer selectNumber(String question) {
    if (question.equals("1")) {
      questionsSelected.clear();
    }
    Integer newNumber = rn.nextInt(number);
    if (questionsSelected.contains(newNumber)) {
      selectNumber(question);
    } else {
      questionsSelected.add(newNumber);
    }
    return questionsSelected.get(questionsSelected.size() -1);
  };

  public HashMap<String, String> checkAnswer(String body) {
    return getFileData.checkAnswer(userLevel, userEnvironment, body);
  }
}
