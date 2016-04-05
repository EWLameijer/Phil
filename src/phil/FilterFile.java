package phil;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilterFile {
  
  public static void main (String[] args) {
    try(BufferedReader br = new BufferedReader(
        new FileReader("C:\\Projects\\DiskMagic\\crmdm\\applic\\current\\current_for_phil.txt"))) {
      String line = br.readLine();
      while (line!=null) {
        //System.out.println(line);
        IdentifierRepository.add(line);
        line = br.readLine();
      }
      IdentifierRepository.show();

    } catch ( Exception e){
      System.out.println("ERROR");
    }
  }
  
  public static void oldmain (String[] args) {
    int argtypecounter = 0;
    int scopecounter =0;
    int neverusedcounter = 0;
    int calculationPrecedence = 0;
    int possiblenullpointerreference = 0;
    int conversionOfStringToBool = 0;
    int ineffectiveFunctionParamAssignment = 0;
    int fieldnotinitializedinconstructor = 0;
    int overridenfield = 0;
    int obsoleteasctimecalled = 0;
    int structmemberneverused = 0;
    int assigningtoitself = 0;
    int cstylepointercasting = 0;
    int scanfwithoutfieldlimits = 0;
    int unreachablecode = 0;
    try(BufferedReader br = new BufferedReader(new FileReader("P:\\CPPCHECKRESULTS.txt"))) {
      //StringBuilder sb = new StringBuilder();
      String line = br.readLine();

      
      while (line != null) {
        if (line.contains("but the argument type is")) {
           ++argtypecounter;
        }
        else if (line.contains("The scope of the variable ")) {
          ++scopecounter;
        }
        else if (line.contains("is assigned a value that is never used.")) {
          ++neverusedcounter;
        }
        else if (line.contains("Clarify calculation precedence for ")) {
          ++calculationPrecedence;
        }
        else if (line.contains("is redundant or there is possible null pointer dereference:")) {
          ++possiblenullpointerreference;
        }
        else if (line.contains("to bool always evaluates to true")) {
          ++conversionOfStringToBool;
        }
        else if (line.contains("Assignment of function parameter has no effect outside the function.")) {
          ++ineffectiveFunctionParamAssignment;
        }
        else if (line.contains("is not initialized in the constructor.")) {
          ++fieldnotinitializedinconstructor;
        }
        else if (line.contains("also defined in its parent class")) {
          ++overridenfield;
        }
        else if (line.contains("Obsolete function 'asctime' called. It is recommended to use 'strftime' instead.")) {
          ++obsoleteasctimecalled;
        }
        else if (line.contains("is never used.")) {
          ++structmemberneverused;
        }
        else if (line.contains("Redundant assignment of")) {
          ++assigningtoitself;
        }
        else if (line.contains("(style) C-style pointer casting")) {
          ++cstylepointercasting;
        }
        else if (line.contains("scanf without field width limits can crash with huge input data.")) {
          ++scanfwithoutfieldlimits;
        }
        else if (line.contains("Statements following return, break, continue, goto or throw will never be executed.")) {
          ++unreachablecode;
        }
        
        
        
         
        
/*          sb.append(line);
          sb.append(System.lineSeparator());*/
        else {
        System.out.println(line);
        }
          line = br.readLine();
      }
      //String everything = sb.toString();
  } catch ( IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
    System.out.printf("but the argument type is %d%n", argtypecounter);
    System.out.printf("scope can be reduced %d%n", scopecounter);
    System.out.printf("variable is never used %d%n", neverusedcounter);
    System.out.printf("clarify calculation precendence %d%n", calculationPrecedence);
    System.out.printf("possible null pointer dereference %d%n", possiblenullpointerreference);
    System.out.printf("conversion of string to bool evaluates to true %d%n", conversionOfStringToBool);
    System.out.printf("assignment of value to fn param has no effect outside the function %d%n", ineffectiveFunctionParamAssignment);
    System.out.printf("field not initialized in constructor %d%n", fieldnotinitializedinconstructor);
    System.out.printf("overridden field %d%n", overridenfield);
    System.out.printf("obsolete asctime called %d%n", obsoleteasctimecalled);
    System.out.printf("struct member never used %d%n", structmemberneverused);
    System.out.printf("assigns to itself %d%n", assigningtoitself);
    System.out.printf("C-style pointer casting %d%n", cstylepointercasting);
    System.out.printf("Scanf without field limits %d%n", scanfwithoutfieldlimits);
    System.out.printf("Unreachable code %d%n", unreachablecode);
  }

}
