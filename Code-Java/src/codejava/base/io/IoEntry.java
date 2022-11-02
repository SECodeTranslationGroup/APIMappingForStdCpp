package codejava.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;


public class IoEntry {
  private final static String filename = "FILENAME.txt";
  private final static int size = 10;
  private static byte[] buf = {0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x40};
  public static void IoProgram() throws IOException {
    File tmp = File.createTempFile("jms", ".txt");

    File file = new File(filename);
    Files.deleteIfExists(file.toPath());

    tmp.renameTo(file);
    // File open
    FileInputStream fis = new FileInputStream(filename);
    // File write
    FileOutputStream fos = new FileOutputStream(filename);
    fos.write(buf, 0, buf.length);
    fos.flush();
    // File read
    byte [] buf1 = new byte[10];
    int n = fis.read(buf1, 0, buf1.length);
    System.out.println(new String(buf1));
    fis.close();
    fos.close();

    FileWriter fw = new FileWriter(file, true);

    fw.write("This is a ababababababaaabababaabababa!\n");
    fw.write("Second line is also meaningless.\n");
    fw.write("This is the third line.\n");
    fw.flush();
    fw.close();

    char []chars = new char[10];
    FileReader fr = new FileReader(file);
    fr.read(chars, 0, 10);
    fr.read(chars, 0, 10);
    System.out.println(chars);
    fr.close();

    // String Reader, Writer
    StringWriter sw = new StringWriter();
    char [] charSeq = "return 0;".toCharArray();
    char a = ';';
    sw.write(charSeq, 0, 7);
    sw.write("max(Alice.Money, Bob.Money)");
    sw.write(" >1000? me", 1, 5);
    sw.write(a);

    sw.append('\n');
    sw.append("\\\\ Reconstruction! \n");
    // different from write in parameter meaning
    sw.append("uncompleted or fail", 2,11);
    sw.flush();

    String line = sw.toString();
    System.out.print(line);
    sw.close();

    StringReader sr = new StringReader(line);
    sr.mark(1);
    int c = sr.read();
    sr.reset();
    System.out.println((char) c);

    char[] re = new char[7];
    sr.read(re, 0, re.length);
    System.out.print(re);

    int d = sr.read();
    System.out.println((char) d);
    sr.close();

    RandomAccessFile rf = new RandomAccessFile(file, "rw");
    rf.seek(10);
    int e = rf.readByte();
    System.out.println((char) e);
//
//        long pos = rf.getFilePointer();
//
//        // Java Character length is 2 bytes
//        Character wc = 'c';
//        rf.writeChar(wc);
//        rf.seek(pos);
//        Character rc = rf.readChar();
//        System.out.print("\n" + rc + "\n");
//
//        pos = rf.getFilePointer();
//        rf.writeBytes("Hello, World!");
//        rf.seek(pos);
//
//        byte []read_rf = new byte[10];
//        rf.read(read_rf);
//        System.out.print(new String(read_rf));
//
//        String message = String.format("[%d]\t[%10s]", 10, "Hello");
//        rf.write('\n');
//
//        pos = rf.getFilePointer();
//        rf.writeBytes(message);
//        rf.seek(pos);
//
//        String rf_read = rf.readLine();
//        System.out.print('\n'+rf_read);
//        rf.close();
  }
}