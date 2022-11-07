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
      reader.read(cb, 0, str.length());
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
      char c3 = (char) randomAccessFile.readByte();
      //get position
      long pos = randomAccessFile.getFilePointer();
      //write a char from position
      randomAccessFile.writeByte('d');
      //close
      randomAccessFile.close();
    } catch (IOException exception) {
    }
  }

  public static boolean testAll() {
    boolean ret = true;
    String str = "output";
    try (
        FileWriter outFile = new FileWriter("test.txt")) {
      boolean isOpen = true;
      ret = ret && isOpen;
      outFile.append('c');
      outFile.append(str).append('\n');
    } catch (IOException exception) {
    }
    try (
        FileWriter appFile = new FileWriter("test.txt", true)) {
      appFile.append('d');
    } catch (IOException exception) {
    }
    try (
        FileReader inFile = new FileReader("test.txt");
        PushbackReader reader = new PushbackReader(inFile)) {
      ret = ret && (char) reader.read() == 'c';
      char c2 = (char) reader.read();
      reader.unread(c2);
      ret = ret && c2 == 'o';
      char[] cb = new char[100];
      reader.read(cb, 0, str.length());
      String str2 = new String(cb, 0, str.length());

      ret = ret && str.equals(str2);
      ret = ret && (char) reader.read() == '\n';
      ret = ret && (char) reader.read() == 'd';
    } catch (IOException exception) {
    }
    try (
        FileOutputStream binaryOutFile = new FileOutputStream("binary-test.txt");
        DataOutputStream dataOutFile = new DataOutputStream(binaryOutFile)) {
      dataOutFile.write(str.getBytes());
      int intNum = 10;
      dataOutFile.writeInt(intNum);
      double doubleNum = 3.14;
      dataOutFile.writeDouble(doubleNum);
    } catch (IOException exception) {
    }
    try (
        FileInputStream binaryInFile = new FileInputStream("binary-test.txt");
        DataInputStream dataInFile = new DataInputStream(binaryInFile)) {
      byte[] bytes = new byte[str.getBytes().length];
      dataInFile.read(bytes);
      String str2 = new String(bytes);
      ret = ret && str.equals(str2);
      int intNum = dataInFile.readInt();
      ret = ret && intNum == 10;
      double doubleNum = dataInFile.readDouble();
      ret = ret && doubleNum == 3.14;
      File file = new File("binary-test.txt");
      long length = file.length();
      ret = ret && length == 18;
    } catch (IOException exception) {
    }
    try (
        RandomAccessFile randomAccessFile = new RandomAccessFile("test.txt", "rw")) {
      randomAccessFile.seek(3);
      ret = ret && (char)randomAccessFile.readByte() == 't';
      ret = ret && randomAccessFile.getFilePointer() == 4;
      randomAccessFile.writeByte('e');
      randomAccessFile.seek(4);
      ret = ret && (char)randomAccessFile.readByte() == 'e';
    } catch (IOException exception) {
    }

    if (!ret)
      System.out.print("Fstream Test Failed!");
    return ret;
  }
}
