#include <cctype>
#include "ctype_entry.h"

void CtypeEntry::CTypeProgram() {
  bool b1 = isalnum(kConstChar);
  bool b2 = isalpha(kConstChar);
  bool b3 = islower(kConstChar);
  bool b4 = isupper(kConstChar);
  bool b5 = isdigit(kConstChar);
  bool b6 = isxdigit(kConstChar);
  bool b7 = iscntrl(kConstChar);
  bool b8 = isspace(kConstChar);
  bool b9 = kConstChar == ' ';
  bool b10 = isprint(kConstChar);
  bool b11= isgraph(kConstChar);
  bool b12 = ispunct(kConstChar);
  char c1 = (char)tolower(kConstChar);
  char c2 = (char)toupper(kConstChar);
}
