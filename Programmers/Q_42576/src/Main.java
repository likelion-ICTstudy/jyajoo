import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public String solution(String[] participant, String[] completion) {
    Map<String, Integer> data = new HashMap<>();

    for (String s : participant) {
      if (!data.containsKey(s)) {
        data.put(s, 1);
      } else {
        data.replace(s, data.get(s) + 1);
      }
    }

    for (String s : completion) {
      if (!data.containsKey(s)) {
        return s;
      } else {
        data.replace(s, data.get(s) - 1);
        if (data.get(s) == 0) {
          data.remove(s);
        }
      }
    }

    return new ArrayList<String>(data.keySet()).get(0);
  }
}

public class Main {

  public static void main(String[] args) {

  }
}
