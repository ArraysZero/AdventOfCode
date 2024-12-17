#include "days/day1.c"
#include "reader/reader.h"
#include <stdio.h>

int main() {
  printf("Hello World!");

  char *buffer = readFile("inputTest");

  int i = 0;

  while (buffer[i]) {
    printf("%c", buffer[i]);
    i++;
  }

  printf("day 1 puzzle 1: ");

  int result = day1p1(buffer);

  printf("result: %d", result);

  return 0;
}