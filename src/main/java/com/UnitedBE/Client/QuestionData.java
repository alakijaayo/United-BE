package com.UnitedBE.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class QuestionData {
  Integer scoreCount = 0;
  Integer questionCount = 0;
  Integer number = 99;
  Random rn = new Random();
  String userEnvironment;
  String userLevel;
  String correctAnswer;
  ArrayList<Integer> questionsSelected = new ArrayList<Integer>();
  HashMap<String, String> response = new HashMap<>();

  public void setUserLevel(String level) {
    this.userLevel = level;
  } 

  public void setUserEnvironment(String environment) {
    this.userEnvironment = environment;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public String getUserLevel() {
    return userLevel;
  }

  public String getUserEnvrironment() {
    return userEnvironment;
  }

  public void setQuestionCount() {
    questionCount += 1;
  }

  public Integer getQuestionCount() {
    return questionCount;
  }

  public void setScoreCount() {
    scoreCount += 1;
  }

  public Integer getScoreCount() {
    return scoreCount;
  }

  public Integer selectNumber() {
    Integer newNumber = rn.nextInt(number);
    if (questionCount <=1) {
      questionsSelected.clear();
    }

    if (questionsSelected.contains(newNumber)) {
      selectNumber();
    } else {
      questionsSelected.add(newNumber);
    }

    return questionsSelected.get(questionsSelected.size() -1);
  }

  public HashMap<String, String> resetScoreCount() {
    response.clear();
    questionCount = 0;
    scoreCount = 0;
    response.put("score", scoreCount.toString());
    response.put("questionCount", questionCount.toString());
    return response;
  }

  public HashMap<String, String> setScore(String userQuestion, String score, String pathname) {
    response.clear();

    if ((pathname.equals( "easy")) || (pathname.equals("medium")) || pathname.equals("hard")) {
        questionsSelected.remove(questionsSelected.size() - 1);
        questionCount -= 1;
      } else {
        if (pathname.equals("incorrect")) {
          response.put("answer", correctAnswer);
        }
        questionCount = Integer.parseInt(userQuestion);
      }
      scoreCount = Integer.parseInt(score);
      
      response.put("score", scoreCount.toString());
      response.put("link", "/" + userLevel);
      response.put("questionCount", questionCount.toString());
    return response;
  }
}

