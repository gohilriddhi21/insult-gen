import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * The UserInterface class provides a command-line interface for interacting with the
 * Random Sentence Generator program.
 */
public class UserInterface {

  private static final String JSON_EXTENSION = ".json" ;
  private Map<Integer, FileInfo> grammarFiles;

  private Grammar grammar;

  /**
   * The default directory location for grammar files which will be appended to the user provided path. */
  public static String DIRECTORY_BASE_LOCATION = "src/main/resources/";

  /**
   * Represents the uppercase letter "Y".
   */
  public static final String UPPERCASE_Y = "Y";

  /**
   * Represents the lowercase letter "y".
   */
  public static final String LOWERCASE_Y = "y";

  /**
   * Represents the uppercase letter "Y".
   */
  public static final String UPPERCASE_N = "N";

  /**
   * Represents the lowercase letter "y".
   */
  public static final String LOWERCASE_N = "n";

  /**
   * Represents the uppercase letter "Q".
   */
  public static final String UPPERCASE_Q = "Q";

  /**
   * Represents the lowercase letter "q".
   */
  public static final String LOWERCASE_Q = "q";

  /**
   * Represents the file separator for the current platform.
   * For example, "/" in Unix-based systems and "\" in Windows systems.
   */
  public static final String FILE_SEPARATOR = "/";

  /**
   * Represents number 1 for getting files names after user inputs a number
   */
  public static final int ONE = 1;

  /**
   * Represents number -1 for checking if input valid or not
   */
  public static final int INVALID_INPUT = -1;

  /**
   * Represents number 0 for checking if input is greater than 0
   */
  public static final int MINIMUM_INPUT = 0;

  /**
   * Constructs a new UserInterface object with an empty map of grammar files.
   */
  public UserInterface() {
    this.grammarFiles = new HashMap<>();
    this.grammar = new Grammar();
  }

  /**
   * Function that starts the user interface for loading and generating random sentences based on grammar files.
   * @param dirName The name of the directory containing the grammar files.
   */
  public void start(String dirName) {
    System.out.println("\nLoading grammars.... \n");
    loadGrammarsFromDirectory(DIRECTORY_BASE_LOCATION + dirName);
    Scanner scanner = new Scanner(System.in);

    while (true) {
      printFileName();
      String choice = scanner.nextLine();
      if ((Objects.equals(choice, UPPERCASE_Q) || Objects.equals(choice, LOWERCASE_Q) )) break;
      int inputAsInteger = checkInput(choice);
      if (inputAsInteger == INVALID_INPUT) {
        System.out.println("Invalid input. Try again.\n");
        continue;
      }
      selectFileAndGenerateGrammar(dirName, checkInput(choice));
      boolean ifContinue = true;
      while (ifContinue) {
        System.out.println("Would you like another? (y/n)");
        String var = scanner.nextLine();
        if (Objects.equals(var, LOWERCASE_Y) || Objects.equals(var, UPPERCASE_Y)) {
          selectFileAndGenerateGrammar(dirName, Integer.parseInt(choice));
        } else if (Objects.equals(var, UPPERCASE_N) || Objects.equals(var, LOWERCASE_N)){
          ifContinue = false;
        } else {
          System.out.println("Invalid input. Try again.\n");
        }
      }
    }
  }

  private int checkInput(String choice) {
    int number = INVALID_INPUT;
    try {
      number = Integer.parseInt(choice);
      if (number > MINIMUM_INPUT && number <= grammarFiles.size()) return number;
      else return INVALID_INPUT;
    } catch (NumberFormatException e) {
      return number;
    }
  }


  /**
   * Selects a grammar file, generates a random sentence, and displays the result.
   * @param dirName The name of the directory containing the grammar files.
   * @param choice The user's choice.
   */
  private void selectFileAndGenerateGrammar(String dirName, int choice){
    System.out.println(grammar.generateGrammar( DIRECTORY_BASE_LOCATION + dirName + FILE_SEPARATOR + this.grammarFiles.get(choice-ONE).getFileName()) + "\n");
  }


  /**
   * Loads grammar files from a specified directory path and populates the grammarFiles map.
   * @param dirFilePath The path of the directory containing the grammar files.
   * @throws RuntimeException when files not present in directory
   */
  private void loadGrammarsFromDirectory(String dirFilePath) {
    File directory = new File(dirFilePath);
    if (!directory.exists() || !directory.isDirectory())
      throw new RuntimeException("Directory does not exist!");

    JSONDataExtractor parser = new JSONDataExtractor();

    File[] files = directory.listFiles();
    int index = 0;

    if (files != null) {
      for (File file : files) {
        if (file.isFile() && file.getName().toLowerCase().endsWith(JSON_EXTENSION)) {
          String title = parser.getGrammarTitle(dirFilePath + FILE_SEPARATOR + file.getName());
          grammarFiles.put(index++, new FileInfo(file.getName(), title));
        }
      }
    }
    if (grammarFiles.isEmpty()) throw new RuntimeException("No files found in the directory.");
  }

  /**
   * Prints the title of available grammar files and prompts the user for their choice.
   */
  private void printFileName() {
    System.out.println("The following grammars are available:");
    grammarFiles.forEach(
        (key, value) -> System.out.println((key + ONE) + ". " + value.getFileTitle())
    );
    System.out.println("Which would you like to use? (q to quit)");
  }

  /**
   * {@inheritDoc}
   * Overrides the toString function.
   */
  @Override
  public String toString() {
    return "UserInterface{" +
        "grammarFiles=" + grammarFiles +
        '}';
  }

  /**
   * {@inheritDoc}
   * Overrides the equals function.
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * {@inheritDoc}
   * Overrides the hashCode function.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
