package UnitedBE.UnitedBE.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UnitedController {

  @GetMapping("/easy")
  public String test() {
    return "Hello World";
  }

  @GetMapping("/medium")
  public String testing() {
    return "Hello World";
  }

  @GetMapping("/hard")
  public String tester() {
    return "Hello World";
  }
}