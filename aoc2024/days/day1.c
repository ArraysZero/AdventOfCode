
#include <stdio.h>
int day1p1(char *input) {
  int list1[1], list2[1];

  int i = 0;
  int length = 0;
  int list = 1;

  while (input[i]) {
    if (input[i] >= '0' && input[i] <= '9') {
      printf("input: %d\n", input[i] - '0');
      if (list == 1) {
        length++;
        list = 2;
        int list[length];
        int n = 0;
        int num = input[i] - '0';
        // printf("%d\n", num);

        for (int d = 0; d < length; d++) {
          if (num > list1[n]) {
            // printf("%d", num);
            list[d] = num;
            num = -1;
          } else {
            list[d] = list1[n];
            n++;
          }
        }
        list1 = list;
      } else {
        list = 1;
        int list[length];
        int n = 0;
        int num = input[i] - '0';

        for (int d = 0; d < length; d++) {
          if (num > list2[n]) {
            list[d] = num;
            num = -1;
          } else {
            list[d] = list2[n];
            n++;
          }
        }
      }
    }
    i++;
  }

  int diff = 0;
  for (i = 0; i < length; i++) {
    printf("list1: %d   list2: %d\n", list1[i], list2[i]);
    if (list1[i] > list2[i]) {
      diff += (list1[i] - list2[i]);
    } else {
      diff += (list2[i] - list1[i]);
    }
  }

  return diff;
}