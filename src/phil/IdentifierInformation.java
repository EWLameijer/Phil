package phil;

import java.util.ArrayList;
import java.util.List;

public class IdentifierInformation {
  private final static int MAX_SIZE = 5;
  private int m_counter;
  private List<String> m_occurrences;
  
  IdentifierInformation() {
    m_counter = 0;
    m_occurrences = new ArrayList<>();
    
  }
  
  public void add(String newLine) {
    m_counter++;
    if (m_counter <= MAX_SIZE) {
      m_occurrences.add(newLine);
    }
    
  }
  
  public String toString() {
    
    StringBuilder sb = new StringBuilder();
    sb.append(m_counter);
    sb.append("\t");
    if (m_counter==1) {
      for (String line : m_occurrences) {
        sb.append(line);
        sb.append("%n");
      }
      return sb.toString();
    } else {
      return "";
    }
    
  }
}
