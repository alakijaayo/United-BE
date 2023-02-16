package com.UnitedBE.Client;

import org.springframework.stereotype.Component;

@Component
public class QuestionData {
  Integer scoreCount = 0;
  String userEnvironment;
  String userLevel;

  public void setUserLevel(String level) {
    this.userLevel = level;
  } 

  public void setUserEnvironment(String environment) {
    this.userEnvironment = environment;
  }

  public String getUserLevel() {
    return userLevel;
  }

  public String getUserEnvrironment() {
    return userEnvironment;
  }

  public void setScoreCount() {
    scoreCount += 1;
  }

  public Integer getScoreCount() {
    return scoreCount;
  }
  public void resetScoreCount() {
    scoreCount = 0;
  }
}
