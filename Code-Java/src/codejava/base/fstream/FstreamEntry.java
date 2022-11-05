package codejava.base.fstream;

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
    //initialize string
    String str = "output";
    //create file
    File file = new File("file.txt");
    try {
      file.createNewFile();
    } catch (IOException e) {
    }
    //open output file stream
    try (
        FileWriter outFile = new FileWriter("file.txt")) {
      //whether open operation succeeds
      boolean isOpen = true;
      //write a char
      outFile.append('c');
      //write a string with line seperator
      outFile.append(str).append('\n');
      //close
      outFile.close();
    } catch (IOException exception) {
      boolean isOpen = true;
    }
    //open input file stream
    try (
        FileReader inFile = new FileReader("file.txt");
        PushbackReader reader = new PushbackReader(inFile)) {
      //get first char
      char c1 = (char) reader.read();
      //peek next char
      char c2 = (char) reader.read();
      reader.unread(c2);
      //intialize a buffer
      char[] cb = new char[100];
      //read several char into buffer
      inFile.read(cb, 0, str.length());
      //create string from buffer
      str = new String(cb, 0, str.length());
      //close
      inFile.close();
    } catch (IOException exception) {
    }
    //open append file stream
    try (
        FileWriter appFile = new FileWriter("file.txt", true)) {
      //append a char
      appFile.append('c');
      //close
      appFile.close();
    } catch (IOException exception) {
    }
    //open binary output file stream
    try (
        FileOutputStream binaryOutFile = new FileOutputStream("file.txt");
        DataOutputStream dataOutFile = new DataOutputStream(binaryOutFile)) {
      //write string data in binary
      dataOutFile.write(str.getBytes());
      //write int data in binary
      int intNum = 10;
      dataOutFile.writeInt(intNum);
      //write double data in binary
      double doubleNum = 3.14;
      dataOutFile.writeDouble(doubleNum);
      //close
      dataOutFile.close();
    } catch (IOException exception) {
    }
    //open binary input file stream
    try (
        FileInputStream binaryInFile = new FileInputStream("file.txt");
        DataInputStream dataInFile = new DataInputStream(binaryInFile)) {
      //read string data in binary
      byte[] bytes = new byte[str.getBytes().length];
      dataInFile.read(bytes);
      str = new String(bytes);
      //read int data in binary
      int intNum = dataInFile.readInt();
      //read double data in binary
      double doubleNum = dataInFile.readDouble();
      //get byte length of binary file
      long length = file.length();
      //close
      dataInFile.close();
    } catch (IOException exception) {
    }
    //open random access file stream
    try (
        RandomAccessFile randomAccessFile = new RandomAccessFile("file.txt", "rw")) {
      //set position
      randomAccessFile.seek(3);
      //get a char from position
      char c3 = (char) randomAccessFile.readChar();
      //get position
      long pos = randomAccessFile.getFilePointer();
      //write a char from position
      randomAccessFile.writeChar('d');
      //close
      randomAccessFile.close();
    } catch (IOException exception) {
    }
  }
}
