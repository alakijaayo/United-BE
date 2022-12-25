package UnitedBE.UnitedBE.Client;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Questions {
  Integer number = 99;
  ArrayList<Integer> questionNumber = new ArrayList<Integer>();
  Random rn = new Random();
  
  @Autowired
  QuestionSelect questionSelect;

  public Object levelQuestion(String level) throws StreamReadException, DatabindException, IOException {
    String url = "src/main/resources/data/" + level + ".json";
    ObjectMapper mapper = new ObjectMapper();
    Map<?, ?> map = mapper.readValue(Paths.get(url).toFile(), Map.class);

    Object questions = map.get(level);
    List<Object> option = questionSelect.convertObjectToList(questions);
    Integer number = selectNumber();
    return option.get(number);
  }

  public Integer selectNumber() {
    Integer test = rn.nextInt(number);
    if (questionNumber.contains(test)) {
      selectNumber();
    } else {
      questionNumber.add(test);
    }
    return questionNumber.get(questionNumber.size() -1);
  };
}
