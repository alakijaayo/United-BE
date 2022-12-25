package UnitedBE.UnitedBE.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuestionSelect {

  public List<Object> convertObjectToList(Object obj) {
    List<Object> list = new ArrayList<>();
    if (obj.getClass().isArray()) {
        list = Arrays.asList((Object[])obj);
    } else if (obj instanceof Collection) {
        list = new ArrayList<>((Collection<?>)obj);
    }
    return list;
  }
}
