import java.util.Scanner;

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
    Scanner input = new Scanner(System.in);
    int numOfRounds = input.nextInt();
    input.close();
    System.out.println(numOfRounds);

    for(int i=1;i<=numOfRounds;i++){
      System.out.println("next line");
      String nextConvoPiece = input.nextLine();
      respond(nextConvoPiece);
      input.close();
    }
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
    String returnString = ""; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }
}
