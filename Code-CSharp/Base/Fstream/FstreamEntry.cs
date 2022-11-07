namespace CodeCsharp.Base.Fstream;

using System.Text;

public class FstreamEntry {
  public static void FstreamProgram() {
    //initialize string
    string str = "output";

    //create file
    //open output file stream
    try {
      FileStream outFile = File.Open("file.txt", FileMode.Create, FileAccess.Write);
      StreamWriter writer = new StreamWriter(outFile);
      //whether open operation succeeds
      bool isOpen = true;
      //write a char
      writer.Write('c');
      //write a string with line seperator
      writer.WriteLine(str);
      //close
      outFile.Close();
    } catch (IOException exception) {
      bool isOpen = false;
    }

    //open input file stream
    try {
      FileStream inFile = File.Open("file.txt", FileMode.Open, FileAccess.Read);
      StreamReader reader = new StreamReader(inFile);
      //get first char
      char c1 = (char)reader.Read();
      //peek next char
      char c2 = (char)reader.Peek();
      //intialize a buffer
      char[] cb = new char[100];
      //read several char into buffer
      reader.Read(cb, 0, str.Length);
      //create string from buffer
      str = new string(cb);
      //close
      inFile.Close();
    } catch (IOException exception) {
    }

    //open append file stream
    try {
      FileStream appFile = File.Open("file.txt", FileMode.Append, FileAccess.Write);
      StreamWriter writer = new StreamWriter(appFile);
      //append a char
      writer.Write('c');
      //close
      appFile.Close();
    } catch (IOException exception) {
    }

    //open binary output file stream
    try {
      FileStream binaryOutFile = new FileStream("file.txt", FileMode.Create, FileAccess.Write);
      BinaryWriter dataOutFile = new BinaryWriter(binaryOutFile);
      //write string data in binary
      dataOutFile.Write(Encoding.UTF8.GetBytes(str));
      //write int data in binary
      int intNum = 10;
      dataOutFile.Write(intNum);
      //write double data in binary
      double doubleNum = 3.14;
      dataOutFile.Write(doubleNum);
      //close
      binaryOutFile.Close();
    } catch (IOException exception) {
    }

    //open binary input file stream
    try {
      FileStream binaryInFile = new FileStream("file.txt", FileMode.Open, FileAccess.Read);
      BinaryReader dataInFile = new BinaryReader(binaryInFile);
      //read string data in binary
      byte[] bytes = new byte[Encoding.UTF8.GetByteCount(str)];
      bytes = dataInFile.ReadBytes(bytes.Length);
      str = Encoding.UTF8.GetString(bytes);
      //read int data in binary
      int intNum = dataInFile.ReadInt32();
      //read double data in binary
      double doubleNum = dataInFile.ReadDouble();
      //get byte length of binary file
      long length = binaryInFile.Length;
      //close
      binaryInFile.Close();
    } catch (IOException exception) {
    }

    //open random access file stream
    try {
      //set position
      FileStream randomAccessFile = new FileStream("file.txt", FileMode.Open, FileAccess.ReadWrite);
      //get a char from position
      randomAccessFile.Seek(3, SeekOrigin.Begin);
      char c3 = (char)randomAccessFile.ReadByte();
      //get position
      long pos = randomAccessFile.Position;
      //write a char from position
      randomAccessFile.Write(new[] { (byte)'d' });
      //close
      randomAccessFile.Close();
    } catch (IOException exception) {
    }
  }

  public static bool TestAll() {
    bool ret = true;
    string str = "output";
    try {
      FileStream outFile = File.Open("test.txt", FileMode.Create, FileAccess.Write);
      StreamWriter writer = new StreamWriter(outFile);
      bool isOpen = true;
      writer.Write('c');
      writer.WriteLine(str);
    } catch (IOException exception) {
      bool isOpen = false;
    }

    try {
      FileStream appFile = File.Open("test.txt", FileMode.Append, FileAccess.Write);
      StreamWriter writer = new StreamWriter(appFile);
      writer.Write('d');
    } catch (IOException exception) {
    }

    try {
      FileStream inFile = File.Open("test.txt", FileMode.Open, FileAccess.Read);
      StreamReader reader = new StreamReader(inFile);
      ret = ret && (char)reader.Read() == 'c';
      ret = ret && (char)reader.Peek() == 'o';
      char[] cb = new char[100];
      reader.Read(cb, 0, str.Length);
      string str2 = new string(cb);
      ret = ret && str.Equals(str2);
      ret = ret && (char)reader.Read() == '\n';
      ret = ret && (char)reader.Read() == 'd';
    } catch (IOException exception) {
    }

    try {
      FileStream binaryOutFile =
          new FileStream("binary-test.txt", FileMode.Create, FileAccess.Write);
      BinaryWriter dataOutFile = new BinaryWriter(binaryOutFile);
      dataOutFile.Write(Encoding.UTF8.GetBytes(str));
      int intNum = 10;
      dataOutFile.Write(intNum);
      double doubleNum = 3.14;
      dataOutFile.Write(doubleNum);
    } catch (IOException exception) {
    }

    try {
      FileStream binaryInFile = new FileStream("binary-test.txt", FileMode.Open, FileAccess.Read);
      BinaryReader dataInFile = new BinaryReader(binaryInFile);
      byte[] bytes = new byte[Encoding.UTF8.GetByteCount(str)];
      bytes = dataInFile.ReadBytes(bytes.Length);
      string str2 = Encoding.UTF8.GetString(bytes);
      ret = ret && str.Equals(str2);
      int intNum = dataInFile.ReadInt32();
      ret = ret && intNum == 10;
      double doubleNum = dataInFile.ReadDouble();
      ret = ret && doubleNum == 3.14;
      long length = binaryInFile.Length;
      ret = ret && length == 18;
      binaryInFile.Close();
    } catch (IOException exception) {
    }

    try {
      FileStream randomAccessFile = new FileStream("test.txt", FileMode.Open, FileAccess.ReadWrite);
      randomAccessFile.Seek(3, SeekOrigin.Begin);
      ret = ret && (char)randomAccessFile.ReadByte() == 't';
      ret = ret && randomAccessFile.Position == 4;
      randomAccessFile.Write(new[] { (byte)'e' });
      randomAccessFile.Seek(4, SeekOrigin.Begin);
      ret = ret && (char)randomAccessFile.ReadByte() == 'e';
    } catch (IOException exception) {
    }

    if (!ret)
      Console.WriteLine("Fstream Test Failed!");
    return ret;
  }
}