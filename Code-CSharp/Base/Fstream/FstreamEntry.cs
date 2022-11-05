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
      randomAccessFile.Write(new []{(byte)'d'});
      //close
      randomAccessFile.Close();
    } catch (IOException exception) {
    }
  }
}