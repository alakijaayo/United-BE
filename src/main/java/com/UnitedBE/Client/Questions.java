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
  
  @Autowired
  QuestionData questionData;
  
  @Autowired
  QuestionSelect questionSelect;

  @Autowired
  GetFileData getFileData;

  public HashMap<String, String> levelQuestion(String level, String environment) {
    questionData.setUserEnvironment(environment);
    questionData.setUserLevel(level);;

    Object getData = getFileData.selectFile(level, environment);
    questionSelect.convertObjectToList(getData);
    HashMap<String, String> question = questionSelect.getQuestion(selectNumber());
    return question;
  }

  public Integer selectNumber() {
    Integer newNumber = rn.nextInt(number);
    if (questionsSelected.contains(newNumber)) {
      selectNumber();
    } else {
      questionsSelected.add(newNumber);
    }
    return questionsSelected.get(questionsSelected.size() -1);
  };

  public HashMap<String, String> checkAnswer(String body) {
    return getFileData.checkAnswer(questionData, body);
  }
}
