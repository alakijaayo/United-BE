package com.UnitedBE.Client;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class GetFileData {
  Map<?, ?> map;
  Object questions;
  JSONParser getAnswer = new JSONParser();
  Integer number;
  String userChoice;
  HashMap<String, String> response = new HashMap<>();

  @Autowired
  QuestionSelect questionSelect;

  
  public Object selectFile(String level, String environment) {
    String url;
    if(environment.equals("development")) {
      url = "src/main/resources/data/" + level + ".json";
    } else {
      url = "/home/ec2-user/server/" + level + ".json";
    }
    
    ObjectMapper mapper = new ObjectMapper();
    try {
      map = mapper.readValue(Paths.get(url).toFile(), Map.class);
    } catch (IOException e) {
      System.out.println(e);
    }

    questions = map.get(level);
    return questions;
  }

  public HashMap<String, String> checkAnswer(String level, String environment, String body) {   
    try {
      JSONObject answer = (JSONObject) getAnswer.parse(body);
      number = (int) (long) answer.get("number") - 1; 
      userChoice = (String) answer.get("userChoice");
    } catch (ParseException e) {
      System.out.println(e);
    }

    Object data = selectFile(level, environment);
    questionSelect.convertObjectToList(data);

    HashMap<String, String> question = questionSelect.checkQuestionAnswer(number);
    if (question.get("correct").equals(userChoice)) {
      response.put("url", "/correct");
    } else {
      response.put("url", "/incorrect");
    } 

   return response;
  }
}
