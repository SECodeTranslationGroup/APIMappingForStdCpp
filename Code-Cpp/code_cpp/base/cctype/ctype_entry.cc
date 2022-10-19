#include "ctype_entry.h"
#include "../misc/example_object.h"

void CtypeEntry::CTypeProgram() {
  char c = ' ';
  bool b1 = isalnum(c);
  bool b2 = isalpha(c);
  bool b3 = islower(c);
  bool b4 = isupper(c);
  bool b5 = isdigit(c);
  bool b6 = isxdigit(c);
  bool b7 = iscntrl(c);
  bool b8 = isspace(c);
  bool b9 = c == ' ';
  bool b10 = isprint(c);
  bool b11 = isgraph(c);
  bool b12 = ispunct(c);
  char c1 = (char)tolower(c);
  char c2 = (char)toupper(c);
}

bool CtypeEntry::Test1() {
  bool ret = true;
  ret = ret && isalnum('7') && isalnum('a') && isalnum('A') && !isalnum('\0') && !isalnum(' ');
  ret = ret && !isalpha('7') && isalpha('a') && isalpha('A') && !isalpha('\0') && !isalpha(' ');
  ret = ret && isdigit('7') && !isdigit('a') && !isdigit('A') && !isdigit('x') && !isdigit('U');
  ret = ret && isxdigit('7') && isxdigit('a') && isxdigit('A') && !isxdigit('x') && !isxdigit('U');
  return ret;
}
bool CtypeEntry::Test2() {
  bool ret = true;
  ret = ret && !islower('7') && islower('a') && !islower('A') && !islower('\0') && !islower(' ');
  ret = ret && !isupper('7') && !isupper('a') && isupper('A') && !isupper('\0') && !isupper(' ');
  ret = ret && (tolower('C') == 'c') && (tolower('c') == 'c') && tolower('9') == '9' && tolower('\0') == '\0';
  ret = ret && (toupper('C') == 'C') && (toupper('c') == 'C') && toupper('9') == '9' && toupper('\0') == '\0';
  return ret;
}
bool CtypeEntry::Test3() {
  bool ret = true;
  ret = ret && iscntrl('\0') && iscntrl('\b') && iscntrl('\t') && !iscntrl(' ') && !iscntrl('C');
  ret = ret && !isprint('\0') && !isprint('\b') && !isprint('\t') && isprint(' ') && isprint('C');
  ret = ret && !isgraph('\0') && !isgraph('\b') && !isgraph('\t') && !isgraph(' ') && isgraph('C');
  return ret;
}
bool CtypeEntry::Test4() {
  bool ret = true;
  ret = ret && !isspace('\0') && !isspace('\b') && isspace('\t') && isspace(' ') && !isspace('C');
  ret = ret && !('\0' == ' ') && !('\b' == ' ') && !('\t' == ' ') && (' ' == ' ') && !('c' == ' ');
  return ret;
}
bool CtypeEntry::Test5() {
  bool ret = true;
  ret = ret && !ispunct('\0') && !ispunct('\b') && !ispunct('\t') && !ispunct(' ') && !ispunct('C');
  ret = ret && ispunct(',') && ispunct('!') && ispunct('/') && ispunct(':') && ispunct('?');
  return ret;
}
bool CtypeEntry::TestAll() {
  bool test = Test1() && Test2() && Test3() && Test4() && Test5();
  if (!test)
    std::cout << "Ctype Test Failed!";
  return test;
}
