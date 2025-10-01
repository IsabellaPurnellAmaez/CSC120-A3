import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


class Conversation implements Chatbot {

  // Attributes
    List<String> transcript; 
  /**
   * Constructor
   */
  Conversation() {
    this.transcript = new ArrayList<>();
  }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {

    // first, ask how many rounds they want to play

    System.out.println("How many rounds do you want to play?");
    Scanner input = new Scanner(System.in);
    int numOfRounds = input.nextInt();
    input.nextLine();


    //start conversationn
    System.out.println("What's up?");
    this.transcript.add("What's up?");

    //hold conversation (get response from response method and then ask for next input for determined number of rounds)
    for (int i = 1; i <= numOfRounds; i++) {
      String nextLine = input.nextLine();
      this.transcript.add(nextLine);
      String Response = respond(nextLine);
      this.transcript.add(Response);
      System.out.println(Response);
    }

    input.close();
    //saay goodbye!
    System.out.println("Ok, goodbye!");
    this.transcript.add("Ok, goodbye!");
    printTranscript();

  }

  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    //print transcript out line by line
    System.out.println("TRANSCRIPT:");
    for (int i = 0; i < this.transcript.size(); i++){
      System.out.println(this.transcript.get(i));
}
  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  
   public String respond(String inputString) {
    HashMap<String, String> wordSwitches = new HashMap<>();
    //words to switch
    wordSwitches.put("I", "you");
    wordSwitches.put("me", "you");
    wordSwitches.put("am", "are");
    wordSwitches.put("you", "I");
    wordSwitches.put("my", "your");
    wordSwitches.put("your", "my");
    wordSwitches.put("are", "am");
    wordSwitches.put("yours", "mine");
    wordSwitches.put("mine", "yours");
    wordSwitches.put("myself", "yourself");
    wordSwitches.put("yourself", "myself");

    //make a copy of the input that doesn't get changed
    String inputStringCopy = inputString;
    String[] inputStringParts = inputString.split(" "); 

    //check if any words should be switched
    String finalsentence = "";
    for (int i = 0; i < inputStringParts.length; i++) {
      if(wordSwitches.containsKey(inputStringParts[i])){
        inputStringParts[i] = wordSwitches.get(inputStringParts[i]);
      }    
      //string words back together
      finalsentence = finalsentence + inputStringParts[i] + " ";
    }
    //list of canne responses
    String[] cannedResponses = {"Wow!", "Say more?", "That's very interesting.", "I want to talk about something else please."};

    //if the sentence had no words switched, send a canned response
    if(finalsentence.equals(inputStringCopy + " ")){
      int cannedResponsesLength = cannedResponses.length;
      Random random = new Random();
      int bound = cannedResponsesLength; 
      int randomNumber = random.nextInt(bound);
      return cannedResponses[randomNumber];
    }

    //return a response sentence
    return finalsentence; 
    }

    /**
     * Main method to start the conversation
     */
    public static void main(String[] args) {
      Conversation myConversation = new Conversation();
      myConversation.chat();
    }
  }

