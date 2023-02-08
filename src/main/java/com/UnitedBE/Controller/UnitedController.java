package com.UnitedBE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UnitedBE.Client.Questions;


@CrossOrigin(origins = {"http://localhost:3000", "http://unitedfebucket.s3-website.eu-west-2.amazonaws.com"})
@RestController
public class UnitedController {

  @Autowired
  Questions question;

  @GetMapping("/easy")
  public ResponseEntity<Object>easyQuestion(@RequestParam String questionNumber, @RequestParam String environment) {
    return ResponseEntity.ok(question.levelQuestion("easy", questionNumber, environment));
  }

  @GetMapping("/medium")
  public ResponseEntity<Object>mediumQuestion(@RequestParam String questionNumber, @RequestParam String environment) {
    return ResponseEntity.ok(question.levelQuestion("medium", questionNumber, environment));
  }

  @GetMapping("/hard")
  public ResponseEntity<Object>hardQuestion(@RequestParam String questionNumber, @RequestParam String environment) {
    return ResponseEntity.ok(question.levelQuestion("hard", questionNumber, environment));
  }
}