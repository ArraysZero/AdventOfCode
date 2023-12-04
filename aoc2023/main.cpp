#include <iostream>
#include "includes/reader.cpp"
#include "includes/days/day_1.cpp"

// int function() {
// 	return 1;
// }

int main() {
	// int num = '9' - '0';
	// std::cout << "Hello World! \n" << num;

	Reader reader;

	DayOne dayOne(reader.read("input/day1.txt"));

	dayOne.puzzleOne();

	// string input = reader.read("input/test.txt");

	// Reader reader (5);

	// std::cout << "\n\n" << reader.getVar();

	return 0;
}