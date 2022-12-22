package UnitedBE.UnitedBE.Client;

import java.io.IOException;
import java.nio.file.Paths;
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
  Random rn = new Random();
  
  @Autowired
  QuestionSelect questionSelect;

  public Object levelQuestion(String level) throws StreamReadException, DatabindException, IOException {
    String url = "src/main/resources/data/" + level + ".json";
    ObjectMapper mapper = new ObjectMapper();
    Map<?, ?> map = mapper.readValue(Paths.get(url).toFile(), Map.class);

    Object easyQuestions = map.get(level);
    List<Object> option = questionSelect.convertObjectToList(easyQuestions);
    Integer number = option.size();

    return option.get(rn.nextInt(number));
  }
}
