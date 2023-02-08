package com.UnitedBE.Client;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Questions {
  Integer number = 99;
  ArrayList<Integer> questionNumber = new ArrayList<Integer>();
  Random rn = new Random();
  List<Object> option;
  Integer getNumber;
  
  @Autowired
  QuestionSelect questionSelect;

  public Object levelQuestion(String level, String question, String environment) {
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
      option = questionSelect.convertObjectToList(questions);
      getNumber = selectNumber(question);
    } catch (IOException e) {
      System.out.println(e);
    }

    return option.get(getNumber);
  }

  public Integer selectNumber(String question) {
    if (question.equals("1")) {
      questionNumber.clear();
    }
    Integer newNumber = rn.nextInt(number);
    if (questionNumber.contains(newNumber)) {
      selectNumber(question);
    } else {
      questionNumber.add(newNumber);
    }
    return questionNumber.get(questionNumber.size() -1);
  };
}
