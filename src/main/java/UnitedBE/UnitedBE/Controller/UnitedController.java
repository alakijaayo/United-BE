package UnitedBE.UnitedBE.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import UnitedBE.UnitedBE.Client.Questions;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UnitedController {

  @Autowired
  Questions question;

  @GetMapping("/easy")
  public Object easyQuestion() throws StreamReadException, DatabindException, IOException {
    return question.levelQuestion("easy");
  }

  @GetMapping("/medium")
  public Object mediumQuestion() throws StreamReadException, DatabindException, IOException {
    return question.levelQuestion("medium");
  }

  @GetMapping("/hard")
  public Object hardQuestion() throws StreamReadException, DatabindException, IOException {
    return question.levelQuestion("hard");
  }
}