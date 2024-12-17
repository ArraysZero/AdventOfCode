// #include <cstdlib>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readFile(char name[]) {
	char * buffer = 0;
	long length;
	FILE * f = fopen (name, "rb");

	if (f) {
		fseek (f, 0, SEEK_END);
		length = ftell (f);
		fseek (f, 0, SEEK_SET);
		buffer = (char *)malloc (length + 1);
		if (buffer){
			fread (buffer, 1, length, f);
		}
		buffer[length] = '\0';
		fclose (f);
	}
	// FILE *file = fopen(name, "r");
	// char* buffer = (char *) malloc(1);
	// int bufferSize = 0;

	// if (file == NULL) {
	// 	printf("file does not exist");
	// 	return NULL;
	// }

	// fread(&buffer, 1, 1, file);
	
	// char c;
	// while ((c = fgetc(file)) != EOF) {
	// 	// do something
	// 	bufferSize++;
	// 	buffer = (char *) realloc(&buffer, bufferSize);

	// 	buffer[bufferSize - 1] = c;
	// }

	return buffer;
}