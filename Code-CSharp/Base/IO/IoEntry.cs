using System.ComponentModel;
using System.Security.Cryptography;
using System.Text;
using System.IO;

namespace CodeCsharp.Base.IO;

public class IoEntry
{
    public static void IoProgram() {
        string filename = "FILENAME.txt";
        byte[] buf = {0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39, 0x40};
        // tmp File Name
        string tmp = Path.GetTempFileName();

        FileStream tf = File.Create(tmp);
        // Close after create
        // If not, Create will occupy tf and operations of it will fail
        tf.Close();
        
        // delete File if exist
        if(File.Exists(filename)) File.Delete(filename);
        File.Move(tmp, filename);
        
        // File open
        FileStream fs = File.Open(filename, FileMode.Open);
        // File write
        fs.Write(buf, 0, buf.Length);
        fs.Flush();
        fs.Close();
        
        fs = File.Open(filename, FileMode.Open);
        // File read
        byte[] buf1 = new byte[10];
        int n = fs.Read(buf1, 0, buf1.Length);
        Console.Out.WriteLine(Encoding.ASCII.GetChars(buf1));
        fs.Close();

        using (StreamWriter sw = new StreamWriter(filename, true))
        {
            sw.WriteLine("This is a ababababababaaabababaabababa!");
            sw.WriteLine("Second line is also meaningless.");
            sw.WriteLine("This is the third line.");
        }
        
        using (StreamReader sr = new StreamReader(filename))
        {
            char[] c = new char[10];
            sr.Read(c, 0, c.Length);
            sr.Read(c, 0, c.Length);
            Console.WriteLine(c);

            //string line = sr.ReadLine();
            //Console.WriteLine(line);
        }
        
        StringWriter strWriter = new StringWriter();
        char[] charseq = "return 0;".ToCharArray();
        char a = ';';
        strWriter.Write(charseq, 0, 7);
        strWriter.Write("max(Alice.Money, Bob.Money)");
        char[] str1 = " >1000? me".ToCharArray();
        strWriter.Write(str1, 1, 5);
        strWriter.Write(a);
        
        strWriter.Write('\n');
        strWriter.Write("\\\\ Reconstruction! \n");
        char [] str2 = "uncompleted or fail".ToCharArray();
        strWriter.Write(str2, 2, 9);
        strWriter.Flush();
        
        string line = strWriter.ToString();
        Console.WriteLine(line);
        strWriter.Close();
        
        using (StringReader reader = new StringReader(line))
        {
            int c = reader.Peek();
            Console.Out.WriteLine((char )c);

            char[] re = new char[7];
            reader.Read(re, 0, re.Length);
            Console.Write(re);

            int d = reader.Read();
            Console.Out.WriteLine((char )d);
        }
        
        // string dfile = "FILENAME.dat";
        // BinaryReader

        // Random Access 
        fs = File.Open(filename, FileMode.Open);
        fs.Seek(10, SeekOrigin.Begin);
        int e = fs.ReadByte();
        Console.Out.WriteLine((char )e);
    }
}