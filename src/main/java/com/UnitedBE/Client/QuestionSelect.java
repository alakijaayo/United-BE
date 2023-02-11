package com.UnitedBE.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuestionSelect {
  List<Object> list = new ArrayList<>();

  public void convertObjectToList(Object obj) {
    if (obj.getClass().isArray()) {
        list = Arrays.asList((Object[])obj);
    } else if (obj instanceof Collection) {
        list = new ArrayList<>((Collection<?>)obj);
    }
  }

  public HashMap<String, String> getQuestion(Integer number) {
    @SuppressWarnings("unchecked")
    HashMap<String, String> question = (HashMap<String, String>) list.get(number);

    question.remove("correct");
    return question;
  }
}
