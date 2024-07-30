import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.io.PrintStream;
import org.junit.jupiter.api.*;

class RandomSentenceGeneratorTest {
  RandomSentenceGenerator obj;
  private ByteArrayOutputStream outputStream;

  @BeforeEach
  void setUp() {
    obj = new RandomSentenceGenerator();
    outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  void testMainWithValidDirectory() {
    String validDirectoryName = "grammars";
    obj.main(new String[]{validDirectoryName});
    String output = outputStream.toString();
    Assertions.assertFalse(output.contains("Exception."));
  }

  @Test
  void testMainWithInvalidDirectory() {
    String invalidDirectoryName = "invalid_directory";
    obj.main(new String[]{invalidDirectoryName});
    String output = outputStream.toString();
    Assertions.assertTrue(output.contains("Directory does not exist!"));
  }

  @Test
  void testMainWithEmptyDirectory() {
    String emptyDirectoryName = "empty_directory";
    obj.main(new String[]{emptyDirectoryName});
    String output = outputStream.toString();
    Assertions.assertTrue(output.contains("No files found in the directory."));
  }

  @Test
  void testMainWithNoDirectory() {
    obj.main(new String[]{});
    String output = outputStream.toString();
    Assertions.assertTrue(output.contains("Directory name was not passed."));
  }
}


