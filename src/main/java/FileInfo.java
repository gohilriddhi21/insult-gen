import java.util.Objects;

/**
 * The FileInfo class represents information about a file, i.e. the name of the file and its title.
 */
public class FileInfo {

  private String fileName;

  private String fileTitle;

  /**
   * Constructs a new FileInfo object with the specified file name and title.
   * @param fileName The name of the file, expressed as a String.
   * @param fileTitle The title associated with the file, expressed as a String.
   */
  public FileInfo(String fileName, String fileTitle) {
    this.fileName = fileName;
    this.fileTitle = fileTitle;
  }

  /**
   * Returns the name of the file.
   * @return the name of the file.
   */
  public String getFileName() {
    return this.fileName;
  }

  /**
   * Returns the title of the file.
   * @return the title of the file.
   */
  public String getFileTitle() {
    return this.fileTitle;
  }


  /**
   * {@inheritDoc}
   * Overrides the toString function.
   */
  @Override
  public String toString() {
    return "FileInfo{" +
        "fileName='" + this.fileName + '\'' +
        ", fileTitle='" + this.fileTitle + '\'' +
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
