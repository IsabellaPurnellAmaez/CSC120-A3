import java.util.Scanner;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

class Conversation implements Chatbot {

  // Attributes 

  /**
   * Constructor 
   */
  Conversation() {
    

  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {

    //first get the number of rounds
    
    System.out.println("How many rounds do you want to play?");
    
    Scanner inputNum = new Scanner(System.in);
    int numOfRounds = inputNum.nextInt();
    System.out.println(numOfRounds);

    System.out.println("What's up?");
    Scanner getNextLine = new Scanner(System.in);


    for(int i=1;i<=numOfRounds;i++){
      String nextLine = getNextLine.nextLine();
      System.out.println(nextLine);
     
    
  
    }
    
    inputNum.close();
    getNextLine.close();

    
  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {

  }

  

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  
   public String respond(String inputString) {
    Dictionary<String, String> wordSwitches = new Hashtable<>();
    wordSwitches.put("I", "you");
    wordSwitches.put("me", "you");
    wordSwitches.put("am", "are");
    wordSwitches.put("you", "I");
    wordSwitches.put("my", "your");
    wordSwitches.put("your", "my");


    wordSwitches.put("yours", "mine");
    wordSwitches.put("mine", "yours");
    wordSwitches.put("myself", "yourself");
    wordSwitches.put("yourself", "myself");

    String[] inputStringParts = inputString.split(" ");

    for (int i = 0; i < inputStringParts.length; i++) {
      
      }
    }

    


    String returnString = "[,\\s]+"; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
  }
}
