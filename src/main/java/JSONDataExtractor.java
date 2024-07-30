import java.io.FileReader;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The JSONDataExtractor class, which provides methods to parse a JSON file and extract information from it.
 */
public class JSONDataExtractor {

  /**
   * Represents the keyword "grammarTitle" used to identify the title of a grammar.
   */
  public static final String GRAMMAR_TITLE_KEYWORD = "grammarTitle";

  /**
   * Represents the value used to check the end of a stream.
   * The value is set to -1 to indicate the end of a stream while reading from an input source.
   */
  public static final int END_OF_STREAM_CHECK = -1;

  /**
   * Retrieves the value of the specified key from the JSON file.
   * @param filePath The file path of the JSON file.
   * @param key The key corresponding to the JSON array containing the elements.
   * @return A randomly selected element from the JSON array.
   */
  public String getTag(String filePath, String key) {
    try {
      String jsonContent = readJSONFile(filePath);
      JSONObject jsonObject = new JSONObject(jsonContent);
      String actualKey = findCaseInsensitiveKey(jsonObject, key);
      JSONArray keyArray = jsonObject.getJSONArray(actualKey);
      int randomIndex = (int) (Math.random() * (keyArray.length()));
      return keyArray.getString(randomIndex);
    } catch (RuntimeException e) {
      throw new RuntimeException("Error parsing JSON or tag not found.", e);
    }
  }

  private String findCaseInsensitiveKey(JSONObject jsonObject, String key) {
    for (String jsonKey : jsonObject.keySet()) {
      if (jsonKey.equalsIgnoreCase(key)) {
        return jsonKey;
      }
    }
    return null;
  }

  /**
   * Reads the contents of a JSON file and returns it as a string.
   * @param filePath The file path of the JSON file.
   * @return The content of the JSON file as a string.
   * @throws RuntimeException if an error occurs while processing the JSON file.
   */
  public String readJSONFile(String filePath){
    try {
      FileReader reader = new FileReader(filePath);
      StringBuilder content = new StringBuilder();
      int i;
      while ((i = reader.read()) != END_OF_STREAM_CHECK) {
        content.append((char) i);
      }
      reader.close();
      return content.toString();
    }catch (Exception e) {
      throw new RuntimeException("An error occurred while processing the JSON file.", e);
    }
  }

  /**
   * Function that retrieves the grammar title from a JSON file.
   * @param fileName The name of the JSON file.
   * @return The grammar title extracted from the JSON file.
   */
  public String getGrammarTitle(String fileName) {
    String content = readJSONFile(fileName);
    JSONObject jsonObject = new JSONObject(content);
    return jsonObject.getString(GRAMMAR_TITLE_KEYWORD);
  }

  /**
   * {@inheritDoc}
   * Overrides the toString function.
   */
  @Override
  public String toString() {
    return "JSONDataExtractor{}";
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
