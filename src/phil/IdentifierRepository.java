package phil;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentifierRepository {
  private static Map<String,IdentifierInformation> m_map = null;
  
  static void add(String newLine) {
    if (m_map == null) {
      m_map = new HashMap<>();
    }
    newLine = newLine.trim();
    if (newLine.contains("STDMETHODIMP")) return;
    String callerPattern = "\\w+\\s*\\(";
    Matcher matcher = Pattern.compile(callerPattern).matcher(newLine);
    while (matcher.find()) {
      String identifier = matcher.group();
      int posOfIdentifier = newLine.indexOf(identifier);
      String lineBeforeIdentifier = newLine.substring(0, posOfIdentifier);
      int quotationDepth = 0;
      for (char c : lineBeforeIdentifier.toCharArray()) {
        if (c=='\"') {
          quotationDepth++;
        }
      }
      if ( quotationDepth%2 == 1) {
        continue;
      }
      boolean lineHasComment = (newLine.contains("//") || newLine.startsWith("* ")); 
      if (lineHasComment) {
        if (newLine.startsWith("* ")) {
          continue;
        } else {
          int posOfComment = newLine.indexOf("//");
          if (posOfComment < posOfIdentifier && identifier.endsWith(" (")) {
            continue;
          }
        }
      }
      /*if (posOfIdentifier>0 && (newLine.charAt(posOfIdentifier-1) == '.' ||
          newLine.charAt(posOfIdentifier-1) == ':' )) {
        continue;
      }*/
      identifier = identifier.replace("(","");
      identifier = identifier.replace(" ","");
      //System.out.println("Matched " + identifier + " in " + line);
      if (!m_map.containsKey(identifier)) {
        m_map.put(identifier, new IdentifierInformation());
      }
      m_map.get(identifier).add(newLine);
    } 
  }
  
  static void show() {
    if (m_map!= null) {
       m_map.forEach((k,v) -> {
         if (!v.toString().equals("") && !k.toString().startsWith("put_")
             && !k.toString().startsWith("get_")) {
           System.out.println(k+"\t"+v);
         }
       }
    );
  }
  }

}
