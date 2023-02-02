package com.UnitedBE.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UnitedBE.Client.Questions;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UnitedController {

  @Autowired
  Questions question;

  @GetMapping("/easy")
  public Object easyQuestion(@RequestParam String questionNumber) throws StreamReadException, DatabindException, IOException {
    return question.levelQuestion("easy", questionNumber);
  }

  @GetMapping("/medium")
  public Object mediumQuestion(@RequestParam String questionNumber) throws StreamReadException, DatabindException, IOException {
    return question.levelQuestion("medium", questionNumber);
  }

  @GetMapping("/hard")
  public Object hardQuestion(@RequestParam String questionNumber) throws StreamReadException, DatabindException, IOException {
    return question.levelQuestion("hard", questionNumber);
  }

  @GetMapping("/error")
  public String error() {
    return "Not working properly";
  }

  @GetMapping("/status")
  public String status() {
    return "Hello world! 200 ok";
  }
}