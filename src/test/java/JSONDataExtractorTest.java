import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;

class JSONDataExtractorTest {
  JSONDataExtractor jsonDataExtractor;
  String filePath;

  @BeforeEach
  void setUp() {
    jsonDataExtractor = new JSONDataExtractor();
    filePath = "src/main/resources/grammars/insult_grammar.json";
  }

  @Test
  void getTag() {
    String key = "start";
    String tag = jsonDataExtractor.getTag(filePath, key);
    Assertions.assertNotNull(tag);
    Assertions.assertFalse(tag.isEmpty());
  }

  @Test
  void readJSONFile() {
    String content1 = jsonDataExtractor.readJSONFile(filePath);
    Assertions.assertNotNull(content1 );
  }

  @Test
  void getGrammarTitle() {
    String grammarTitle = jsonDataExtractor.getGrammarTitle(filePath);
    Assertions.assertTrue(grammarTitle.equals("Insult Generator") );
  }

  @Test
  void testToString() {
    Assertions.assertEquals("JSONDataExtractor{}", jsonDataExtractor.toString());
  }

  @Test
  void testEquals() {
    JSONDataExtractor jsonDataExtractor2 = new JSONDataExtractor();
    Assertions.assertTrue(jsonDataExtractor.equals(jsonDataExtractor));
    Assertions.assertFalse(jsonDataExtractor.equals(jsonDataExtractor2));
    Assertions.assertFalse(jsonDataExtractor.equals(null));
    Object notAParser = new Object();
    Assertions.assertFalse(jsonDataExtractor2.equals(notAParser));
  }

  @Test
  void testHashCode() {
    JSONDataExtractor jsonDataExtractor2 = new JSONDataExtractor();
    Assertions.assertFalse(jsonDataExtractor.hashCode()==jsonDataExtractor2.hashCode());
  }

  @Test
  void testExceptions(){
    String nonExistentFilePath = "nonexistent_file.json";
    Assertions.assertThrows(RuntimeException.class, () -> {
      jsonDataExtractor.getTag(nonExistentFilePath, "non_existent_key");
    });

    Assertions.assertThrows(RuntimeException.class, () -> {
      jsonDataExtractor.getTag(nonExistentFilePath, "non_existent_some_key");
    });

    Assertions.assertThrows(RuntimeException.class, () -> {
      jsonDataExtractor.readJSONFile(nonExistentFilePath);
    });

    Assertions.assertThrows(RuntimeException.class, () -> {
      jsonDataExtractor.getGrammarTitle(nonExistentFilePath);
    });
  }

}