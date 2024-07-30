/**
 * The RandomSentenceGenerator class serves as the entry point for the Random Sentence Generator program.
 * It contains the main method which initializes the UserInterface and starts the program.
 */
public class RandomSentenceGenerator {
  /**
   * The main method that initializes the UserInterface and starts the program.
   * @param args Command-line arguments (expects the directory location as args[0]).
   */
  public static void main(String[] args) {
    try {
      if (args.length == 0) {
        System.out.println("\nDirectory name was not passed.");
      } else {
        UserInterface ui = new UserInterface();
        ui.start(args[0]);
      }
    }
    catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

}
