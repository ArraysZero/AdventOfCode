#include <iostream>
#include "includes/reader.cpp"
#include "includes/days/day_1.cpp"
#include "includes/days/day_2.cpp"

// int function() {
// 	return 1;
// }

using namespace std;

int main() {
	// int num = '9' - '0';
	// std::cout << "Hello World! \n" << num;

	Reader reader;

	// DayOne dayOne(reader.read("input/day1.txt"));

	// dayOne.puzzleOne();

	DayTwo dayTwo(reader.read("input/day2.txt"));

	// dayTwo.puzzleOne();
	cout << dayTwo.puzzleOne();

	// string input = reader.read("input/test.txt");

	// Reader reader (5);

	// std::cout << "\n\n" << reader.getVar();

	return 0;
}