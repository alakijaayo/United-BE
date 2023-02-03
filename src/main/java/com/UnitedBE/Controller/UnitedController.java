package com.UnitedBE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    return ResponseEntity.ok(question.levelQuestion("easy", questionNumber));
  }

  @GetMapping("/medium")
  public ResponseEntity<Object>mediumQuestion(@RequestParam String questionNumber) {
    return ResponseEntity.ok(question.levelQuestion("medium", questionNumber));
  }

  @GetMapping("/hard")
  public ResponseEntity<Object>hardQuestion(@RequestParam String questionNumber) {
    return ResponseEntity.ok(question.levelQuestion("hard", questionNumber));
  }

  @GetMapping("/status")
  public String status() {
    return "Hello world! 200 ok";
  }
  
  @GetMapping("/random")
  public String random() {
    return "Why does this one work and others fail?";
  }
}