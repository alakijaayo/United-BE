package com.UnitedBE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UnitedBE.Client.Questions;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UnitedController {

  @Autowired
  Questions question;

  @GetMapping("/easy")
  public ResponseEntity<Object>easyQuestion(@RequestParam String questionNumber) {
    return new ResponseEntity<>(question.levelQuestion("easy", questionNumber), HttpStatus.OK);
  }

  @GetMapping("/medium")
  public ResponseEntity<Object>mediumQuestion(@RequestParam String questionNumber) {
    return new ResponseEntity<>(question.levelQuestion("medium", questionNumber), HttpStatus.OK);
  }

  @GetMapping("/hard")
  public ResponseEntity<Object>hardQuestion(@RequestParam String questionNumber) {
    return new ResponseEntity<>(question.levelQuestion("hard", questionNumber), HttpStatus.OK);
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