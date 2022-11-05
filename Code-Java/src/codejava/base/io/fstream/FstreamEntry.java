package codejava.base.io.fstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class FstreamEntry {
  public static void FstreamProgram() {
    String str = "output";
    File file = new File("file.txt");
    try {
      file.createNewFile();
    } catch (IOException e) {
    }
    boolean isOpen = true;
    try (
        FileWriter outFile = new FileWriter("file.txt")) {
      outFile.append('c');
      outFile.append(str);
      outFile.append('\n');
      outFile.close();
    } catch (IOException exception) {
      isOpen = false;
    }

    try (
        FileReader inFile = new FileReader("file.txt");
        PushbackReader reader = new PushbackReader(inFile)) {
      char c1 = (char) reader.read();
      char c2 = (char) reader.read();
      reader.unread(c2);
      char[] cb = new char[100];
      inFile.read(cb, 0, str.length());
      str = Arrays.toString(cb);
      inFile.close();
    } catch (IOException exception) {
    }

    try (
        FileWriter appFile = new FileWriter("file.txt", true)) {
      appFile.append('c');
    } catch (IOException exception) {
    }

    try (
        FileOutputStream binaryOutFile = new FileOutputStream("file.txt");
        DataOutputStream dataOutFile = new DataOutputStream(binaryOutFile)) {
      dataOutFile.write(str.getBytes());
      int intNum = 10;
      dataOutFile.writeInt(intNum);
      double doubleNum = 3.14;
      dataOutFile.writeDouble(doubleNum);
      dataOutFile.close();
    } catch (IOException exception) {
    }

    try (
        FileInputStream binaryInFile = new FileInputStream("file.txt");
        DataInputStream dataInFile = new DataInputStream(binaryInFile)) {
      byte[] bytes = new byte[str.getBytes().length];
      dataInFile.read(bytes);
      str = new String(bytes);
      int intNum = dataInFile.readInt();
      double doubleNum = dataInFile.readDouble();
      long length = file.length();

      dataInFile.close();
    } catch (IOException exception) {
    }

    try (
        RandomAccessFile randomAccessFile = new RandomAccessFile("file.txt", "rw")) {
      randomAccessFile.seek(3*2);
      char c3 = (char) randomAccessFile.readChar();
      long pos = randomAccessFile.getFilePointer();
      randomAccessFile.writeChar('d');
      randomAccessFile.close();
    } catch (IOException exception) {
    }
  }
}
