namespace CodeCsharp.Base.CCType; 

public class CTypeEntry {
  private static readonly char ConstChar = ' ';

  public static void CTypeProgram() {
    bool b1 = Char.IsLetterOrDigit(ConstChar);
    bool b2 = Char.IsLetter(ConstChar);
    bool b3 = Char.IsLower(ConstChar);
    bool b4 = Char.IsUpper(ConstChar);
    bool b5 = Char.IsDigit(ConstChar);
    bool b6 = Uri.IsHexDigit(ConstChar);
    bool b7 = Char.IsControl(ConstChar);
    bool b8 = Char.IsWhiteSpace(ConstChar);
    bool b9 = Char.IsSeparator(ConstChar);
    bool b10 = !Char.IsControl(ConstChar);
    bool b11 = !Char.IsControl(ConstChar) && !Char.IsSeparator(ConstChar);
    bool b12 = Char.IsPunctuation(ConstChar);
    char c1 = Char.ToLower(ConstChar);
    char c2 = Char.ToUpper(ConstChar);
  }
}