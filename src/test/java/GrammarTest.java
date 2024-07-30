import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrammarTest {
  Grammar grammar;
  String filePath;

  @BeforeEach
  void setUp() {
    grammar = new Grammar();
  }

  @Test
  void generateGrammar() {
    filePath = "src/main/resources/grammars/insult_grammar.json";
    String generatedSentence = grammar.generateGrammar(filePath);
    assertNotNull(generatedSentence);
    assertFalse(generatedSentence.isEmpty());
  }

  @Test
  void testToString() {
    String expected = "Grammar{}";
    assertEquals(expected, grammar.toString());
  }

  @Test
  void testEquals() {
    Grammar grammar2 = new Grammar();
    assertNotEquals(grammar, grammar2);
    Object obj = new Object();
    assertNotEquals(grammar, obj);
 }

  @Test
  void testHashCode() {
    Grammar sameGrammar = new Grammar();
    assertNotEquals(grammar.hashCode(), sameGrammar.hashCode());
    Object obj = new Object();
    assertNotEquals(grammar.hashCode(), obj.hashCode());
  }
}