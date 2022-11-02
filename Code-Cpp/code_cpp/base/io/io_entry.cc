#include <string>
#include <cstdio>
#include <cstdlib>
#include <vector>
#include <iostream>
#include <cassert>

#include "io_entry.h"
void IoEntry::IoProgram() {
  const char FileString[] = "FILENAME.txt";
  char buf[] = "1234567891234567891";
  char read_buf[20];
  read_buf[19] = '\0';

  // Creating tmp file and will be renamed to "current" directory
  std::remove(FileString);
  char file[L_tmpnam];
  std::tmpnam(file);
  std::cout << file << '\n';

  // File open
  std::FILE * fp = std::fopen(file, "w+");
  if( !fp){
    std::cout << "Sb" <<std::endl;
    exit(0);
  }

  // File write
  std::size_t size_fwrite = std::fwrite(&buf, sizeof(buf[0]), sizeof(buf)-1, fp);
  assert( size_fwrite == 19 );

  // Set file pointer to the beginning
  std::rewind(fp);

  // File read
  std::size_t size_fread = std::fread(&read_buf, sizeof(read_buf[0]), sizeof(read_buf)-1 , fp);
  assert( size_fread == 19 );

  // Write one char into file
  char c = 'c';
  int wc = std::fputc(c, fp);

  std::ungetc(wc, fp);
  std::fflush(fp);
  // Note: Return value is int instead of char
  int rc = std::fgetc(fp);
  assert((char)rc == c);

  // Flush between consecutive read and write.
  // Q: why is this error happening?
  std::fseek(fp, 0, SEEK_CUR);

  // Note: fputs return a non-negative value instead of writing length
  long pos = std::ftell(fp);
  int non_negative = std::fputs("Hello, World!", fp);
  std::fseek(fp, pos, SEEK_SET);

  char s_fgets[10];
  s_fgets[9] = '\0';

  // fgets return a char *
  // Q: why is the first parameter not "&s_fgets"(type char *) compared to fread(type void *) function
  char* pointer_fgets = std::fgets(s_fgets, sizeof(s_fgets)-1, fp);
  std::cout << "111 "<<s_fgets << std::endl;

  std::fseek(fp, 0, SEEK_END);
  std::fprintf(fp, "\n");

  char s[] = "Hello";
  std::fpos_t pos_gs;

  std::fgetpos(fp, &pos_gs);
  std::fprintf(fp, "[%d]\t[%10s]\n", 10, s);
  std::fsetpos(fp, &pos_gs);

  std::printf("\t[%10s]\n", s);
  int a;
  char b[6] = {'\0'};
  std::fscanf(fp, "[%d] [ %5s]", &a, &b);
  assert(a == 10);
  assert(!std::strcmp(b, "Hello"));

  std::fclose(fp);
  std::rename(file, FileString);

  // Creates tmp file which be removed after program exit
  std::FILE* tmpf = std::tmpfile();
  std::fputs("Hello, world", tmpf);
  std::rewind(tmpf);
  char tmpf_buf[6];
  std::fgets(tmpf_buf, sizeof tmpf_buf, tmpf);
  std::cout << tmpf_buf << '\n';

}
