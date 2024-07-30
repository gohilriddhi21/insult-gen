import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class UserInterfaceTest {
  UserInterface ui;
  String filePath;

  @BeforeEach
  void setUp() {
    ui = new UserInterface();
  }

  @Test
  void start() {
    String dirName = "grammars";
    String choice = "1\ny\nn\nq\n";
    InputStream originalSystemIn = System.in;
    ByteArrayInputStream inputStream = new ByteArrayInputStream(choice.getBytes());
    System.setIn(inputStream);
    ui.start(dirName);
    System.setIn(originalSystemIn);
    Assertions.assertNotNull(ui);
  }

  @Test
  void start2() {
    String dirName = "grammars";
    String choice = "6\n1\ny\nn\nq\n";
    InputStream originalSystemIn = System.in;
    ByteArrayInputStream inputStream = new ByteArrayInputStream(choice.getBytes());
    System.setIn(inputStream);
    ui.start(dirName);
    System.setIn(originalSystemIn);
    Assertions.assertNotNull(ui);
  }

  @Test
  void start3() {
    String dirName = "grammars";
    String choice = "6\n1\nf\nn\nq\n";
    InputStream originalSystemIn = System.in;
    ByteArrayInputStream inputStream = new ByteArrayInputStream(choice.getBytes());
    System.setIn(inputStream);
    ui.start(dirName);
    System.setIn(originalSystemIn);
    Assertions.assertNotNull(ui);
  }

  @Test
  void start4() {
    String dirName = "grammars";
    String choice = "f\n1\nn\nq\n";
    InputStream originalSystemIn = System.in;
    ByteArrayInputStream inputStream = new ByteArrayInputStream(choice.getBytes());
    System.setIn(inputStream);
    ui.start(dirName);
    System.setIn(originalSystemIn);
    Assertions.assertNotNull(ui);
  }

  @Test
  void testToString() {
    Assertions.assertEquals("UserInterface{grammarFiles={}}", ui.toString());
  }

  @Test
  void testEquals() {
    UserInterface ui2 = new UserInterface();
    Assertions.assertFalse(ui.equals(ui2));
  }

  @Test
  void testHashCode() {
    UserInterface ui2 = new UserInterface();
    Assertions.assertFalse(ui.hashCode()==ui2.hashCode());
  }
}