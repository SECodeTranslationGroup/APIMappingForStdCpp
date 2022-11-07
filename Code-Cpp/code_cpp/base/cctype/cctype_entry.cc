#include "cctype_entry.h"
#include "../misc/example_object.h"
#include <vector>

void CctypeEntry::CctypeProgram() {
  //initialize char
  char c = ' ';
  //whether char is letter or number
  bool b1 = isalnum(c);
  //whether char is letter
  bool b2 = isalpha(c);
  //whether char is lowercase letter
  bool b3 = islower(c);
  //whether char is uppercase letter
  bool b4 = isupper(c);
  //whether char is number
  bool b5 = isdigit(c);
  //whether char is hex number
  bool b6 = isxdigit(c);
  //whether char is control character
  bool b7 = iscntrl(c);
  //whether char is white space character
  bool b8 = isspace(c);
  //whether char is space character
  bool b9 = c == ' ';
  //whether char is printable
  bool b10 = isprint(c);
  //whether char has graph representation
  bool b11 = isgraph(c);
  //whether char is punctuation character
  bool b12 = ispunct(c);
  //change uppercase letter to lowercase letter
  char c1 = (char)tolower(c);
  //change uppercase letter to lowercase letter
  char c2 = (char)toupper(c);
}

bool CctypeEntry::TestAll() {
  bool ret = true;
  using namespace std;
  ret = tolower('C') == 'c' && tolower('c') == 'c'
      && tolower('9') == '9' && tolower('\0') == '\0'
      && toupper('C') == 'C' && toupper('c') == 'C'
      && toupper('9') == '9' && toupper('\0') == '\0'
      && isalnum('7') && isalnum('a') && isalnum('A') && !isalnum('\0') && !isalnum(' ')
      && !isalpha('7') && isalpha('a') && isalpha('A') && !isalpha('\0') && !isalpha(' ')
      && isdigit('7') && !isdigit('a') && !isdigit('A') && !isdigit('x') && !isdigit('U')
      && isxdigit('7') && isxdigit('a') && isxdigit('A') && !isxdigit('x') && !isxdigit('U')
      && !islower('7') && islower('a') && !islower('A') && !islower('\0') && !islower(' ')
      && !isupper('7') && !isupper('a') && isupper('A') && !isupper('\0') && !isupper(' ')
      && iscntrl('\0') && iscntrl('\b') && iscntrl('\t') && !iscntrl(' ') && !iscntrl('C')
      && !isprint('\0') && !isprint('\b') && !isprint('\t') && isprint(' ') && isprint('C')
      && !isgraph('\0') && !isgraph('\b') && !isgraph('\t') && !isgraph(' ') && isgraph('C')
      && !isspace('\0') && !isspace('\b') && isspace('\t') && isspace(' ') && !isspace('C')
      && !('\0' == ' ') && !('\b' == ' ') && !('\t' == ' ') && (' ' == ' ') && !('c' == ' ')
      && !ispunct('\0') && !ispunct('\b') && !ispunct('\t') && !ispunct(' ') && !ispunct('C')
      && ispunct(',') && ispunct('!') && ispunct('/') && ispunct(':') && ispunct('?');
  if (!ret)
    cout << "Ctype Test Failed!" << endl;
  return ret;
}
