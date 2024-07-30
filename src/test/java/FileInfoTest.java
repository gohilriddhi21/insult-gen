import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileInfoTest {
  FileInfo fileInfo;

  @BeforeEach
  void setUp() {
    fileInfo =  new FileInfo("poem.json", "Poem Generator");
  }

  @Test
  void getFileName() {
    Assertions.assertEquals("poem.json", fileInfo.getFileName());
  }

  @Test
  void getFileTitle() {
    Assertions.assertEquals("Poem Generator", fileInfo.getFileTitle());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("FileInfo{fileName='poem.json', fileTitle='Poem Generator'}", fileInfo.toString());
  }

  @Test
  void testEquals() {
    FileInfo fileInfo1 = new FileInfo("insult.json","Insult Generator");
    Assertions.assertFalse(fileInfo.equals(fileInfo1));
  }

  @Test
  void testHashCode() {
    FileInfo fileInfo1 = new FileInfo("insult.json","Insult Generator");
    assertFalse(fileInfo.hashCode()==(fileInfo1.hashCode()));
  }
}