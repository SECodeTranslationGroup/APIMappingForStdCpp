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
}