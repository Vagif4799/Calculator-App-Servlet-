package calculatorApp;

import java.util.HashMap;
import java.util.Map;

public class AuthHashMap implements Autheritation {

  public Map<String, String> db = new HashMap<String, String>();

  @Override
  public boolean check(String name, String passwd) {
    return db.containsKey(name) && db.get(name).equals(passwd);
  }
}
