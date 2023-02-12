package com.UnitedBE.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.UnitedBE.Client.Questions;


@CrossOrigin(origins = {"http://localhost:3000", "http://unitedfebucket.s3-website.eu-west-2.amazonaws.com"})
@RestController
public class UnitedController {

  @Autowired
  Questions question;

  @GetMapping("/easy/{environment}")
  public ResponseEntity<Object> easyQuestion(@PathVariable String environment) {
    return ResponseEntity.ok(question.levelQuestion("easy", environment));
  }

  @GetMapping("/medium/{environment}")
  public ResponseEntity<Object> mediumQuestion( @PathVariable String environment) {
    return ResponseEntity.ok(question.levelQuestion("medium", environment));
  }

  @GetMapping("/hard/{environment}")
  public ResponseEntity<Object> hardQuestion( @PathVariable String environment) {
    return ResponseEntity.ok(question.levelQuestion("hard", environment));
  }

  @PostMapping("/checkAnswer")
  public ResponseEntity<Object> checkAnswer(@RequestBody String answer) {
    return ResponseEntity.ok(question.checkAnswer(answer));
  }
}