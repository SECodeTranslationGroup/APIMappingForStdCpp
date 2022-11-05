namespace CodeCsharp.Base.IO.Fstream;

using System.Text;

public class FstreamEntry {
  public static void FstreamProgram() {
    string str = "output";
    bool isOpen = true;
    try {
      FileStream outFile = File.Open("file.txt", FileMode.Create, FileAccess.Write);
      StreamWriter writer = new StreamWriter(outFile);
      writer.Write('c');
      writer.WriteLine(str);
      outFile.Close();
    } catch (IOException exception) {
      isOpen = false;
    }

    try {
      FileStream inFile = File.Open("file.txt", FileMode.Open, FileAccess.Read);
      StreamReader reader = new StreamReader(inFile);
      char c1 = (char)reader.Read();
      char c2 = (char)reader.Peek();
      char[] cb = new char[100];
      reader.Read(cb, 0, str.Length);
      str = new string(cb);
      inFile.Close();
    } catch (IOException exception) {
    }

    try {
      FileStream appFile = File.Open("file.txt", FileMode.Append, FileAccess.Write);
      StreamWriter writer = new StreamWriter(appFile);
      writer.Write('c');
      appFile.Close();
    } catch (IOException exception) {
    }

    try {
      FileStream binaryOutFile = new FileStream("file.txt", FileMode.Create, FileAccess.Write);
      BinaryWriter dataOutFile = new BinaryWriter(binaryOutFile);
      dataOutFile.Write(Encoding.UTF8.GetBytes(str));
      int intNum = 10;
      dataOutFile.Write(intNum);
      double doubleNum = 3.14;
      dataOutFile.Write(doubleNum);
      binaryOutFile.Close();
    } catch (IOException exception) {
    }

    try {
      FileStream binaryInFile = new FileStream("file.txt", FileMode.Open, FileAccess.Read);
      BinaryReader dataInFile = new BinaryReader(binaryInFile);
      byte[] bytes = new byte[Encoding.UTF8.GetByteCount(str)];
      bytes = dataInFile.ReadBytes(bytes.Length);
      str = Encoding.UTF8.GetString(bytes);
      int intNum = dataInFile.ReadInt32();
      double doubleNum = dataInFile.ReadDouble();
      long length = binaryInFile.Length;
      binaryInFile.Close();
    } catch (IOException exception) {
    }

    try {
      FileStream randomAccessFile = new FileStream("file.txt", FileMode.Open, FileAccess.ReadWrite);
      randomAccessFile.Seek(3, SeekOrigin.Begin);
      char c3 = (char)randomAccessFile.ReadByte();
      long pos = randomAccessFile.Position;
      randomAccessFile.Write(new []{(byte)'d'});
      randomAccessFile.Close();
    } catch (IOException exception) {
    }
  }
}