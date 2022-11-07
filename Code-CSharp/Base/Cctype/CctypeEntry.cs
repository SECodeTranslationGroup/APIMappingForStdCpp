namespace CodeCsharp.Base.CCType;

public class CctypeEntry {
  public static void CctypeProgram() {
    //initialize char
    char c = ' ';
    //whether char is letter or number
    bool b1 = Char.IsLetterOrDigit(c);
    //whether char is letter
    bool b2 = Char.IsLetter(c);
    //whether char is lowercase letter
    bool b3 = Char.IsLower(c);
    //whether char is uppercase letter
    bool b4 = Char.IsUpper(c);
    //whether char is number
    bool b5 = Char.IsDigit(c);
    //whether char is hex number
    bool b6 = Uri.IsHexDigit(c);
    //whether char is control character
    bool b7 = Char.IsControl(c);
    //whether char is white space character
    bool b8 = Char.IsWhiteSpace(c);
    //whether char is space character
    bool b9 = Char.IsSeparator(c);
    //whether char is printable
    bool b10 = !Char.IsControl(c);
    //whether char has graph representation
    bool b11 = !Char.IsControl(c) && !Char.IsSeparator(c);
    //whether char is punctuation character
    bool b12 = Char.IsPunctuation(c);
    //change uppercase letter to lowercase letter
    char c1 = Char.ToLower(c);
    //change uppercase letter to lowercase letter
    char c2 = Char.ToUpper(c);
  }

  public static bool TestAll() {
    bool ret = true;
    ret = Char.ToLower('C') == 'c' && Char.ToLower('c') == 'c'
        && Char.ToLower('9') == '9' && Char.ToLower('\0') == '\0'
        && Char.ToUpper('C') == 'C' && Char.ToUpper('c') == 'C'
        && Char.ToUpper('9') == '9' && Char.ToUpper('\0') == '\0'
        && Char.IsLetterOrDigit('7') && Char.IsLetterOrDigit('a') && Char.IsLetterOrDigit('A')
        && !Char.IsLetterOrDigit('\0') && !Char.IsLetterOrDigit(' ')
        && !Char.IsLetter('7') && Char.IsLetter('a') && Char.IsLetter('A')
        && !Char.IsLetter('\0') && !Char.IsLetter(' ')
        && Char.IsDigit('7') && !Char.IsDigit('a') && !Char.IsDigit('A')
        && !Char.IsDigit('x') && !Char.IsDigit('U')
        && Uri.IsHexDigit('7') && Uri.IsHexDigit('a')  && Uri.IsHexDigit('A')
        && !Uri.IsHexDigit('X') && !Uri.IsHexDigit('U')
        && !Char.IsLower('7') && Char.IsLower('a') && !Char.IsLower('A')
        && !Char.IsLower('\0') && !Char.IsLower(' ')
        && !Char.IsUpper('7') && !Char.IsUpper('a') && Char.IsUpper('A')
        && !Char.IsUpper('\0') && !Char.IsUpper(' ')
        && Char.IsControl('\0') && Char.IsControl('\b') && Char.IsControl('\t')
        && !Char.IsControl(' ') && !Char.IsControl('C')
        && Char.IsControl('\0') && Char.IsControl('\b') && Char.IsControl('\t')
        && !Char.IsControl(' ') && !Char.IsControl('C')
        && (Char.IsControl('\0') || Char.IsSeparator('\0'))
        && (Char.IsControl('\b') || Char.IsSeparator('\b'))
        && (Char.IsControl('\t') || Char.IsSeparator('\t'))
        && (Char.IsControl(' ') || Char.IsSeparator(' '))
        && !Char.IsControl('C') && !Char.IsSeparator('\0')
        && !Char.IsWhiteSpace('\0') && !Char.IsWhiteSpace('\b') && Char.IsWhiteSpace('\t')
        && Char.IsWhiteSpace(' ') && !Char.IsWhiteSpace('C')
        && !Char.IsSeparator('\0') && !Char.IsSeparator('\b') && !Char.IsSeparator('\t')
        && Char.IsSeparator(' ') && !Char.IsSeparator('c')
        && !Char.IsPunctuation('\0') && !Char.IsPunctuation('\b')
        && !Char.IsPunctuation('\t') && !Char.IsPunctuation(' ')
        && !Char.IsPunctuation('C') && Char.IsPunctuation(',')
        && Char.IsPunctuation('!') && Char.IsPunctuation('/')
        && Char.IsPunctuation(':') && Char.IsPunctuation('?');
    if (!ret)
      Console.WriteLine("Ctype Test Failed!");
    return ret;
  }
}