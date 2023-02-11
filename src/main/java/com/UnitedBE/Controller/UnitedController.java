package com.UnitedBE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.UnitedBE.Client.Questions;


@CrossOrigin(origins = {"http://localhost:3000", "http://unitedfebucket.s3-website.eu-west-2.amazonaws.com"})
@RestController
public class UnitedController {

  @Autowired
  Questions question;

  @GetMapping("/easy/{questionNumber}/{environment}")
  public ResponseEntity<Object>easyQuestion(@PathVariable String questionNumber, @PathVariable String environment) {
    return ResponseEntity.ok(question.levelQuestion("easy", questionNumber, environment));
  }

  @GetMapping("/medium/{questionNumber}/{environment}")
  public ResponseEntity<Object>mediumQuestion(@PathVariable String questionNumber, @PathVariable String environment) {
    return ResponseEntity.ok(question.levelQuestion("medium", questionNumber, environment));
  }

  @GetMapping("/hard/{questionNumber}/{environment}")
  public ResponseEntity<Object>hardQuestion(@PathVariable String questionNumber, @PathVariable String environment) {
    return ResponseEntity.ok(question.levelQuestion("hard", questionNumber, environment));
  }
}