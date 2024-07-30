import java.util.regex.*;

/**
 * The Grammar class facilitates the generation of random sentences
 * using a Context Free Grammar (CFG) described in a JSON file. It
 * recursively expands non-terminal elements until a complete sentence
 * is formed.
 */
public class Grammar {
  private JSONDataExtractor parser;

  /**
   * Represents the keyword "start" used to indicate the start symbol in a grammar.
   */
  public static final String START_KEYWORD = "start";

  /**
   * Represents the regular expression used to match non-terminal symbols in a grammar.
   */
  public static final String REGEX_FOR_NON_TERMINALS = "<(\\w+)>";

  /**
   * Represents the left separator for non-terminal symbols.
   */
  public static final String NON_TERMINAL_LEFT_SEPARATOR = "<";

  /**
   * Represents the right separator for non-terminal symbols.
   */
  public static final String NON_TERMINAL_RIGHT_SEPARATOR = ">";

  /**
   * Represents the word inside the separators &lt; and &gt; using REGEX_FOR_NON_TERMINALS
   */
  public static final int WORD_INSIDE_SEPARATOR_GROUP = 1;

  /**
   * Constructs a new Grammar instance with an empty history list.
   */
  public Grammar() {
    this.parser = new JSONDataExtractor();
  }


  /**
   * Generates a random sentence based on the grammar defined in the specified JSON file.
   * @param fileName The name of the JSON file the user selected, and which contains the grammar rules.
   * @return A randomly generated sentence based on the grammar rules as a String.
   */
  public String generateGrammar(String fileName) {
    String start = this.parser.getTag(fileName, START_KEYWORD);
    return expandGrammar(fileName, start);
  }

  /**
   * Recursively expands non-terminal elements in the grammar until a complete sentence is formed.
   * @param fileName The name of the JSON file the user selected, and which contains the grammar rules.
   * @param nonTerminalString The non-terminal string to be expanded recursively.
   * @return The expanded string with non-terminal elements replaced as a String.
   */
  private String expandGrammar(String fileName, String nonTerminalString) {
    Pattern pattern = Pattern.compile(REGEX_FOR_NON_TERMINALS);
    Matcher matcher =pattern.matcher(nonTerminalString);
    while (matcher.find())
    {
      String match = matcher.group(WORD_INSIDE_SEPARATOR_GROUP);
      nonTerminalString = nonTerminalString.replace(NON_TERMINAL_LEFT_SEPARATOR + match + NON_TERMINAL_RIGHT_SEPARATOR, this.parser.getTag(fileName, match));
      matcher = pattern.matcher(nonTerminalString);
    }
    return nonTerminalString;
  }

  /**
   * {@inheritDoc}
   * Overrides the toString function.
   */
  @Override
  public String toString() {
    return "Grammar{}";
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
