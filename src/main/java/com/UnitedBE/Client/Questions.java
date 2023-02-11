package com.UnitedBE.Client;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Questions {
  Integer number = 99;
  ArrayList<Integer> questionsSelected = new ArrayList<Integer>();
  Random rn = new Random();
  Integer getNumber;
  
  @Autowired
  QuestionSelect questionSelect;

  public HashMap<String, String> levelQuestion(String level, String questionNumber, String environment) {
    String url;
    if(environment.equals("development")) {
      url = "src/main/resources/data/" + level + ".json";
    } else {
      url = "/home/ec2-user/server/" + level + ".json";
    }
    ObjectMapper mapper = new ObjectMapper();
    
    try {
      Map<?, ?> map = mapper.readValue(Paths.get(url).toFile(), Map.class);
      Object questions = map.get(level);
      questionSelect.convertObjectToList(questions);
      getNumber = selectNumber(questionNumber);
    } catch (IOException e) {
      System.out.println(e);
    }

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
}
